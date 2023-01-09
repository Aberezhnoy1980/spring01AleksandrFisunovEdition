package ru.aberezhnoy.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.aberezhnoy.dtos.CustomsDeclarationRequest;
import ru.aberezhnoy.dtos.StatisticsResponse;
import ru.aberezhnoy.entities.CustomsDeclaration;
import ru.aberezhnoy.exceptions.ResourceException;
import ru.aberezhnoy.exceptions.ResourceNotFoundException;
import ru.aberezhnoy.repositories.CustomsDeclarationRepository;
import ru.aberezhnoy.repositories.specifications.CustomsDeclarationSpecifications;
import ru.aberezhnoy.services.CustomsDeclarationServices;
import ru.aberezhnoy.utils.CustomsDeclarationStatusEnum;
import ru.aberezhnoy.utils.ExcelFileWriter;

import java.io.File;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.OptionalDouble;
import java.util.UUID;

import static java.util.function.Predicate.not;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomsDeclarationServicesImpl implements CustomsDeclarationServices {

    private final ExcelFileWriter excelFileWriter;
    private final CustomsDeclarationRepository customsDeclarationRepository;
    private final static StatisticsResponse ZERO_STATISTIC = StatisticsResponse.builder()
            .averageDeclarationTimeOfReleaseByLastMonth("N/A")
            .percentDeclarationFirstHalfOfTheDay(0)
            .percentDeclarationIssuedWithOneDayOfMonth(0)
            .quantityDeclarationInWork(0)
            .build();

    @Override
    public CustomsDeclaration findById(UUID id) {
        return customsDeclarationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Декларация с id:" + id + " не найдена"));
    }

    @Override
    public Page<CustomsDeclaration> findAll(Integer pageNo, Integer pageSize, String sortBy, String numberPart) {
        Specification<CustomsDeclaration> spec = Specification.where(null);
        if (numberPart != null) {
            spec = spec.and(CustomsDeclarationSpecifications.numberLike(numberPart));
        }
        return customsDeclarationRepository.findAll(spec, PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
    }

    @Override
    public UUID addCustomsDeclaration(CustomsDeclarationRequest customsDeclarationRequest) {
        UUID trace = UUID.randomUUID();
        log.info("Start save declaration declarationRequest={}, traceId={}", customsDeclarationRequest, trace);
        CustomsDeclaration customsDeclaration = CustomsDeclaration.builder()
                .status(CustomsDeclarationStatusEnum.FILED.name())
                .consignor(customsDeclarationRequest.getConsignor())
                .vatCode(customsDeclarationRequest.getVatCode())
                .invoiceData(customsDeclarationRequest.getInvoiceData())
                .goodsValue(customsDeclarationRequest.getGoodsValue())
                .dateOfSubmission(OffsetDateTime.now())
                .build();
        try {
            CustomsDeclaration declaration = customsDeclarationRepository.save(customsDeclaration);
            log.info("Declaration with id={} successfully saved, traceId={}", declaration.getId(), trace);
            return declaration.getId();
        } catch (DataIntegrityViolationException e) {
            log.error("Error save new declaration, error={}, traceId={}", e.getMessage(), trace);
            throw new ResourceException("Декларация " + customsDeclarationRequest + " не сохранена!");
        }
    }

    @Override
    public void deleteById(UUID id) {
        UUID trace = UUID.randomUUID();
        log.info("Start delete declaration id={}, traceId={}", id, trace);
        try {
            customsDeclarationRepository.deleteById(id);
            log.info("Declaration with id={} successfully deleted, traceId={}", id, trace);
        } catch (EmptyResultDataAccessException e) {
            log.error("Error delete declaration with id={}, error={}, traceId={}", id, e.getMessage(), trace);
            throw new ResourceException("Декларация с id=" + id + " не существует!");
        }
    }

    @Override
    public File export(String vatCode) {
        List<CustomsDeclaration> declarations = customsDeclarationRepository.findAll();
        return excelFileWriter.createExcelFile(declarations);
    }

    @Override
    public StatisticsResponse getStatistics() {
        List<CustomsDeclaration> totalDeclarations = customsDeclarationRepository.findAll();
        if(totalDeclarations.isEmpty()){
            return ZERO_STATISTIC;
        }
        List<CustomsDeclaration> customsDeclarationsByLastMonth = customsDeclarationRepository.getDeclarationOfSubmissionByLastMonth();
        if(customsDeclarationsByLastMonth.isEmpty()){
            return ZERO_STATISTIC;
        }
        return StatisticsResponse.builder()
                .averageDeclarationTimeOfReleaseByLastMonth(averageDeclarationTimeOfReleaseByLastMonth(customsDeclarationsByLastMonth))
                .percentDeclarationFirstHalfOfTheDay(percentDeclarationFirstHalfOfTheDay(customsDeclarationsByLastMonth))
                .percentDeclarationIssuedWithOneDayOfMonth(percentDeclarationIssuedWithOneDayOfMonth(customsDeclarationsByLastMonth, totalDeclarations))
                .quantityDeclarationInWork(quantityDeclarationInWork(totalDeclarations))
                .build();
    }


    private String averageDeclarationTimeOfReleaseByLastMonth(List<CustomsDeclaration> customsDeclarationsByLastMonth) {
        OptionalDouble averageTimeSeconds = customsDeclarationsByLastMonth.stream()
                .filter(c->c.getDateOfRelease()==null)
                .map(c -> c.getDateOfRelease().toEpochSecond() - c.getDateOfSubmission().toEpochSecond())
                .mapToLong(t -> t)
                .average();
        if(averageTimeSeconds.isPresent()) {
            return LocalTime.ofSecondOfDay((long) averageTimeSeconds.getAsDouble()).toString();
        }else {
            return "N/A";
        }
    }
    
    private Integer percentDeclarationFirstHalfOfTheDay(List<CustomsDeclaration> customsDeclarationsByLastMonth) {
        long countCustomDeclaration = customsDeclarationsByLastMonth.stream()
                .filter(c -> c.getDateOfSubmission().getHour() < 12)
                .count();
        return (int) (countCustomDeclaration/customsDeclarationsByLastMonth.size())*100;
    }

    private Integer percentDeclarationIssuedWithOneDayOfMonth(List<CustomsDeclaration> customsDeclarationsByLastMonth,
                                                              List<CustomsDeclaration> totalDeclarations) {
        return (customsDeclarationsByLastMonth.size()/totalDeclarations.size())*100;
    }

    private Integer quantityDeclarationInWork(List<CustomsDeclaration> customsDeclarationsAll) {
        long countCustomsDeclarationNoRelease = customsDeclarationsAll.stream()
                .filter(not(c -> c.getStatus().equals("RELEASE") || c.getStatus().equals("RELEASE_DENIED")))
                .count();
        return (int) (countCustomsDeclarationNoRelease/customsDeclarationsAll.size())*100;
    }

}

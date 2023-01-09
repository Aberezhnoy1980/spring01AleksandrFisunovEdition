package ru.aberezhnoy.services;

import org.springframework.data.domain.Page;
import ru.aberezhnoy.dtos.CustomsDeclarationRequest;
import ru.aberezhnoy.dtos.StatisticsResponse;
import ru.aberezhnoy.entities.CustomsDeclaration;

import java.io.File;
import java.util.UUID;

public interface CustomsDeclarationServices {

    CustomsDeclaration findById(UUID id);

    Page<CustomsDeclaration> findAll(Integer pageNo, Integer pageSize, String sortBy, String numberPart);

    UUID addCustomsDeclaration(CustomsDeclarationRequest customsDeclarationRequest);

    void deleteById(UUID id);

    StatisticsResponse getStatistics();

    File export(String vatCode);

}

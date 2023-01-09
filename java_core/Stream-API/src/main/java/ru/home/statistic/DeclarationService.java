package ru.home.statistic;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DeclarationService {

    private static final DeclarationRepository declarationRepository = new DeclarationRepository();

    public LocalTime getAverageDurationOfRelease() {
        return LocalTime.ofSecondOfDay((long) declarationRepository.getDeclarations()
                .stream()
                .mapToLong(declaration -> Duration
                        .between(declaration
                                .getDateOfSubmission(), declaration.getDateOfRelease())
                        .toSeconds())
                .average().orElseThrow(IllegalArgumentException::new));
    }

    public Double getShareOfSubmittedDeclarationsBeforeNoonByMonth() {
        return Math.round(((double) declarationRepository.getDeclarations()
                .stream()
                .filter(declaration -> declaration.getDateOfSubmission().getMonth() == LocalDateTime.now().getMonth())
                .filter(declaration -> declaration.getDateOfSubmission().getHour() <= 12)
                .count() / declarationRepository.getDeclarations().size() * 100) * 10.0) / 10.0;
    }

    public Double getShareOfReleasedDeclarationsWithinOneDayByMonth() {
        return Math.round(((double) declarationRepository.getDeclarations()
                .stream()
                .filter(declaration -> declaration.getDateOfSubmission().getMonth() == LocalDateTime.now().getMonth())
                .mapToLong(declaration -> Duration
                        .between(declaration
                                .getDateOfSubmission(), declaration.getDateOfRelease())
                        .toHours())
                .filter(d -> d <= 24L)
                .count() / declarationRepository.getDeclarations().size() * 100) * 10.0) / 10.0;
    }

    public Long getDeclarationsCountInProgress() {
        return declarationRepository.getDeclarations()
                .stream()
                .filter(declaration -> declaration.getStatus() == CustomsDeclarationStatusEnum.SUBMITTED.name()).count();
    }

}

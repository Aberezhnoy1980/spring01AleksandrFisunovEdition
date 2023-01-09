package ru.home.statistic;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class StatTestApp {

    private static final DeclarationService declarationService = new DeclarationService();
    private static final DeclarationRepository declarationRepository = new DeclarationRepository();
    private static final List<Declaration> declarations= declarationRepository.getDeclarations();


    public static void main(String[] args) {

        System.out.println(Statistic
                .builder()
                .averageDurationOfRelease(LocalTime
                        .ofSecondOfDay((long) declarations
                                .stream()
                                .filter(d -> d.getStatus().equals(CustomsDeclarationStatusEnum.RELEASED.name()))
                                .mapToLong(declaration -> Duration
                                        .between(declaration
                                                .getDateOfSubmission(), declaration.getDateOfRelease())
                                        .toSeconds())
                                .average().orElseThrow(() -> new IllegalArgumentException("Data not available"))))
                .shareOfSubmittedDeclarationsBeforeNoonByMonth(Math.round(((double) declarations
                        .stream()
                        .filter(d -> d.getStatus().equals(CustomsDeclarationStatusEnum.SUBMITTED.name()))
                        .filter(declaration -> declaration.getDateOfSubmission().getMonth() == LocalDateTime.now().getMonth())
                        .filter(declaration -> declaration.getDateOfSubmission().getHour() <= 12)
                        .count() / declarations.size() * 100) * 10.0) / 10.0)
                .shareOfReleasedDeclarationsWithinOneDayByMonth(Math.round(((double) declarations
                        .stream()
                        .filter(declaration -> declaration.getDateOfSubmission().getMonth() == LocalDateTime.now().getMonth())
                        .mapToLong(declaration -> Duration
                                .between(declaration
                                        .getDateOfSubmission(), declaration.getDateOfRelease())
                                .toHours())
                        .filter(d -> d <= 24L)
                        .count() / declarations.size() * 100) * 10.0) / 10.0)
                .declarationsCountInProgress(declarations
                        .stream()
                        .filter(declaration -> !declaration.getStatus().equals(CustomsDeclarationStatusEnum.RELEASED.name()) || !declaration.getStatus().equals(CustomsDeclarationStatusEnum.CANCELED.name())).count())
                .build());
    }
}

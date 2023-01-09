package ru.home.funcProg;

import ru.home.statistic.CustomsDeclarationStatusEnum;
import ru.home.statistic.Declaration;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class StatisticApp {
    public static void main(String[] args) {
        List<Declaration> declarations = new ArrayList<>(Arrays.asList(
                new Declaration(1L, "1/2/3", CustomsDeclarationStatusEnum.RELEASED.name(), "Consignor1", "777777777", "ab-234", BigDecimal.valueOf(3), OffsetDateTime.of(
                        2020, 5, 20, 9, 10, 40,
                        50000, ZoneOffset.UTC), OffsetDateTime.of(
                        2020, 5, 20, 12, 30, 40,
                        50000, ZoneOffset.UTC)),
                new Declaration(2L, "4/5/6", CustomsDeclarationStatusEnum.SUBMITTED.name(), "Consignor1", "777777777", "ab-234", BigDecimal.valueOf(5), OffsetDateTime.of(
                        2020, 5, 20, 9, 10, 40,
                        50000, ZoneOffset.UTC), OffsetDateTime.of(
                        2020, 5, 20, 15, 50, 40,
                        50000, ZoneOffset.UTC)),
                new Declaration(3L, "7/8/9", CustomsDeclarationStatusEnum.CANCELED.name(), "Consignor1", "777777777", "ab-234", BigDecimal.valueOf(10), OffsetDateTime.of(
                        2020, 5, 20, 13, 10, 40,
                        50000, ZoneOffset.UTC), OffsetDateTime.of(
                        2020, 5, 20, 21, 45, 40,
                        50000, ZoneOffset.UTC))
        ));

        System.out.println(declarations.stream().filter(declaration -> declaration.getStatus() == CustomsDeclarationStatusEnum.RELEASED.name()).collect(Collectors.toList()));

        System.out.println(declarations.stream().mapToLong(declaration -> Duration.between(declaration.getDateOfSubmission(), declaration.getDateOfRelease()).toHours()).average());

        System.out.println(averageTimeOfReleaseByLastMonth(declarations));

        System.out.println(getShareOfSubmittedDeclarationsBeforeNoonByMonth(declarations));

        System.out.println(declarations.stream().map(declaration -> declaration.getDateOfSubmission().getHour()).collect(Collectors.toList()));
    }

    public static LocalTime averageTimeOfReleaseByLastMonth(List<Declaration> declarations) {
//        List<Declaration> customsDeclarations = customsDeclarationRepository.getDateOfSubmissionByLastMonth();
        List<Long> timeList = new ArrayList<>();
        declarations.forEach(c -> timeList.add(c.getDateOfRelease().toEpochSecond() - c.getDateOfSubmission().toEpochSecond()));
        long averageTimeSeconds = (long) timeList.stream().mapToLong(t -> t).average().getAsDouble();
        return LocalTime.ofSecondOfDay(averageTimeSeconds);
    }

    public static double getShareOfSubmittedDeclarationsBeforeNoonByMonth(List<Declaration> declarations) {

        return Math.round(((double) declarations
                        .stream()
                        .filter(declaration -> declaration.getDateOfSubmission().getHour() < 12)
                        .count() / declarations.size() * 100) * 10.0) / 10.0;
    }

    public double getShareOfReleasedDeclarationsWithinOneDayByMonth(List<Declaration> declarations) {
        return Math.round(((double) declarations
                .stream()
                .filter(declaration -> Duration
                        .between(declaration
                                .getDateOfSubmission(), declaration.getDateOfRelease())
                        .toHours() <= 24L)
                .count() / declarations.size() * 100) * 10.0) / 10.0;
    }
}














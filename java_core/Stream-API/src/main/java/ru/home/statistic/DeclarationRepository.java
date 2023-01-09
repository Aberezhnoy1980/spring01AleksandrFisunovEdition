package ru.home.statistic;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeclarationRepository {

    public final List<Declaration> declarations = new ArrayList<>(Arrays.asList(
            new Declaration(1L, "1/2/3", CustomsDeclarationStatusEnum.RELEASED.name(), "Consignor1", "777777777", "ab-234", BigDecimal.valueOf(3), OffsetDateTime.of(
                    2022, 11, 20, 9, 10, 40,
                    50000, ZoneOffset.UTC), OffsetDateTime.of(
                    2022, 11, 20, 12, 10, 40,
                    50000, ZoneOffset.UTC)),
            new Declaration(1L, "1/2/3", CustomsDeclarationStatusEnum.RELEASED.name(), "Consignor1", "777777777", "ab-234", BigDecimal.valueOf(3), OffsetDateTime.of(
                    2022, 11, 20, 9, 10, 40,
                    50000, ZoneOffset.UTC), OffsetDateTime.of(
                    2022, 11, 20, 16, 10, 40,
                    50000, ZoneOffset.UTC)),
            new Declaration(2L, "4/5/6", CustomsDeclarationStatusEnum.SUBMITTED.name(), "Consignor1", "777777777", "ab-234", BigDecimal.valueOf(5), OffsetDateTime.of(
                    2022, 12, 20, 9, 10, 40,
                    50000, ZoneOffset.UTC), OffsetDateTime.of(
                    2022, 12, 20, 15, 10, 40,
                    50000, ZoneOffset.UTC)),
            new Declaration(3L, "7/8/9", CustomsDeclarationStatusEnum.CANCELED.name(), "Consignor1", "777777777", "ab-234", BigDecimal.valueOf(10), OffsetDateTime.of(
                    2022, 12, 20, 13, 10, 40,
                    50000, ZoneOffset.UTC), OffsetDateTime.of(
                    2022, 12, 21, 19, 10, 40,
                    50000, ZoneOffset.UTC))
    ));

    public List<Declaration> getDeclarations() {
        return declarations;
    }
}

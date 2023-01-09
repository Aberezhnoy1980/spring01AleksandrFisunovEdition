package ru.aberezhnoy.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A Request for the {@link ru.ssemenov.entities.CustomsDeclaration} entity
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class CustomsDeclarationRequest implements Serializable {

    @NotBlank(message = "Поле наименование грузоотправителя обязательно для заполнения")
    @Schema(description = "Наименование грузоотправителя", required = true, example = "Trade inc")
    private final String consignor;

    @NotBlank(message = "Поле ИНН грузополучателя обязательно для заполнения")
    @Schema(description = "ИНН грузополучателя", required = true, example = "7777777777")
    private final String vatCode;

    @NotBlank(message = "Поле данные по инвойсу обязательно для заполнения")
    @Schema(description = "Данные по инвойсу", required = true, example = "ab-234")
    private final String invoiceData;

    @Min(1)
    @NotNull(message = "Поле фактурная стоимость груза обязательно для заполнения")
    @Schema(description = "Фактурная стоимость груза", required = true, example = "120000")
    private final BigDecimal goodsValue;
}

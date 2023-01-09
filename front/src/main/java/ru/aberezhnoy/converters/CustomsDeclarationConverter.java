package ru.aberezhnoy.converters;

import org.springframework.stereotype.Component;
import ru.aberezhnoy.dtos.CustomsDeclarationResponse;
import ru.aberezhnoy.entities.CustomsDeclaration;


/**
 * A converter to receive {@link CustomsDeclarationResponse} from {@link ru.aberezhnoy.entities.CustomsDeclaration} entity
 */
@Component
public class CustomsDeclarationConverter {
    public CustomsDeclarationResponse entityToDto(CustomsDeclaration c) {
        return CustomsDeclarationResponse.builder()
                .id(c.getId())
                .number(c.getNumber())
                .status(c.getStatus())
                .consignor(c.getConsignor())
                .vatCode(c.getVatCode())
                .invoiceData(c.getInvoiceData())
                .goodsValue(c.getGoodsValue())
                .dateOfSubmission(c.getDateOfSubmission())
                .dateOfRelease(c.getDateOfRelease())
                .build();
    }
}

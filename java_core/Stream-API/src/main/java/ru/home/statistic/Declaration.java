package ru.home.statistic;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Declaration {

    private Long id;

    private String number;

//    private Status status;

    private String status;

    private String consignor;

    private String vatCode;

    private String invoiceData;

    private BigDecimal goodsValue;

    private OffsetDateTime dateOfSubmission;

    private OffsetDateTime dateOfRelease;

        public Declaration(Long id, String number, String status, String consignor, String vatCode, String invoiceData, BigDecimal goodsValue, OffsetDateTime dateOfSubmission, OffsetDateTime dateOfRelease) {
                this.id = id;
                this.number = number;
                this.status = status;
                this.consignor = consignor;
                this.vatCode = vatCode;
                this.invoiceData = invoiceData;
                this.goodsValue = goodsValue;
                this.dateOfSubmission = dateOfSubmission;
                this.dateOfRelease = dateOfRelease;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNumber() {
                return number;
        }

        public void setNumber(String number) {
                this.number = number;
        }

//        public Status getStatus() {
//                return status;
//        }
//
//        public void setStatus(Status status) {
//                this.status = status;
//        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getConsignor() {
                return consignor;
        }

        public void setConsignor(String consignor) {
                this.consignor = consignor;
        }

        public String getVatCode() {
                return vatCode;
        }

        public void setVatCode(String vatCode) {
                this.vatCode = vatCode;
        }

        public String getInvoiceData() {
                return invoiceData;
        }

        public void setInvoiceData(String invoiceData) {
                this.invoiceData = invoiceData;
        }

        public BigDecimal getGoodsValue() {
                return goodsValue;
        }

        public void setGoodsValue(BigDecimal goodsValue) {
                this.goodsValue = goodsValue;
        }

        public OffsetDateTime getDateOfSubmission() {
                return dateOfSubmission;
        }

        public void setDateOfSubmission(OffsetDateTime dateOfSubmission) {
                this.dateOfSubmission = dateOfSubmission;
        }

        public OffsetDateTime getDateOfRelease() {
                return dateOfRelease;
        }

        public void setDateOfRelease(OffsetDateTime dateOfRelease) {
                this.dateOfRelease = dateOfRelease;
        }

        @Override
        public String toString() {
                return "Declaration{" +
                        "id=" + id +
                        ", number='" + number + '\'' +
                        ", status=" + status +
                        ", consignor='" + consignor + '\'' +
                        ", vatCode='" + vatCode + '\'' +
                        ", invoiceData='" + invoiceData + '\'' +
                        ", goodsValue=" + goodsValue +
                        ", dateOfSubmission=" + dateOfSubmission +
                        ", dateOfRelease=" + dateOfRelease +
                        '}';
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Declaration)) return false;
                Declaration that = (Declaration) o;
                return Objects.equals(getId(), that.getId()) && Objects.equals(getNumber(), that.getNumber()) && getStatus() == that.getStatus() && Objects.equals(getConsignor(), that.getConsignor()) && Objects.equals(getVatCode(), that.getVatCode()) && Objects.equals(getInvoiceData(), that.getInvoiceData()) && Objects.equals(getGoodsValue(), that.getGoodsValue()) && Objects.equals(getDateOfSubmission(), that.getDateOfSubmission()) && Objects.equals(getDateOfRelease(), that.getDateOfRelease());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getId(), getNumber(), getStatus(), getConsignor(), getVatCode(), getInvoiceData(), getGoodsValue(), getDateOfSubmission(), getDateOfRelease());
        }

//        public enum Status {
//                RELEASED, CANCELED, SUBMITTED
//        }
}

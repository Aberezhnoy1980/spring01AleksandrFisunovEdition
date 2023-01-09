package ru.home.builder;

public abstract class IndustrialBuilder {

     IndustrialUnit industrialUnit;

    void createIndustrial() {
        industrialUnit = new IndustrialUnit();
    }

    abstract void buildName();

    abstract void buildTemperature();

    abstract void buildPressure();

    abstract void buildVoltage();

    abstract void buildSupplierName();

    abstract void buildOperatingStatus();

    IndustrialUnit getIndustrialUnit() {
        return industrialUnit;
    }
}

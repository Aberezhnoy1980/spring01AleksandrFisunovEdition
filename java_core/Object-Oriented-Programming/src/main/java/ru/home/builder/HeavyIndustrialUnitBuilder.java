package ru.home.builder;

public class HeavyIndustrialUnitBuilder extends IndustrialBuilder {

    @Override
    void buildName() {
        industrialUnit.setName("Heavy Industry");
    }

    @Override
    void buildTemperature() {
        industrialUnit.setTemperature(1000.0f);
    }

    @Override
    void buildPressure() {
        industrialUnit.setPressure(500.0d);
    }

    @Override
    void buildVoltage() {
        industrialUnit.setVoltage(300);
    }

    @Override
    void buildSupplierName() {
        industrialUnit.setSupplierName("Heavy industry supplier");
    }

    @Override
    void buildOperatingStatus() {
        industrialUnit.setOperatingStatus(OperatingStatus.STOP);
    }
}

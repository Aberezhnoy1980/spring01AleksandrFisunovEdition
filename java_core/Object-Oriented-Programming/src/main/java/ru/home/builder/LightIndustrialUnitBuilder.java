package ru.home.builder;

public class LightIndustrialUnitBuilder extends IndustrialBuilder {

    @Override
    void buildName() {
        industrialUnit.setName("Light Industry");
    }

    @Override
    void buildTemperature() {
        industrialUnit.setTemperature(100.0f);
    }

    @Override
    void buildPressure() {
        industrialUnit.setPressure(10.0D);
    }

    @Override
    void buildVoltage() {
        industrialUnit.setVoltage(220);
    }

    @Override
    void buildSupplierName() {
        industrialUnit.setSupplierName("Light industry supplier");
    }

    @Override
    void buildOperatingStatus() {
        industrialUnit.setOperatingStatus(OperatingStatus.OPERATING);
    }
}

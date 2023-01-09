package ru.home.builder;

public class IndustrialUnit {
    private String name;
    private float temperature;
    private double pressure;
    private int voltage;
    private String supplierName;

    private OperatingStatus operatingStatus;

    public void setName(String name) {
        this.name = name;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setOperatingStatus(OperatingStatus operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    @Override
    public String toString() {
        return "Object: " + name + "\ntemperature: " + temperature + "\npressure: " + pressure + "\nvoltage: " + voltage + "\nsupplier: " + supplierName + "\nstatus: " + operatingStatus;
    }










}

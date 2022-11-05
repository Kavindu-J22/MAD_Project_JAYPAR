package com.example.car_service;

public class CarModel {

    String brand,ccAmount,modelYear,mileage;

    CarModel(){

    }

    public CarModel(String brand, String ccAmount, String modelYear, String mileage) {
        this.brand = brand;
        this.ccAmount = ccAmount;
        this.modelYear = modelYear;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCcAmount() {
        return ccAmount;
    }

    public void setCcAmount(String ccAmount) {
        this.ccAmount = ccAmount;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

}

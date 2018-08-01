package pl.coderslab.team2.entity;

import java.util.Date;

public class Vehicle {

    int vehicleID;
    String brand;
    String model;
    int productionYear;
    String licencePlate;
    Date nextTechnicalReview;
    int clientID;

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Date getNextTechnicalReview() {
        return nextTechnicalReview;
    }

    public void setNextTechnicalReview(String nextTechnicalReview) {
        this.nextTechnicalReview = nextTechnicalReview;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}

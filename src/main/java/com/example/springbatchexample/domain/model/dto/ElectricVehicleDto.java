package com.example.springbatchexample.domain.model.dto;

import lombok.Data;

@Data
public class ElectricVehicleDto {

    private String vin;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String modelYear;
    private String make;
    private String model;
    private String electricVehicleType;
    private String cleanAlternativeFuelVehicle;
    private String electricRange;
    private String baseMsrp;
    private String legislativeDistrict;
    private String vehicleId;
    private String vehicleLocation;
    private String electricUtility;
    private String censusTract;

}

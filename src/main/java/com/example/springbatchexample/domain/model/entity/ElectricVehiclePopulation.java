package com.example.springbatchexample.domain.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ELECTRIC_VEHICLE_POPULATION")
public class ElectricVehiclePopulation {

    @Id
    @GeneratedValue
    private Long id;

    private String vin;

    private String country;

    private String city;

    private String state;

    private Integer postalCode;

    private Integer modelYear;

    private String make;

    private String model;

    private String electricVehicleType;

    private String cleanAlternativeFuelVehicle;

    private Integer electricRange;

    private Integer baseMsrp;

    private Integer legislativeDistrict;

    private Long vehicleId;

    private String location;

    private String electricUtility;

    private String censusTract;

}

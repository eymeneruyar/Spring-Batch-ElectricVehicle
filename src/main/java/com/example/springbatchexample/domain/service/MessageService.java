package com.example.springbatchexample.domain.service;

import com.example.springbatchexample.domain.model.dto.ElectricVehicleDto;
import com.example.springbatchexample.domain.model.entity.ElectricVehiclePopulation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    public ElectricVehiclePopulation getElectricVehiclePopulationByReadData(ElectricVehicleDto dto){
        ElectricVehiclePopulation population = new ElectricVehiclePopulation();
        population.setVin(dto.getVin());
        population.setCountry(dto.getCountry());
        population.setCity(dto.getCity());
        population.setState(dto.getState());
        population.setPostalCode(Integer.getInteger(dto.getPostalCode()));
        population.setModelYear(Integer.getInteger(dto.getModelYear()));
        population.setMake(dto.getMake());
        population.setModel(dto.getModel());
        population.setElectricVehicleType(dto.getElectricVehicleType());
        population.setCleanAlternativeFuelVehicle(dto.getCleanAlternativeFuelVehicle());
        population.setElectricRange(Integer.getInteger(dto.getElectricRange()));
        population.setBaseMsrp(Integer.getInteger(dto.getBaseMsrp()));
        population.setLegislativeDistrict(Integer.getInteger(dto.getLegislativeDistrict()));
        population.setVehicleId(Long.getLong(dto.getVehicleId()));
        population.setLocation(dto.getVehicleLocation());
        population.setElectricUtility(dto.getElectricUtility());
        population.setCensusTract(dto.getCensusTract());
        return population;
    }

}

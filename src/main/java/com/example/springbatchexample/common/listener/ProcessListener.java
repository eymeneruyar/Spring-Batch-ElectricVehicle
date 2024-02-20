package com.example.springbatchexample.common.listener;

import com.example.springbatchexample.domain.model.dto.ElectricVehicleDto;
import com.example.springbatchexample.domain.model.entity.ElectricVehiclePopulation;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Service;

@Service
public class ProcessListener implements ItemProcessListener<ElectricVehicleDto, ElectricVehiclePopulation> {

    @Override
    public void beforeProcess(ElectricVehicleDto vehicleDto) {
    }

    @Override
    public void afterProcess(ElectricVehicleDto vehicleDto, ElectricVehiclePopulation vehiclePopulation) {
    }

    @Override
    public void onProcessError(ElectricVehicleDto vehicleDto, Exception e) {
    }

}

package com.example.springbatchexample.domain.job;

import com.example.springbatchexample.domain.model.dto.ElectricVehicleDto;
import com.example.springbatchexample.domain.model.entity.ElectricVehiclePopulation;
import com.example.springbatchexample.domain.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Processor implements ItemProcessor<ElectricVehicleDto, ElectricVehiclePopulation> {

    private final MessageService messageService;

    @Override
    public ElectricVehiclePopulation process(ElectricVehicleDto electricVehicle) throws Exception {
        //System.err.println(electricVehicle);
        return messageService.getElectricVehiclePopulationByReadData(electricVehicle);
    }

}

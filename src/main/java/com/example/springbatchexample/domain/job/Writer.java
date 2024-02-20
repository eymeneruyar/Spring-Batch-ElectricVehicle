package com.example.springbatchexample.domain.job;

import com.example.springbatchexample.domain.model.entity.ElectricVehiclePopulation;
import com.example.springbatchexample.domain.repository.ElectricVehiclePopulationRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Writer {

    private final ElectricVehiclePopulationRepository electricVehiclePopulationRepository;

    public RepositoryItemWriter<ElectricVehiclePopulation> writer(){
        RepositoryItemWriter<ElectricVehiclePopulation> writer = new RepositoryItemWriter<>();
        writer.setRepository(electricVehiclePopulationRepository);
        writer.setMethodName("save");
        return writer;
    }

}

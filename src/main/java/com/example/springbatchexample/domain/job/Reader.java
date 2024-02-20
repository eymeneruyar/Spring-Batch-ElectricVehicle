package com.example.springbatchexample.domain.job;

import com.example.springbatchexample.domain.model.dto.ElectricVehicleDto;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Reader {

    public FlatFileItemReader<ElectricVehicleDto> reader(){
        return new FlatFileItemReaderBuilder<ElectricVehicleDto>()
                .resource(new FileSystemResource("dataset/Electric_Vehicle_Population_Data.csv"))
                .saveState(false)
                .linesToSkip(1)
                .delimited()
                .names("vin","country","city","state","postalCode","modelYear","make","model","electricVehicleType","cleanAlternativeFuelVehicle","electricRange","baseMsrp","legislativeDistrict","vehicleId","vehicleLocation","electricUtility","censusTract")
                .targetType(ElectricVehicleDto.class)
                .build();
    }

}

package com.example.springbatchexample.domain.job;

import com.example.springbatchexample.common.listener.JobListener;
import com.example.springbatchexample.common.listener.ProcessListener;
import com.example.springbatchexample.common.listener.StepListener;
import com.example.springbatchexample.config.BatchConfig;
import com.example.springbatchexample.domain.model.dto.ElectricVehicleDto;
import com.example.springbatchexample.domain.model.entity.ElectricVehiclePopulation;
import com.example.springbatchexample.domain.properties.BatchProperties;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor
public class JobConfiguration {

    private final Writer writer;
    private final Reader reader;
    private final Processor processor;
    private final JobListener jobListener;
    private final BatchConfig batchConfig;
    private final StepListener stepListener;
    private final ProcessListener processListener;
    private final BatchProperties batchProperties;
    private final PlatformTransactionManager platformTransactionManager;

    @Bean
    public Step step(){
        return batchConfig.getStepBuilder("step")
                .<ElectricVehicleDto, ElectricVehiclePopulation>chunk(batchProperties.getStep().getChunkSize(),platformTransactionManager)
                .reader(reader.reader())
                .processor(processor)
                .listener(processListener)
                .writer(writer.writer())
                .taskExecutor(batchConfig.stepTaskExecutor())
                .listener(stepListener)
                .build();
    }

    @Bean
    public Job job(){
        return batchConfig.getJobBuilder("job")
                .start(step())
                .listener(jobListener)
                .build();
    }

}

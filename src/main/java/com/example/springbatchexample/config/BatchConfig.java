package com.example.springbatchexample.config;

import com.example.springbatchexample.common.constant.BatchConstant;
import com.example.springbatchexample.common.util.DateUtil;
import com.example.springbatchexample.common.util.VehicleExitCodeGenerator;
import com.example.springbatchexample.domain.properties.BatchProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.ExitCodeMapper;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@AllArgsConstructor
public class BatchConfig {

    private final JobRepository jobRepository;
    private final BatchProperties batchProperties;

    @Bean
    public ThreadPoolTaskExecutor stepTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(batchProperties.getStep().getMinPoolSize());
        taskExecutor.setMaxPoolSize(batchProperties.getStep().getMaxPoolSize());
        //taskExecutor.setTaskDecorator(); TODO: TaskDecorator'ü anlayıp ekleyelim. https://medium.com/att-israel/dont-lose-your-thread-manage-and-decorate-your-concurrent-threads-391cf34e6bc6#id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg1ZTU1MTA3NDY2YjdlMjk4MzYxOTljNThjNzU4MWY1YjkyM2JlNDQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDU2ODA5MDM4MTI2MDg4MjM5MTMiLCJlbWFpbCI6ImVydXlhcmV5bWVuQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJuYmYiOjE3MDY4MTkwMTgsIm5hbWUiOiJFecO8cCBFeW1lbiBFUlVZQVIiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUNnOG9jSzZZNUxfem1ET1RudmlaZVdfWGlONE1fMnlfSm9CS3g2QUZBaUotUElPSFE9czk2LWMiLCJnaXZlbl9uYW1lIjoiRXnDvHAgRXltZW4iLCJmYW1pbHlfbmFtZSI6IkVSVVlBUiIsImxvY2FsZSI6InRyIiwiaWF0IjoxNzA2ODE5MzE4LCJleHAiOjE3MDY4MjI5MTgsImp0aSI6ImUzNDQ1NGQ2NGY2N2Q5OWI3YjliMjkyODcwNTBjMGNkY2Y4YmI0ZDcifQ.Oug3bNkbZAQZcSo6nvIIx9ZVfTIGw3Co-mUXnFOdg73iQfD3-prFey3x0hQ1Kh37qsNXwAyD7lwYOH6RDIqqjq-bt0DQzj65SMFC4JN0OuedpUsWfEIoqhOHcTonJCvKl3G5Z9GN6DO7i-ixL1qibJYU_BEJOmdRaCI3KYsIDuHvRWmINjNx2t9R8Oax0GXpxDTDwy3af6YtbPwigs1Reedlwx3E7EdQavntPTEVzupXkWqGy4pFBhG_OA_izrCqRMloNMfRCnV29Qd1UzZ5I3eZmxS6q71jdwdwf455H346pVtqURcqreE3nZ87LS4DDIqEwALy5c799jOKgcJJCA
        taskExecutor.setThreadNamePrefix(BatchConstant.STEP_THREAD_NAME_PREFIX);
        return taskExecutor;
    }

    public JobBuilder getJobBuilder(String jobName){
        return new JobBuilder(jobName,jobRepository); //TODO: Listener eklenmeli mi araştır?
    }

    public StepBuilder getStepBuilder(String stepName){
        return new StepBuilder(stepName,jobRepository); //TODO: Listener eklenmeli mi araştır?
    }

    @Bean
    public ExitCodeMapper exitCodeMapper(){
        return new VehicleExitCodeGenerator();
    }

}

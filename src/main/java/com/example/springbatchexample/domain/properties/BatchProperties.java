package com.example.springbatchexample.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@ConfigurationProperties(prefix = "batch-parameter")
public class BatchProperties {

    @NestedConfigurationProperty
    private StepProperties step;

    @NestedConfigurationProperty
    private TaskProperties task;

}

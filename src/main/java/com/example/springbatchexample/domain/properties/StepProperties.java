package com.example.springbatchexample.domain.properties;

import lombok.Data;

@Data
public class StepProperties {
    private int fetchSize;
    private int chunkSize;
    private int minPoolSize;
    private int maxPoolSize;
}

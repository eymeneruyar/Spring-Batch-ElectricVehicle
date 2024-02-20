package com.example.springbatchexample.domain.properties;

import lombok.Data;

@Data
public class TaskProperties {
    private int minPoolSize;
    private int maxPoolSize;
}

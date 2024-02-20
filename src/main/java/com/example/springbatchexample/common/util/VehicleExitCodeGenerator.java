package com.example.springbatchexample.common.util;

import org.springframework.batch.core.launch.support.ExitCodeMapper;

import static com.example.springbatchexample.common.constant.BatchConstant.*;

public class VehicleExitCodeGenerator implements ExitCodeMapper{

    @Override
    public int intValue(String exitStatus) {
        return switch (exitStatus) {
            case UNKNOWN -> -1;
            case EXECUTING -> 0;
            case COMPLETED -> 1;
            case NOOP -> 0;
            case FAILED -> -1;
            case STOPPED -> 0;
            default -> 0;
        };
    }

}

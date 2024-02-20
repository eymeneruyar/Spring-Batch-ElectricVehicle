package com.example.springbatchexample.common.constant;

public class BatchConstant {

    private BatchConstant(){}

    public static final String STEP_THREAD_NAME_PREFIX = "Step";

    //Batch Exit Status
    public static final String UNKNOWN = "UNKNOWN";
    public static final String EXECUTING = "EXECUTING";
    public static final String COMPLETED = "COMPLETED";
    public static final String NOOP = "NOOP";
    public static final String FAILED = "FAILED";
    public static final String STOPPED =  "STOPPED";

}

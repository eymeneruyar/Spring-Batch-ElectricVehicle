package com.example.springbatchexample;

import com.example.springbatchexample.common.Tuple;
import com.example.springbatchexample.common.util.DateUtil;
import com.example.springbatchexample.config.BatchConfig;
import lombok.AllArgsConstructor;
import org.slf4j.MDC;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CommandLineJobRunner implements ApplicationRunner {

    private final BatchConfig batchConfig;
    private final JobLauncher jobLauncher;
    private final ApplicationContext applicationContext;

    private static final String OPT_JOB_NAME = "jobName";
    private static final String OPT_JOB_PARAMETERS = "jobParameters";
    private static final String OPT_JOB_PRM_KEY_VALUE_SEPARATOR = "#";

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String jobName = getJobName(args);
            MDC.put(OPT_JOB_NAME,jobName);
            Job job = getJob(jobName);
            JobExecution jobExecution = jobLauncher.run(job,getJobParameters(args));
            String exitStatus = jobExecution.getExitStatus().getExitCode();
            //System.out.println("Batch Job Exit Code: " + exitStatus);
            int customExitCode = batchConfig.exitCodeMapper().intValue(exitStatus);
            //System.out.println("Custom Exit Code: " + customExitCode);
        }finally {
            MDC.clear();
        }

    }

    private String getJobName(ApplicationArguments args){
        List<String> options = args.getOptionValues(OPT_JOB_NAME);
        Assert.notNull(options,String.format("'%s' job name must be provided", OPT_JOB_NAME));
        Assert.isTrue(options.size() == 1,String.format("'%s' job must be provided once",OPT_JOB_NAME));
        return options.get(0);
    }

    private Job getJob(String jobName){
        return applicationContext.getBean(jobName,Job.class);
    }

    private JobParameters getJobParameters(ApplicationArguments args){
        return new JobParametersBuilder(new JobParameters(parseJobProperties(args.getOptionValues(OPT_JOB_PARAMETERS))))
                .addLong("time", DateUtil.getCurrentTimeMillis()).toJobParameters();
    }

    //TODO: Bu metodu multi key-value parametre alacak şekilde düzenleyelim.
    private Map<String, JobParameter<?>> parseJobProperties(List<String> jobParameters){
        Map<String,JobParameter<?>> map = new HashMap<>();
        if(jobParameters != null){
            jobParameters.forEach(param -> {
                Tuple<String,String> keyValue = Tuple.build(param.split(OPT_JOB_PRM_KEY_VALUE_SEPARATOR));
                map.put(keyValue.getFirst(), new JobParameter<>(keyValue.getSecond(),String.class));
            });
        }
        return map;
    }

}

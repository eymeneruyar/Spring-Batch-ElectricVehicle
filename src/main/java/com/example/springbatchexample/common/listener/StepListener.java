package com.example.springbatchexample.common.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class StepListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Step named {} started",stepExecution.getStepName());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("Step named {} finished",stepExecution.getStepName());
        log.info("{} summary: {}",stepExecution.getStepName(), stepExecution.getSummary());
        return null;
    }

}

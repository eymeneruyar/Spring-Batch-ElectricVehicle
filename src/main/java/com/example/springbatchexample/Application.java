package com.example.springbatchexample;

import com.example.springbatchexample.domain.properties.BatchProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(BatchProperties.class)
public class Application {

    public static void main(String[] args) {
        try {
            ApplicationContext context = SpringApplication.run(Application.class, args);
            System.exit(SpringApplication.exit(context));
        }catch (Exception e){
            log.error("Application Error : {}", e.toString());
            System.exit(-1);
        }

    }

}

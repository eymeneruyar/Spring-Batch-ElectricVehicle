package com.example.springbatchexample.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
    //TODO: Bu class'a ihitiyaç var mı düşünelim
/*
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JpaTransactionManager getJpaTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(getDataSource());
        return jpaTransactionManager;
    }*/

}

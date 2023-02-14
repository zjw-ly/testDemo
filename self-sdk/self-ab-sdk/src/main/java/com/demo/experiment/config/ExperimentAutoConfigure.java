package com.demo.experiment.config;

import com.demo.experiment.diamond.ExperimentConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动化实验测试
 *
 * @author zaochun.zjw
 * @date 2023/2/10
 */
@Configuration
public class ExperimentAutoConfigure {

    @Bean(value = "experimentConfig", initMethod = "init")
    public ExperimentConfig getExperimentConfig() {
        return new ExperimentConfig();
    }
}

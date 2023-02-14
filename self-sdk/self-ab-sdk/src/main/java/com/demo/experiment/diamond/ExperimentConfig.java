package com.demo.experiment.diamond;

import com.demo.experiment.domain.entity.Experiment;

import java.util.ArrayList;
import java.util.List;

/**
 * 实验自动配置
 *
 * @author zaochun.zjw
 * @date 2023/2/10
 */
public class ExperimentConfig {


    private static final String DATA_ID = "alihealth-experiment-config.json";

    private static final String DIAMOND_GROUP = "DEFAULT_GROUP";

    private static List<Experiment> experiments = new ArrayList<>(16);

    public void init() {

    }

    /**
     * 获取实验配置
     *
     * @return 实验配置
     */
    public static List<Experiment> getExperiments() {
        return experiments;
    }

    private static class ExperimentConfigListener {

    }
}

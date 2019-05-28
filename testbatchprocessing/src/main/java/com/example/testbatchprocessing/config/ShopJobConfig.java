package com.example.testbatchprocessing.config;

import com.example.testbatchprocessing.mapper.PeopleMessageMapper;
import com.example.testbatchprocessing.pojo.People;
import com.example.testbatchprocessing.task.ShopTask;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;

/**
 * @file: ShopJobConfig.class
 * @author: Dusk
 * @since: 2019/5/12 20:38
 * @desc:
 */
// 介绍Spring Batch 中Tasklet 和 Chunks  https://blog.csdn.net/neweastsun/article/details/88866837
@Configuration
@EnableBatchProcessing
public class ShopJobConfig {
    public ShopJobConfig() {
        System.out.println("ShopJobConfig");
    }

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ShopTask shopTask;

    @Bean
    @Lazy
    public Job job1(Step step1) {
        System.out.println("job1");
        return jobBuilderFactory.get("shopJob").incrementer(new RunIdIncrementer()).start(step1).build();
    }

    @Bean
    @Lazy
    public Step step1() {
        MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();
        adapter.setTargetObject(shopTask);
        adapter.setTargetMethod("doTask");
        System.out.println("step1");
        return stepBuilderFactory.get("shopJobStep1").tasklet(adapter)
                .build();
    }
}

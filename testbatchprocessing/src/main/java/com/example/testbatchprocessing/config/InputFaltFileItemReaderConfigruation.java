package com.example.testbatchprocessing.config;


import com.example.testbatchprocessing.mapper.PeopleMessageMapper;
import com.example.testbatchprocessing.pojo.People;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * @file: InputFaltFileItemReaderConfigruation.class
 * @author: Dusk
 * @since: 2019/5/11 17:50
 * @desc: 地址 https://blog.51cto.com/13501268/2176808
 */
//@Configuration
//@EnableBatchProcessing
//public class InputFaltFileItemReaderConfigruation {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    @Qualifier("FlatFileWriterDemo")
//    private ItemWriter<? super People> FlatFileWriterDemo;
//
//    @Value("classpath*:/data/init/springbatchtest*.csv")
//    private Resource[] resources;
//
//    @Autowired
//    @Qualifier("FlatFileReadDemo2")
//    private ItemReader<People> FlatFileReadDemo;
//
//    @Primary
//    @Bean
//    public Job helloWord(Step step1) {
//        return jobBuilderFactory.get("helloWordJob").start(step1).build();
//    }
//
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1").tasklet(new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println("Hello Spring Batch....");
//                return RepeatStatus.FINISHED;
//            }
//        }).build();
//    }
//
//
//    @Bean
//    public Job faltFileItemReaderJob(Step faltFileItemReaderJobStep) {
//        /**
//         * spring batch 按照唯一作业参数执行
//         * https://blog.csdn.net/u013174217/article/details/56495502
//         *  新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
//         */
//        return jobBuilderFactory.get("faltFileItemReaderJob").incrementer(new RunIdIncrementer()).start(faltFileItemReaderJobStep).build();
//    }
//
//    @Bean
//    public Step faltFileItemReaderJobStep(MultiResourceItemReader multiResourceItemReader) {
//        return stepBuilderFactory.get("faltFileItemReaderJobStep")
//                .<People, People>chunk(100)
//                .reader(multiResourceItemReader)
//
//                .writer(FlatFileWriterDemo)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public MultiResourceItemReader<People> multiResourceItemReader(FlatFileItemReader flatFileItemReader) {
//        MultiResourceItemReader<People> reader = new MultiResourceItemReader<>();
//        reader.setDelegate(flatFileItemReader);
//        reader.setResources(resources);
//        return reader;
//    }
//
//    @Bean
//    @StepScope
//    public FlatFileItemReader<People> faltFileReaderDemo() {
//        FlatFileItemReader<People> reader = new FlatFileItemReader<>();
//        // reader.setResource(new ClassPathResource("/data/init/springbatchtest3.csv"));
//        reader.setLinesToSkip(3);
//        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//        tokenizer.setNames(new String[]{
//                "name", "age", "school", "wealth"
//        });
//        DefaultLineMapper<People> lineMapper = new DefaultLineMapper<>();
//        lineMapper.setLineTokenizer(tokenizer);
//        lineMapper.setFieldSetMapper(new PeopleMessageMapper());
//        lineMapper.afterPropertiesSet();
//        reader.setLineMapper(lineMapper);
//        return reader;
//    }
//
//
//
// }

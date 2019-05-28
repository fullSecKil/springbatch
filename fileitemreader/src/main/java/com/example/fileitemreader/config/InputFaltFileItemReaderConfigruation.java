package com.example.fileitemreader.config;

import com.example.fileitemreader.mapper.PeopleMessageMapper;
import com.example.fileitemreader.pojo.People;
import com.example.fileitemreader.pojo.ResultMessage;
import com.example.fileitemreader.processor.PeopleProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @file: InputFaltFileItemReaderConfigruation.class
 * @author: Dusk
 * @since: 2019/5/11 17:50
 * @desc:
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
//    private ItemWriter<? super ResultMessage> flatFileWriterDemo;
//
//    @Autowired
//    private ItemProcessor peopleProcessor;
//
//    @Autowired
//    private PeopleMessageMapper peopleMessageMapper;
//
//    @Value("classpath*:/data/init/springbatchtest*.csv")
//    private Resource[] resources;
//
//    @Bean
//    public Job FaltFileItemReaderJob(Step FaltFileItemReaderJobStep) {
//        return jobBuilderFactory.get("FaltFileItemReaderJob").incrementer(new RunIdIncrementer()).start(FaltFileItemReaderJobStep).build();
//    }
//
//    @Bean
//    public Step FaltFileItemReaderJobStep(MultiResourceItemReader multiResourceItemReader) {
//        return stepBuilderFactory.get("FaltFileItemReaderJobStep")
//                .<People, ResultMessage>chunk(100)
//                .reader(multiResourceItemReader)
//                .processor(peopleProcessor)
//                .writer(flatFileWriterDemo)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public MultiResourceItemReader<People> multiResourceItemReader(@Qualifier("peopleFlatFileItemReader") FlatFileItemReader flatFileItemReader) {
//        MultiResourceItemReader<People> reader = new MultiResourceItemReader<>();
//        reader.setDelegate(flatFileItemReader);
//        reader.setResources(resources);
//        return reader;
//    }
//
//    @Bean("peopleFlatFileItemReader")
//    @StepScope
//    public FlatFileItemReader<? extends People> FaltFileReaderDemo() {
//        FlatFileItemReader<People> reader = new FlatFileItemReader<>();
//        // ClassPathResource classPathResource = new ClassPathResource("/data/init/springbatchtest1.xlsx");
//        reader.setLinesToSkip(3);
//        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//        tokenizer.setNames(new String[]{
//                "name", "age", "school", "wealth"
//        });
//        DefaultLineMapper<People> lineMapper = new DefaultLineMapper<>();
//        lineMapper.setLineTokenizer(tokenizer);
//        lineMapper.setFieldSetMapper(peopleMessageMapper);
//        lineMapper.afterPropertiesSet();
//        reader.setLineMapper(lineMapper);
//        return reader;
//    }
//}

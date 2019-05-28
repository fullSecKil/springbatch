package com.example.fileitemreader.config;

import com.example.fileitemreader.mapper.FeeRecordMessageMapper;
import com.example.fileitemreader.pojo.FeeRecord;
import com.example.fileitemreader.pojo.FeeRecordMessage;
import com.example.fileitemreader.processor.FeeRecordProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;

/**
 * @file: InputFeeRecordItemReaderConfigruation.class
 * @author: Dusk
 * @since: 2019/5/16 11:24
 * @desc:
 */
@Configuration
@EnableBatchProcessing
@Lazy
public class InputFeeRecordItemReaderConfigruation {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Value("classpath*:/data/init/csv/SINANO_*.csv")
    private Resource[] resources;

    @Autowired
    @Qualifier("feeRecordMessageMapper")
    private FieldSetMapper feeRecordMessageMapper;

    @Autowired
    @Qualifier("feeRecordProcessor")
    private ItemProcessor<FeeRecord, FeeRecordMessage> feeRecordProcessor;

    @Autowired
    @Qualifier("feeRecordWriter")
    private ItemWriter<? super FeeRecordMessage> feeRecordWriter;


    @Bean
    @Qualifier("feeRecordItemReaderJobStep")
    public Job FeeRecordItemReaderJob(Step feeRecordItemReaderJobStep) {
        return jobBuilderFactory.get("FeeRecordItemReaderJob").incrementer(new RunIdIncrementer()).start(feeRecordItemReaderJobStep).build();
    }

    @Bean("feeRecordItemReaderJobStep")
    @Qualifier("feeRecordMultiResourceItemReader")
    public Step FeeRecordItemReaderJobStep(MultiResourceItemReader multiResourceItemReader) {
        return stepBuilderFactory.get("FeeRecordItemReaderJobStep")
                .<FeeRecord, FeeRecordMessage>chunk(100)
                .reader(multiResourceItemReader)
                .processor(feeRecordProcessor)
                .writer(feeRecordWriter)
                .build();
    }

    @Bean("feeRecordMultiResourceItemReader")
    @Qualifier("feeRecordFlatFileItemReader")
    @StepScope
    public MultiResourceItemReader<? extends FeeRecord> multiResourceItemReader(FlatFileItemReader flatFileItemReader) {
        MultiResourceItemReader<FeeRecord> reader = new MultiResourceItemReader<>();
        reader.setDelegate(flatFileItemReader);
        reader.setResources(resources);
        return reader;
    }

    @Bean("feeRecordFlatFileItemReader")
    @StepScope
    public FlatFileItemReader<? extends FeeRecord> FeeRecordItemReader() {
        FlatFileItemReader<FeeRecord> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(2);
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(new String[]{
                "machineName", "totalAmount", "samplesNumber",
                "date", "checkInTime", "checkOutTime", "remark",
                "unit", "payer", "username", "mobile", "email"
        });
        DefaultLineMapper<FeeRecord> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(feeRecordMessageMapper);
        lineMapper.afterPropertiesSet();
        reader.setLineMapper(lineMapper);
        return reader;
    }
}

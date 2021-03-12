package com.aubrun.eric.projet7.spring_batch.config;

import com.aubrun.eric.projet7.spring_batch.model.BorrowingTransaction;
import com.aubrun.eric.projet7.spring_batch.items.RestBorrowingTransactionReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<BorrowingTransaction> borrowingTransactionItemReader;
    @Autowired
    private ItemWriter<BorrowingTransaction> borrowingTransactionItemWriter;
    @Autowired
    private ItemProcessor<BorrowingTransaction, BorrowingTransaction> borrowingTransactionItemProcessor;

    @Bean
    public Job borrowingJob() {
        Step step = stepBuilderFactory.get("step-load-data")
                .<BorrowingTransaction, BorrowingTransaction>chunk(10)
                .reader(borrowingTransactionItemReader)
                .processor(borrowingTransactionItemProcessor)
                .writer(borrowingTransactionItemWriter)
                .build();
        return jobBuilderFactory.get("borrowing-data-loader-job")
                .start(step).build();
    }

    @Bean
    public ItemReader<BorrowingTransaction> itemReader(Environment environment,
                                                       RestTemplate restTemplate) {
        return new RestBorrowingTransactionReader(environment.getRequiredProperty("rest.api.url"),
                restTemplate
        );
    }
}

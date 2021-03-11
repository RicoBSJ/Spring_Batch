package com.aubrun.eric.projet7.spring_batch.config;

import com.aubrun.eric.projet7.spring_batch.model.BorrowingTransaction;
import com.aubrun.eric.projet7.spring_batch.reader.RestBorrowingTransactionReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JobConfig {

    private static final String PROPERTY_REST_API_URL = "rest.api.url";

    @Bean
    public ItemReader<BorrowingTransaction> itemReader(Environment environment, RestTemplate restTemplate) {
        return new RestBorrowingTransactionReader(environment.getRequiredProperty(PROPERTY_REST_API_URL), restTemplate);
    }

    @Bean
    public Step jobStep(ItemReader<BorrowingTransaction> reader,
                        ItemWriter<BorrowingTransaction> writer,
                        StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("jobStep")
                .<BorrowingTransaction, BorrowingTransaction>chunk(1)
                .reader(reader)
                .writer(writer)
                .build();
    }

    @Bean
    public Job job(Step jobStep,
                   JobBuilderFactory jobBuilderFactory) {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(jobStep)
                .end()
                .build();
    }
}

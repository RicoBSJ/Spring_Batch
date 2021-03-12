package com.aubrun.eric.projet7.spring_batch.config;

import com.aubrun.eric.projet7.spring_batch.model.BatchDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<BatchDto> batchDtoItemReader;
    @Autowired
    private ItemWriter<BatchDto> batchDtoItemWriter;
    @Autowired
    private ItemProcessor<BatchDto, BatchDto> batchDtoItemProcessor;

    @Bean
    public Job borrowingJob() {
        Step step = stepBuilderFactory.get("step-load-data")
                .<BatchDto, BatchDto>chunk(10)
                .reader(batchDtoItemReader)
                .processor(batchDtoItemProcessor)
                .writer(batchDtoItemWriter)
                .build();
        return jobBuilderFactory.get("borrowing-data-loader-job")
                .start(step).build();
    }
}

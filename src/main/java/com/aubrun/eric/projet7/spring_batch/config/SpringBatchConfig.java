package com.aubrun.eric.projet7.spring_batch.config;

import com.aubrun.eric.projet7.spring_batch.model.BorrowingTransaction;
import com.aubrun.eric.projet7.spring_batch.reader.RestBorrowingTransactionReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
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
        Step step1 = stepBuilderFactory.get("step-load-data")
                .<BorrowingTransaction, BorrowingTransaction>chunk(100)
                .reader(borrowingTransactionItemReader)
                .processor(borrowingTransactionItemProcessor)
                .writer(borrowingTransactionItemWriter)
                .build();
        return jobBuilderFactory.get("borrowing-data-loader-job")
                .start(step1).build();
    }

    /*@Bean
    public FlatFileItemReader<BorrowingTransaction> flatFileItemReader(@Value("${inputFile}") Resource inputFile) {
        FlatFileItemReader<BorrowingTransaction> fileItemReader = new FlatFileItemReader<>();
        fileItemReader.setName("FFIR1");
        fileItemReader.setLinesToSkip(1);
        fileItemReader.setResource(inputFile);
        fileItemReader.setLineMapper(lineMappe());
        return fileItemReader;
    }*/

    @Bean
    public ItemReader<BorrowingTransaction> itemReader(Environment environment,
                                                       RestTemplate restTemplate) {
        return new RestBorrowingTransactionReader(environment.getRequiredProperty("rest.api.url"),
                restTemplate
        );
    }

    @Bean
    public LineMapper<BorrowingTransaction> lineMappe() {
        DefaultLineMapper<BorrowingTransaction> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("borrowingId", "bookBorrowing", "userAccountBorrowing", "strEndTransactionDate", "renewal");
        lineMapper.setLineTokenizer(lineTokenizer);
        BeanWrapperFieldSetMapper<BorrowingTransaction> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BorrowingTransaction.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
}

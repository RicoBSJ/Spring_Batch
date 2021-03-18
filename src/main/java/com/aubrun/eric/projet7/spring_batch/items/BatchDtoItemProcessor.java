package com.aubrun.eric.projet7.spring_batch.items;

import com.aubrun.eric.projet7.spring_batch.model.BatchDto;
import io.micrometer.core.lang.NonNull;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class BatchDtoItemProcessor implements ItemProcessor<BatchDto, BatchDto> {

    @Override
    public BatchDto process(@NonNull BatchDto batchDto) throws Exception {

        return batchDto;
    }
}

package com.aubrun.eric.projet7.spring_batch.items;

import com.aubrun.eric.projet7.spring_batch.model.BatchDto;
import io.micrometer.core.lang.NonNull;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatchDtoItemWriter implements ItemWriter<BatchDto> {

    @Override
    public void write(@NonNull List<? extends BatchDto> list) throws Exception {

        //autowire le restemplate dans la classe
        //boucler sur le liste de batchDto
        //pour chaque élément appeler le endpoint qui envoie le mail
    }
}
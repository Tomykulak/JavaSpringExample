package com.example.javaspringpreparation.utils.data;

import com.example.javaspringpreparation.domain.example.Example;
import com.example.javaspringpreparation.domain.example.ExampleService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//
@Service
// creates automatic logging log.info(), log.error()
@Slf4j

public class DataImporter {
    private final ResourceLoader resourceLoader;
    private final ExampleService exampleService;

    @Autowired
    public DataImporter(ResourceLoader resourceLoader, ExampleService exampleService) {
        this.resourceLoader = resourceLoader;
        this.exampleService = exampleService;
    }

    @PostConstruct
    @Transactional
    public void init() {
        log.info("DataImporter init");
        Resource resource = resourceLoader.getResource("classpath:data/example.csv");
        List<Example> exampleList = parseExamples(resource);
        exampleService.saveMany(exampleList);
    }


    public List<Example> parseExamples(Resource resource) {
        List<Example> exampleList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(resource.getFile()))) {
            reader.readNext();
            String[] line;
            while((line = reader.readNext()) != null){
                Example example = new Example();
                example.setId(Long.valueOf(line[0]));
                example.setName(line[1]);
                example.setType1(line[2]);
                exampleList.add(example);
            }
        } catch (IOException | CsvValidationException e) {
            log.error(e.getMessage());
        }
        return exampleList;
    }
}

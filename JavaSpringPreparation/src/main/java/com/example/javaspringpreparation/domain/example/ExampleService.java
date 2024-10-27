package com.example.javaspringpreparation.domain.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {
    private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public void saveMany(List<Example> examples) {
        exampleRepository.saveAll(examples);
    }

    public List<Example> findAll() {
        return (List<Example>) exampleRepository.findAll();
    }
}

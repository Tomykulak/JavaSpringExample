package com.example.javaspringpreparation.domain.example;


import com.example.javaspringpreparation.utils.response.ArrayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/examples")
@Validated
public class ExampleController {

    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping(value = "", produces = "application/json")
    @Valid
    public ArrayResponse<ExampleResponse> getExamples() {
        List<Example> examples = exampleService.findAll();
        return ArrayResponse.of(
                examples,
                ExampleResponse::new
        );
    }
}

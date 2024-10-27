package com.example.javaspringpreparation.domain.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleResponse {
    private long id;
    private String name;
    private String type1;

    public ExampleResponse(Example example) {
        this.id = example.getId();
        this.name = example.getName();
        this.type1 = example.getType1();
    }
}

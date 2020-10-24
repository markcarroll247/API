package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    private final UUID id;

    @NotBlank // only accepts name if its not blank
    private final String name;

    public Person(@JsonProperty ("id") UUID id, // this is the property that will be in the Json request on Postman
                  @JsonProperty ("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

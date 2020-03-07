package com.sapient.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StarWarsErrorResponse {
    private final String errorMessage;

    @JsonCreator
    public StarWarsErrorResponse(@JsonProperty("errorMessage") String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

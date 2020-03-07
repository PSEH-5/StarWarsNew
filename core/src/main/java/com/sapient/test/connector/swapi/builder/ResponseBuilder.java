package com.sapient.test.connector.swapi.builder;

import com.sapient.test.StarWarsResponse;
import com.sapient.test.connector.swapi.dto.Result;
import com.sapient.test.connector.swapi.dto.SwapiResponse;

import java.util.List;
import java.util.Optional;

public class ResponseBuilder {
    public static Optional<StarWarsResponse> buildIfPresent(SwapiResponse swapiResponse, String name, StarWarsResponse.Type type) {
        List<Result> results = swapiResponse.getResults();
        for(Result result : results) {
            if(result.getName().equalsIgnoreCase(name)) {

                return Optional.of(new StarWarsResponse(type, swapiResponse.getCount(), name, result.getFilms()));
            }
        }
        return Optional.empty();
    }
}

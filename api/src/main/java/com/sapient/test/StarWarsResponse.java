package com.sapient.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

public class StarWarsResponse {
    private final Type type;
    private final int count;
    private final String name;
    private final List<String> films;

    @JsonCreator
    public StarWarsResponse(@JsonProperty("type") Type type, @JsonProperty("count") int count, @JsonProperty("name") String name, @JsonProperty("films") List<String> films) {
        this.type = type;
        this.count = count;
        this.name = name;
        this.films = films;
    }

    public Type getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public List<String> getFilms() {
        return films;
    }

    public enum Type {
        //Planets, Spaceships, Vehicles, People, Films and Species
        Planets, Spaceships, Vehicles, People, Films, Species;

        public static Optional<Type> getValueIfPresent(String type) {
            for(StarWarsResponse.Type starWarsType : StarWarsResponse.Type.values()) {
                if(starWarsType.name().equalsIgnoreCase(type)) {
                    return Optional.of(starWarsType);
                }
            }
            return Optional.empty();
        }
    }
}

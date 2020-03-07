package com.sapient.test;

import com.sapient.test.StarWarsResponse;

public interface StarWarsService {
    StarWarsResponse get(String name, String type);
}

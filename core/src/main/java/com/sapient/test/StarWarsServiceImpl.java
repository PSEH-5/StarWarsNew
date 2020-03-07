package com.sapient.test;

import com.sapient.test.connector.StarWarsExtApiConnector;

import java.util.Optional;

public class StarWarsServiceImpl implements StarWarsService {

    private StarWarsExtApiConnector starWarsExtApiConnector;
    public StarWarsServiceImpl(StarWarsExtApiConnector starWarsExtApiConnector) {
        this.starWarsExtApiConnector = starWarsExtApiConnector;
    }

    @Override
    public StarWarsResponse get(String name, String type) {
        Optional<StarWarsResponse.Type> starWarsType = StarWarsResponse.Type.getValueIfPresent(type);
        if(!starWarsType.isPresent()) {
            throw new IllegalArgumentException("Type not found : " + type);
        }
        return starWarsExtApiConnector.get(name, starWarsType.get());
    }
}

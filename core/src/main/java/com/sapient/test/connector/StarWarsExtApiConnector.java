package com.sapient.test.connector;

import com.sapient.test.StarWarsResponse;

public interface StarWarsExtApiConnector {
    StarWarsResponse get(String name, StarWarsResponse.Type type);
}

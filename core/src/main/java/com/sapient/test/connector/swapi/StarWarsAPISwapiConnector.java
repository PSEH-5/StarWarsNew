package com.sapient.test.connector.swapi;

import com.sapient.test.StarWarsResponse;
import com.sapient.test.connector.StarWarsExtApiConnector;
import com.sapient.test.connector.swapi.builder.ResponseBuilder;
import com.sapient.test.connector.swapi.dto.SwapiResponse;
import com.sapient.test.utils.RestUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class StarWarsAPISwapiConnector implements StarWarsExtApiConnector {

    private final RestUtil restUtil;
    private final String URL = "https://swapi.co/api/";
    public StarWarsAPISwapiConnector(RestUtil restUtil) {
        this.restUtil = restUtil;
    }

    @Override
    public StarWarsResponse get(String name, StarWarsResponse.Type type) {
        SwapiResponse swapiResponse = getSwapiResponse(URL, type);
        Optional<StarWarsResponse> starWarsResponseOptional = ResponseBuilder.buildIfPresent(swapiResponse, name, type);
        while(!starWarsResponseOptional.isPresent() && StringUtils.isNotBlank(swapiResponse.getNext())) {
            swapiResponse = getSwapiResponse(swapiResponse.getNext(), type);
            starWarsResponseOptional = ResponseBuilder.buildIfPresent(swapiResponse, name, type);
        }
        return starWarsResponseOptional.orElse(null);
    }

    private SwapiResponse getSwapiResponse(String url, StarWarsResponse.Type type) {
        return restUtil.get(url+type.name().toLowerCase()+"/", SwapiResponse.class);
    }
}

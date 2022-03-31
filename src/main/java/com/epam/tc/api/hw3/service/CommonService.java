package com.epam.tc.api.hw3.service;

import static io.restassured.RestAssured.given;

import com.epam.tc.api.hw3.utils.EndPoints;
import com.epam.tc.api.hw3.utils.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class CommonService {

    public static final String KEY = PropertiesReader.getProperty("key");
    public static final String TOKEN = PropertiesReader.getProperty("token");
    private RequestSpecification requestSpecification;

    public RequestSpecification getRequestSpecification() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = new RequestSpecBuilder()
            .setBaseUri(EndPoints.BASE_URL)
            .addQueryParam("key", KEY)
            .addQueryParam("token", TOKEN)
            .build();

        return requestSpecification;
    }

    public Response postWithParams(String uri, Map<String, String> params) {

        requestSpecification = given(getRequestSpecification())
            .contentType("application/json; charset=utf-8")
            .accept("application/json");
        for (Map.Entry<String, String> param : params.entrySet()) {
            requestSpecification.queryParam(param.getKey(), param.getValue());
        }

        return requestSpecification.post(uri);
    }

    public Response getNoParams(String uri) {

        return given(getRequestSpecification())
            .get(uri);
    }

    public Response deleteNoParams(String uri) {

        return RestAssured.given(getRequestSpecification())
                          .delete(uri);
    }

    public Response getWithParams(String uri, Map<String, Object> params) {

        RequestSpecification specification = given(getRequestSpecification());
        for (Map.Entry<String, Object> param : params.entrySet()) {
            specification.param(param.getKey(), param.getValue());
        }

        return specification.get(uri);
    }

    public Response putWithParams(String uri, Map<String, String> params) {

        requestSpecification = given(getRequestSpecification())
            .contentType("application/json; charset=utf-8")
            .accept("application/json");
        for (Map.Entry<String, String> param : params.entrySet()) {
            requestSpecification.queryParam(param.getKey(), param.getValue());
        }

        return requestSpecification.put(uri).then().extract().response();
    }
}

package com.epam.tc.api.hw3.service;

import static io.restassured.RestAssured.given;

import com.epam.tc.api.hw3.utils.TestData;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class CommonService {

    private RequestSpecification requestSpecification;

    public CommonService() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = new RequestSpecBuilder()
            .setBaseUri(TestData.BASE_URL)
            .setContentType(ContentType.JSON)
            .addQueryParam("key", TestData.KEY)
            .addQueryParam("token", TestData.TOKEN)
            .build();
    }

    public Response postWithParams(String uri, Map<String, String> params) {
        requestSpecification = given(requestSpecification)
            .contentType("application/json; charset=utf-8")
            .accept("application/json");
        for (Map.Entry<String, String> param : params.entrySet()) {
            requestSpecification.queryParam(param.getKey(), param.getValue());
        }
        return requestSpecification.post(uri);
    }

    public Response getNoParams(String uri) {
        return given(requestSpecification)
                          .get(uri);
    }

    public Response deleteNoParams(String uri) {
        return given(requestSpecification)
                          .delete(uri);
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(requestSpecification);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            specification.param(param.getKey(), param.getValue());
        }
        return specification.get(uri);
    }






}

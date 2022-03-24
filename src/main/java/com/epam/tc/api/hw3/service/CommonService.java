package com.epam.tc.api.hw3.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

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


}

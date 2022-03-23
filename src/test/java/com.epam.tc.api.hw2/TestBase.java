package com.epam.tc.api.hw2;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static RequestSpecification reqSpec;
    protected static ResponseSpecification respSpec;

    @BeforeSuite
    public void setUp() {

        reqSpec = new RequestSpecBuilder()
            .setBaseUri(TestData.BASE_URL)
            .setContentType(ContentType.JSON)
            .addQueryParam("key", TestData.KEY)
            .addQueryParam("token", TestData.TOKEN)
            .build();

        respSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectHeader("X-Trello-Environment", "Production")
            .build();
    }
}

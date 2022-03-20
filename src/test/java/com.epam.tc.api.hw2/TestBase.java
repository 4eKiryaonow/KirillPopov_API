package com.epam.tc.api.hw2;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static RequestSpecBuilder reqBuilder;
    protected static RequestSpecification reqSpec;

    protected static final String KEY = "8f2f59fccc451d87a60ba0c738ae563f";
    protected static final String TOKEN = "dd617d5909eb64c1d2f31f54b74db8a31a3495d74faf38df5e844822aabfdcf7";

    protected static final String BASE_URL = "https://api.trello.com/1";
    protected static final String BOARDS = "/boards";
    protected static final String LISTS = "/lists";
    protected static final String CARDS = "/cards";

    @BeforeSuite
    public static void setUp() {
        reqBuilder = new RequestSpecBuilder();

        reqBuilder.setContentType(ContentType.JSON);
        reqBuilder.addQueryParam("key", KEY);
        reqBuilder.addQueryParam("token", TOKEN);

        reqSpec = reqBuilder.build();
    }
}

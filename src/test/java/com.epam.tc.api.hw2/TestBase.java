package com.epam.tc.api.hw2;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.LinkedHashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static RequestSpecification reqSpec;
    protected static ResponseSpecification respSpec;
    protected static Response response;
    protected static JsonPath jsonPath;
    protected static String BOARD_ID;
    protected static String LIST_ID;
    protected static String CARD_ID;

    @BeforeSuite(alwaysRun = true)
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

    @BeforeClass(alwaysRun = true)
    public void createEntities() {
        //Create board
        response = RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("name", TestData.FIRST_BOARD_NAME)
            .when()
            .post(EndPoints.BOARDS)
            .then()
            .spec(respSpec)
            .extract().response();

        jsonPath = response.jsonPath();
        BOARD_ID = jsonPath.getString("id");

        //create list
        response = RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("name", TestData.FIRST_LIST_NAME)
            .queryParam("idBoard", BOARD_ID)
            .when()
            .post(EndPoints.LISTS)
            .then()
            .spec(respSpec)
            .extract()
            .response();

        jsonPath = response.jsonPath();
        LIST_ID = jsonPath.getString("id");

        //create card
        response = RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("idList", LIST_ID)
            .when()
            .post(EndPoints.CARDS)
            .then()
            .spec(respSpec)
            .extract()
            .response();

        jsonPath = response.jsonPath();
        CARD_ID = jsonPath.getString("id");
    }
}

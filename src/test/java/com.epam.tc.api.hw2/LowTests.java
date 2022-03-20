package com.epam.tc.api.hw2;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LowTests extends TestBase {

    @Test
    public void createBoard() {

        RestAssured.given().spec(reqSpec)
                           .queryParam("name", "First board")
                           .when()
                           .post(BASE_URL + BOARDS)
                           .then()
                           .statusCode(200);

    }


}

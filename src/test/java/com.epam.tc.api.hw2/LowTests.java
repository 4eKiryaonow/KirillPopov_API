package com.epam.tc.api.hw2;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LowTests extends TestBase {

    @Test
    public void createBoard() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("name", TestData.SECOND_BOARD_NAME)
            .when()
            .post(EndPoints.BOARDS)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.SECOND_BOARD_NAME))
            .body("closed", equalTo(false));
    }

    @Test
    public void changeNameOfBoard() {

        RestAssured.given()
                   .spec(reqSpec)
                   .queryParam("name", TestData.NEW_FIRST_BOARD_NAME)
                   .when()
                   .put(EndPoints.BOARDS + BOARD_ID)
                   .then()
                   .assertThat()
                   .spec(respSpec)
                   .body("name", equalTo(TestData.NEW_FIRST_BOARD_NAME));
    }

    @Test
    public void getBoard() {

        RestAssured
            .given()
            .spec(reqSpec)
            .when()
            .get(EndPoints.BOARDS + BOARD_ID)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.NEW_FIRST_BOARD_NAME));
    }

    @Test
    public void createList() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("name", TestData.SECOND_LIST_NAME)
            .queryParam("idBoard", BOARD_ID)
            .when()
            .post(EndPoints.LISTS)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.SECOND_LIST_NAME));
    }

    @Test
    public void closeList() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("closed", "true")
            .when()
            .put(EndPoints.LISTS + LIST_ID)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.FIRST_LIST_NAME))
            .body("closed", equalTo(true));
    }

    @Test
    public void getClosedList() {

        RestAssured
            .given()
            .spec(reqSpec)
            .get(EndPoints.LISTS + LIST_ID)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.FIRST_LIST_NAME))
            .body("closed", equalTo(true));
    }

    @Test
    public void openClosedList() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("closed", "false")
            .when()
            .put(EndPoints.LISTS + LIST_ID)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.FIRST_LIST_NAME))
            .body("closed", equalTo(false));
    }

    @Test
    public void createCard() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("idList", LIST_ID)
            .when()
            .post(EndPoints.CARDS)
            .then()
            .assertThat()
            .spec(respSpec);
    }

    @Test
    public void addDescriptionToCard() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("desc", TestData.CARD_DESCRIPTION)
            .when()
            .put(EndPoints.CARDS + CARD_ID)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("desc", equalTo(TestData.CARD_DESCRIPTION));
    }

    @Test
    public void createChecklist() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("idCard", CARD_ID)
            .when()
            .post(EndPoints.CHECKLISTS)
            .then()
            .assertThat()
            .spec(respSpec);
    }
}

package com.epam.tc.api.hw2;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;



public class LowTests extends TestBase {

    public static String boardId;
    public static String listId;
    public static String cardId;

    @Test(priority = 1)
    public void createBoard() {

        Response response = RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("name", TestData.BOARD_NAME)
            .when()
            .post(EndPoints.BOARDS)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.BOARD_NAME))
            .body("closed", equalTo(false))
            .extract().response();

        JsonPath jsonPath = response.jsonPath();
        boardId = jsonPath.getString("id");
    }

    @Test(priority = 2)
    public void changeNameOfBoard() {

        RestAssured.given()
                   .spec(reqSpec)
                   .queryParam("name", TestData.BOARD_NEW_NAME)
                   .when()
                   .put(EndPoints.BOARDS + boardId)
                   .then()
                   .assertThat()
                   .spec(respSpec)
                   .body("name", equalTo(TestData.BOARD_NEW_NAME));
    }

    @Test(priority = 3)
    public void getBoard() {

        RestAssured
            .given()
            .spec(reqSpec)
            .when()
            .get(EndPoints.BOARDS + boardId)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.BOARD_NEW_NAME));
    }

    @Test(priority = 4)
    public void createList() {

        Response response = RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("name", TestData.LIST_NAME)
            .queryParam("idBoard", boardId)
            .when()
            .post(EndPoints.LISTS)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.LIST_NAME))
            .extract()
            .response();

        JsonPath jsonPath = response.jsonPath();
        listId = jsonPath.getString("id");
    }

    @Test(priority = 5)
    public void closeList() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("closed", "true")
            .when()
            .put(EndPoints.LISTS + listId)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.LIST_NAME))
            .body("closed", equalTo(true));
    }

    @Test(priority = 6)
    public void getClosedList() {

        RestAssured
            .given()
            .spec(reqSpec)
            .get(EndPoints.LISTS + listId)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.LIST_NAME))
            .body("closed", equalTo(true));
    }

    @Test(priority = 7)
    public void openClosedList() {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("closed", "false")
            .when()
            .put(EndPoints.LISTS + listId)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("name", equalTo(TestData.LIST_NAME))
            .body("closed", equalTo(false));
    }

    @Test(priority = 8)
    public void createCard() {

        Response response = RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("idList", listId)
            .when()
            .post(EndPoints.CARDS)
            .then()
            .assertThat()
            .spec(respSpec)
            .extract()
            .response();

        JsonPath jsonPath = response.jsonPath();
        cardId = jsonPath.getString("id");
    }

    @Test(priority = 9)
    public void addDescriptionToCard() throws InterruptedException {

        RestAssured
            .given()
            .spec(reqSpec)
            .queryParam("desc", TestData.CARD_DESCRIPTION)
            .when()
            .put(EndPoints.CARDS + cardId)
            .then()
            .assertThat()
            .spec(respSpec)
            .body("desc", equalTo(TestData.CARD_DESCRIPTION));

    }

    @Test(priority = 10)
    public void deleteBoard() {

        RestAssured
            .given()
            .spec(reqSpec)
            .when()
            .delete(EndPoints.BOARDS + boardId)
            .then()
            .assertThat()
            .spec(respSpec);
    }
}

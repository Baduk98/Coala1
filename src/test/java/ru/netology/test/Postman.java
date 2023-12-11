package ru.netology.test;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class Postman {

    @Test
    void dataTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Good Day")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Good Day"))
        ;
    }


    @Test
    void postTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("handWave")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("handWave"))

        ;
    }

    @Test
    void headersTest() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/headers")
                .then()
                .statusCode(200)
                .headers("Connection", "keep-alive",
                        "Content-Type", "application/json; charset=utf-8");

    }

    @Test
    void basicAuthTest() {
        given()
                .baseUri("https://postman-echo.com")
                .headers("Authorization","Basic cG9zdG1hbjpwYXNzd29yZA==")
                .when()
                .get("/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
        ;

    }
}
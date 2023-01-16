package tech.tebatsomokgokolo.backend.book.controller;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import tech.tebatsomokgokolo.backend.book.model.Book;

import java.util.Objects;

import static com.jayway.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookControllerTest {

    @BeforeEach
    public void setup() {
        String port = System.getProperty("server.port");
        if (Objects.isNull(port)) {
            RestAssured.port = 8080;
        } else {
            RestAssured.port = Integer.parseInt(port);
        }

        String basePath = System.getProperty("server.base");
        if (Objects.isNull(basePath)) {
            basePath = "v1/api/book/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (Objects.isNull(baseHost)) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;
    }

    @Test
    @Order(1)
    void shouldTestGetALLStudents_thenSaveResults() {

        given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .then()
                .log()
                .all()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
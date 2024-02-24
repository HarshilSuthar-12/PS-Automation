package com.restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.main.RestAssuredPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredClass {

    static {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void checkForSold() {
        executeGetRequestWithStatus("sold");
    }

    @Test
    public void checkForAvailable() {
        executeGetRequestWithStatus("available");
    }

    @Test
    public void checkForPending() {
        executeGetRequestWithStatus("pending");
    }

    private void executeGetRequestWithStatus(String status) {
        given().queryParam("status", status).when().get("/pet/findByStatus").then().statusCode(200).log()
                .ifValidationFails();
    }

    @Test
    public void checkByID() {
        executeGetRequestByID(5, "doggie");
    }

    private void executeGetRequestByID(int id, String name) {
        given().when().get("/pet/" + id).then().header("Content-Type", is("application/json")).body("id", is(id))
                .body("name", is(name)).statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
    }

    @Test
    public void checkByUsername() {
        executeGetRequestByUsername("Harshil");
    }

    private void executeGetRequestByUsername(String username) {
        given().when().get("/user/" + username).then().header("Content-Type", is("application/json"))
                .body("username", is(username)).statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
    }

    @Test
    public void checkByLogin() {
        executeGetRequestByLogin("username", "password");
    }

    private void executeGetRequestByLogin(String username, String password) {
        given().contentType(ContentType.JSON).auth().basic(username, password).when().get("user/login").then()
                .body("code", is(200)).log().all();
    }

    @Test
    public void checkLogout() {
        executeGetRequestLogout();
    }

    private void executeGetRequestLogout() {
        given().contentType(ContentType.JSON).when().get("user/logout").then().body("code", equalTo(200))
                .body("type", equalTo("unknown")).body("message", equalTo("ok")).log().body();
    }

    @Test
    public void sendUserData() {
        List<RestAssuredPOJO> reqcontent = new ArrayList<RestAssuredPOJO>();
        reqcontent.add(new RestAssuredPOJO(12, "HS", "Harshil", "Suthar", "h@h.com", "Harshil", "1231231233", 1));
        given().contentType(ContentType.JSON).body(reqcontent).when().post("user/createWithList").then().log().body();
    }

    @Test
    public void getUserData() {
        executeGetRequestUserData("HS01");
    }

    private void executeGetRequestUserData(String username) {
        given().contentType(ContentType.JSON).when().get("user/" + username).then().log().body();
    }

    @Test
    public void updateUserData() {
        Map<Object, Object> reqContent = new HashMap<>();
        reqContent.put("id", 12);
        reqContent.put("username", "HS01");
        reqContent.put("firstName", "Harshil");
        reqContent.put("lastName", "Suthar");
        reqContent.put("email", "hs@hs.com");
        reqContent.put("password", "000000");
        reqContent.put("phone", "1231231233");
        reqContent.put("userStatus", 1);

        given().contentType(ContentType.JSON).body(reqContent).when().post("user").then().log().body();
    }

    @Test
    public void deleteUserData() {
        executeDeleteRequestUserData("HS01");
    }

    private void executeDeleteRequestUserData(String username) {
        given().contentType(ContentType.JSON).when().delete("user/" + username).then().statusCode(200).log().body();
    }
}
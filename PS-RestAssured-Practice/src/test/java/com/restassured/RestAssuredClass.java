package com.restassured;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class RestAssuredClass {
	
	static {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	
	@Test
	public void checkForSold() {
		given().queryParam("status", "sold")
		.when()
		.get("/pet/findByStatus")
		.then().statusCode(200).log().ifValidationFails();
	}
//	
	@Test
	public void checkForAvailable() {
		given().queryParam("status", "available")
		.when()
		.get("pet/findByStatus")
		.then().log().all();
	}
//	
	@Test
	public void checkForPending() {
		given().queryParam("status", "pending")
		.when()
		.get("pet/findByStatus")
		.then().statusCode(200).log().ifValidationFails();
	}
	
	@Test 
	public void checkByID() {
        given()
        .when()
        .get("/pet/5")
        .then()
        .header("Content-Type", is("application/json"))
        .body("id",is(5))
        .body("name",is("doggie"))
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK")
        .log().all();
	}
	
	
	@Test
	public void checkByUsername() {
		given()
        .when()
        .get("/user/Harshil")
        .then()
        .header("Content-Type", is("application/json"))
//        .body("id",is(9223372036854776000))
        .body("username",is("Harshil"))
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK")
        .log().all();
	}
	
	
//	https://petstore.swagger.io/v2/user/login?username=Harshil&password=Harshilsuthar%40%23123
	@Test
	public void checkByLogin() {
		given().contentType(ContentType.JSON)
//		.queryParam("username", "Harshil")
//		.queryParam("password", "Hs@#123")
		.auth().basic("username", "password")
		.when()
		.get("user/login")
		.then()
		.body("code",is(200))
		.log().all();
	}
	
//	https://petstore.swagger.io/v2/user/logout
	@Test
	public void checkLogout() {
		given().contentType(ContentType.JSON)
        .when()
        .get("user/logout")
        .then()
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", equalTo("ok"))
        .log().body();
	}
	
//	@Test
//	public void createUser() {
//		
//	}
	
	
	
}












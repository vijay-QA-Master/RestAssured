package pojo_FakeData_Practice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;

public class Create_user {

	Faker faker;
	UserCreatePOJO userPayload;
	@Test
	public void new_user_create()
	{
		faker=new Faker();
		userPayload=new UserCreatePOJO();
		
		userPayload.setName(faker.name().firstName());
		userPayload.setJob(faker.job().position());
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="api/users";
		
		given()
		
		.header("Content-Type","application/json")
		
		.body(userPayload)
		.log().all()
		.when()
		
		.post()
		
		.then()
		.log().all()
		.extract()
		
		.response();
		
	}
}

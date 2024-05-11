package practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginPractice
{
	@Test
	public void login_Practice()
	{
		LoginPojo mainObject=new LoginPojo();
		
		mainObject.setEmail("eve.holt@reqres.in");
		mainObject.setPassword("cityslicka");
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp = given()
				
				.headers("Content-Type","application/json")
		
		.body(mainObject)
		
		.when()
		
		.post("api/login")
		
		.then()
		
		.assertThat()
		
		.statusCode(200)
		
		
		.extract().response();
		
		int code=resp.getStatusCode();
		System.out.println(code);
		
		JsonPath jp = resp.jsonPath();
		
		String myToken=jp.getString("token");
		System.out.println(myToken);
		
	}
}

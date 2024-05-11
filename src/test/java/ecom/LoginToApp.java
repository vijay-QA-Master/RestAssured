package ecom;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginToApp extends BaseData
{

	@Test
	public void login() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";

		Response response = given()

				.header("Content-Type", "application/json")

				.body("{\r\n" + "    \"userEmail\": \"vijay@qmail.com\",\r\n"
						+ "    \"userPassword\": \"Redhat@vijay91\"\r\n" + "}")
				.log().all()

				.when()

				.post("api/ecom/auth/login")

				.then()
				.log().all()

				.extract()

				.response();

		int stsCode = response.statusCode();

		Assert.assertEquals(stsCode, 200);

		JsonPath jp = response.jsonPath();

		 token = jp.getString("token");
		
		System.out.println(token);
		
		 userId= jp.getString("userId");
		
		System.out.println(userId);

	}

}
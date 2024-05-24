package authPractice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class BasicAuth
{
	
	@Test
	public void basic_Auth()
	{
		RestAssured.baseURI="https://postman-echo.com/";	
		RestAssured.basePath="basic-auth";
		
		Response resp = given()
				
				.header("accept","application/xml")
		
		.auth()
		
		.basic("postman","password")
		
		.when()
		
		.get()
		
		.then()
		
		.log().all()
		.extract()
		
		.response();
		
		
		JsonPath jp = resp.jsonPath();
		
		String value=jp.getString("authenticated");
		System.out.println(value);
		
		List<Header> headersList = resp.getHeaders().asList();
		
		String firstHeaderValue=headersList.get(2).getValue();
		
		System.out.println(headersList);
		
		
		
		
	}

}

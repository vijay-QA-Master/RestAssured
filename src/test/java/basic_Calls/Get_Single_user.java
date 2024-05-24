package basic_Calls;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class Get_Single_user 
{
	@Test
	public void user_details()
	{
		RestAssured.baseURI="https://reqres.in";
		
		Response res = given()
		
		.when()
		
		.get("api/users/2")
		
		.then()
		
		.extract()
		
		.response();
		
		String finalResponse=res.asPrettyString();
		System.out.println(finalResponse);
		
		int code = res.getStatusCode();
		System.out.println("This is the Status Code:- "+code);
		
		Headers headers = res.getHeaders();
		List<Header> totalHeaders = headers.asList();
		for(Header a:totalHeaders)
		{
			System.out.println(a);
		}
		
		long responseTime = res.getTime();
		System.out.println("This is the response Time:- "+responseTime);
		
		if(responseTime>1000)
		{
			Assert.fail("Response Time is greater then 1000");
		}
		
		
		
		
	}
}

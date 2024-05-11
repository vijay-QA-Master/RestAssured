package basic_Calls;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;
public class Get_Multiple_users 
{
	int count=0;
	@Test
	public void getAllUsers()
	{
		RestAssured.baseURI="https://reqres.in";
		
		Response resp = given()
		
		.when()
		
		.get("api/users?page=2")
		
		.then()
		
		.extract()
		
		.response();
		
		int code=resp.getStatusCode();
		System.out.println("This is the status Code:- "+code);
		
		Headers headers = resp.getHeaders();
		List<Header> allHeaders = headers.asList();
		for(Header a:allHeaders)
		{
			System.out.println(a);
			count++;
			System.out.println();
		}
		System.out.println(count);
		
		String myvalue = resp.header("CF-Cache-Status");
		System.out.println(myvalue);
		
		// to print the status line from the response
		System.out.println(resp.statusLine());
		
		
		
		
		
		

		
		
		
	}

}

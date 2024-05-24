package codeStudio_Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Authorization
{
	
	static String accessToken;
	
	@Test(priority = 3)
	public void Basic_Auth()
	{
		RestAssured.baseURI="https://postman-echo.com";
		RestAssured.basePath="/basic-auth";
		
		Response resp = given()
		
				.auth()
				
				.preemptive()// ager preemptive basic authentication chahiye to
				
				.basic("postman","password")
		.when()
		
		.get()
		
		.then()
		
		.statusCode(200)
		
		.extract()
		
		.response();
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.statusLine());
		
		
	}
	
	@Test(priority = 2)
	public void digestAuth()
	{
		RestAssured.baseURI="https://httpbin.org";
		RestAssured.basePath="/digest-auth/undefined/vijay/vijay";
		
		Response resp = given()
		
				.auth()
				
				.digest("vijay","vijay")
		.when()
		
		.get()
		
		.then()
		
		.statusCode(200)
		.extract()
		
		.response();
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.statusLine());
		
		
	}
	
	@Test(priority = 1)
	public void BearerToken()
	{
		RestAssured.baseURI="https://gorest.co.in";
		RestAssured.basePath="/public/v2/users";
		
		JSONObject payload=new JSONObject();
		payload.put("name","BharatSingh");
		payload.put("gender","Male");
		payload.put("email","vijay@pepsicola.com");
		payload.put("status","Active");
		
		String Token="Bearer c1f7f852ff41aac81e61da7b1efed245fe11772bb5fe6b7606e69e15ea0e92ef";
		
		
		Response resp = given()
		
		.header("Authorization",Token)
		
		.header("Content-Type","application/json")
		
		.body(payload.toJSONString())
		
		.log().all()
		.when()
		
		.post()
		
		.then()
		
		.extract()
		
		.response();
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.statusLine());
		
		System.out.println(resp.statusCode());
		
		
	}
	
	@Test(priority = 0)
	public void APIKey()
	{
		////https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		
		RestAssured.baseURI="https://api.openweathermap.org";
		RestAssured.basePath="/data/2.5/weather";;
		
		given()
		
		.queryParam("q","Morena")
		
		.queryParam("appid","e2cc04ab373ecd5d4ab1980002a4e0fc")
		
		.log().all()
		.when()
		
		.get()
		
		.then()
		
		.log()
		
		.all()
		
		.extract()
		.response();
	}
	@Test(priority = 0, timeOut = 2000)
	public void GetAccessToken()
	{
		String clientId = "Af6ZaIMAoqOuIxoWdFXu0-DagBIO-16R84vyhxBkAIGynL8IIuTrue3qP3wAOmAZ52qSV3I240SsXkoP";
		String clientSecret = "EBWh5kucLCxYHILbnQiAHeG6fpz4cFZ1YH4mNXjlGo92BdZkSTr0iLZW_nrSIvKYylpaQ26oVtaJAQd6";
		
		RestAssured.baseURI="https://api-m.sandbox.paypal.com";
		RestAssured.basePath="/v1/oauth2/token";
		
		Response resp = given()
		
		.auth()
		
		.preemptive()
		
		.basic(clientId, clientSecret)
		
		.param("grant_type", "client_credentials")
		
		.log()
		
		.all()
		.when()
		
		.post()
		
		.then()
		
		.log()
		
		.all()
		.extract()
		
		.response();
		
		System.out.println(resp.asPrettyString());
		
		//in response we got a token that we will use further
		// now we are fetching the token from the response
		
		JsonPath jp = resp.jsonPath();
		 accessToken=jp.getString("acces_token");
		
	}
	
	@Test(dependsOnMethods ="GetAccessToken", timeOut = 2000)
	public void ListInvoice()
	{
		//page=3&page_size=4&total_count_required=true
		Response res= RestAssured.given().auth().oauth2(accessToken).queryParam("page", "3")
		 .queryParam("page_size", "4")
		 .queryParam("total_count_required", "true")
		 .get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
		
		System.out.println("\n------------------LIST INVOICE------------------------");
		
		res.prettyPrint();
		//print status code & status line
				System.out.println("Response code:" + res.statusCode() );
				System.out.println("status line:" + res.statusLine() );
		
				//validate repsonse code
				//Assert.assertEquals(res.statusCode(), 200,"check for response code");
	}			

}

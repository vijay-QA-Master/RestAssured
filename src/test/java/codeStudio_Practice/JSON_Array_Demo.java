package codeStudio_Practice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JSON_Array_Demo 
{
	@Test
	public void createUser_usingJSON_Array()
	{
		//Create JSONObjects for Users
		
		JSONObject user1=new JSONObject();
		user1.put("firstName","vijay");
		user1.put("lastName","Singh");
		user1.put("age",28);
		user1.put("salary",10000.56);
		
		
		JSONObject user2=new JSONObject();
		user2.put("firstName","rahul");
		user2.put("lastName","Singh");
		user2.put("age",28);
		user2.put("salary",10000.56);
		
		JSONObject user3=new JSONObject();
		user3.put("firstName","kushal");
		user3.put("lastName","him");
		user3.put("age",28);
		user3.put("salary",10000.56);
		
		//add JSON Objects to JSON Array
		
		JSONArray UsersPayload=new JSONArray();
		UsersPayload.add(user1);
		UsersPayload.add(user2);
		UsersPayload.add(user3);	
		
		
		//create request
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
		
		Response resp = given()
		
		.header("Content-Type","application/json")
		
		.body(UsersPayload)
		
		.when()
		
		.post()
		
		.then()
		
		.log()
		
		.all()
		
		.extract()
		
		.response();
		
		System.out.println(resp.asPrettyString());
	}

}

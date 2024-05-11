package codeStudio_Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JSON_Object_Using_JavaMap 
{
	@Test
	public void createAuthToken() {
		
		/*{
    "username" : "admin",
    "password" : "password123"*/
		
		HashMap<String,String> authToken=new HashMap();
		authToken.put("username","admin");
		authToken.put("password","password123");
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RestAssured.basePath="/auth";
		
		Response res = given()
		
		.header("Content-Type","application/json")
		
		.body(authToken)
		.when()
		
		.post()
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		System.out.println(res.asPrettyString());
		
		JsonPath jp = res.jsonPath();
		System.out.println("This is the Token:-  "+jp.getString("token"));
		
		System.out.println("This is the Status Code:-  "+res.getStatusCode());
		
		System.out.println("This is the Status line:-   "+res.getStatusLine());
		
	}
	
	@Test
	public void createUser()
	{
		/*{
	"firstname":"vijay",
	"lastname":"kumar",
	"age":28,
	"salary":10000.56,
	"ismarried":false,
	"Hobbies":["Music","Computer","game"],
	
	"TechSkill":{
					"programing Language":"Java",
					"WebAutomation":"Selenium",
					"API Testing":"Rest Assured"
				
					},

"Age":null

		}			*/
		
		HashMap<String,Object> userData=new HashMap<String, Object>();
		userData.put("firstname","vijay");
		userData.put("lastname","kumar");
		userData.put("age",28);
		userData.put("salary",10000.56);
		ArrayList<String> al=new ArrayList<String>();
		al.add("Music");
		al.add("Computer");
		al.add("game");
		userData.put("Hobbies",al);
		
		HashMap<String,String> techSkills=new HashMap<String, String>();
		techSkills.put("Programing language","Java");
		techSkills.put("WebAutomation","Selenium");
		techSkills.put("API Testing","Rest Assured");
		
		userData.put("TechSkill",techSkills);
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
		
		Response resp = given()
		
		.header("Content-Type","application/json")
		
		.body(userData)
		
		.log().all()
		.when()
		
		.post()
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.statusCode());
		
		
		
		
	}
}

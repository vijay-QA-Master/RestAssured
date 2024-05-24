package practice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Job;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class PostPractice
{
	
	@Test
	public void postMethod()
	{
		
		JSONObject jobj=new JSONObject();
		jobj.put("name","VIJAY");
		jobj.put("job","Father");
		
		
		
		
		
		
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
		
		given()
		
		.header("Content-Type","application/json")
		
		.header("accept","application/json")
		
		.body(jobj.toJSONString())
		
		.log().all()
		.when()
		
		.post()
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	}
	
	
}

package codeStudio_Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Deserialization
{

	@Test
	public void createUser()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
		
		JSONObject jo=new JSONObject();
		jo.put("name","vijay");
		jo.put("job","QA");
		
		 Json_Post_request_response_pojo resp = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
		
		.body(jo.toJSONString())
		
		.log()
		
		.all()
		
		.when()
		
		.post()
		
		
		.then()
		
		.log().all()
		
		.extract().response().as(Json_Post_request_response_pojo.class);
		
		System.out.println(resp.getName());
		
		
		
		

		
	}
	
}

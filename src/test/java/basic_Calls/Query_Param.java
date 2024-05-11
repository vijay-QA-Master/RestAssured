package basic_Calls;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Query_Param
{
	@Test
	public void QueryParam()
	{
		RestAssured.baseURI="https://reqres.in";
		Response resp = given()
		
		.queryParam("page","2")
		
		.when()
		
		.get("api/users")
		
		.then()
		
		.extract()
		
		.response();
		
		String response=resp.asPrettyString();
		System.out.println(response);
		
		
		}
	
	@Test
	public void Pathparam()
	{
		RestAssured.baseURI="https://reqres.in";
		
		Response resp = given()
		
		.pathParam("keyofpath","2")
		
		.when()
		
		.get("api/users/{keyofpath}")
		
		.then()
		
		.extract()
		
		.response();
		String response=resp.asPrettyString();
		
		System.out.println(response);
	}

}

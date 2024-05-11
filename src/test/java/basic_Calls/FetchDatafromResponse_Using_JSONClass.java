package basic_Calls;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchDatafromResponse_Using_JSONClass {
	
	@Test(priority = 1)
	public void mynewMethod()
	{
		RestAssured.baseURI="https://reqres.in";
		Response resp = given()
		
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		
		.when()
		
		.post("api/users")
		
		.then()
		
		.extract()
		
		.response();
		
		String response = resp.asPrettyString();
		System.out.println(response);
		
		JsonPath jp = new JsonPath(response);
		int id=jp.getInt("id");
		System.out.println(id);
		
		System.out.println(resp.getStatusCode());
		
	}
	
	@Test(priority = 2)
	public void anotherExample()
	{
		RestAssured.baseURI="https://reqres.in";
		Response resp = given()
		
		.when()
		
		.get("api/users?page=2")
		
		.then()
		
		.extract()
		
		.response();
		
		String response = resp.asPrettyString();
		
		JsonPath jp=new JsonPath(response);
		int count=jp.getInt("per_page");
		System.out.println(count);
		
		String fname=jp.getString("data[1].first_name");
		System.out.println(fname);
	}

}

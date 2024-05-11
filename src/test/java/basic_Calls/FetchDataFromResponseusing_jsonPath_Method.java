package basic_Calls;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchDataFromResponseusing_jsonPath_Method 
{
	@Test
	public void myResult()
	{
		
		RestAssured.baseURI="https://reqres.in";
		
		Response resp = given()
		
		.queryParam("page",2)
		
		.when()
		
		.get("api/users")
		
		.then()
		
		.extract()
		
		.response();
		
		JsonPath jp = resp.jsonPath();
		
		String email=jp.getString("data[0].email");
		System.out.println(email);
		
		String avatar = jp.getString("data[1].avatar");
		System.out.println(avatar);
		
		int size = jp.getInt("data.size()");
		System.out.println(size);
		
		for(int i=0;i<=size-1;i++)
		{
			
			String allLastName = jp.getString("data["+i+"].last_name");
			System.out.println(allLastName);
		}
		
	}

}

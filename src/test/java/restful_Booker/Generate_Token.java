package restful_Booker;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Listeners(listners.ListnerAPI.class)
public class Generate_Token extends BaseData
{
	
	@Test
	public void myTest()
	{
		Pojo mainObject=new Pojo();
		mainObject.setuserName("admin");
		mainObject.setpassword("password123");
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String requestBody="{\"username\":\"admin\",\"password\":\"password123\"}";
		
		Response resp = given()
		
		.header("Content-Type","application/json")
		.header("Connection","keep-alive")
		.header("Accept","*/*")
		.header("Accept-Encoding","gzip, deflate, br")
		
		
		//.body(mainObject)
		.body(requestBody)
		
		.log().all()
		.when()
		
		.post("auth")
		
		
		.then()
		
		.extract()
		.response();
		
		String response = resp.asPrettyString();
		System.out.println(response);
		
		int code=resp.getStatusCode();
		System.out.println(code);
		
		JsonPath jp = resp.jsonPath();
		String result=jp.getString("reason");
		System.out.println("This is the result:- "+result);
		
		 token=jp.getString("token");
		
		Headers headlist = resp.getHeaders();
		List<Header> mylist = headlist.asList();
		for(Header a:mylist)
		{
			System.out.println(a);
		}
	}

}

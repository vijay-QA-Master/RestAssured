package practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

public class Practice_Spec_Builder 
{
	RequestSpecification requestspec;
	ResponseSpecification responsespec;
	
	@BeforeClass
	public void initspecs()
	{
		RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://reqres.in");
		requestSpecBuilder.addHeader("Content-Type","application/json");
		requestSpecBuilder.log(LogDetail.ALL);
		
		requestspec=requestSpecBuilder.build();
		
		
		ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
		responseSpecBuilder.expectStatusCode(201);
		responseSpecBuilder.expectContentType(ContentType.JSON);
		responseSpecBuilder.log(LogDetail.ALL);
		responsespec=responseSpecBuilder.build();
	}
	
	@Test
	public void create_User()
	{
		Response resp = given()
		
		.spec(requestspec)
		
		.body("{\"name\":\"morpheus\",\"job\":\"leader\"}")
		
		.log().all()
		
		.when()
		
		.post("api/users")
		
		.then()
		
		.log().all()
		
		
		
		.spec(responsespec)
		
		
		.extract()
		
		.response();
		
		JsonPath jp = resp.jsonPath();
		
		System.out.println(jp.getString("createdAt"));
		
		System.out.println(jp.getString("id"));
		
		System.out.println(jp.getString("job"));
		
		
	}

}

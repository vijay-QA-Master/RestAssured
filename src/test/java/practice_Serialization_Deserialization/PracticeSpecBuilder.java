package practice_Serialization_Deserialization;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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

public class PracticeSpecBuilder 
{
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeMethod
	public void initialize()
	{
		RequestSpecBuilder requestSpec=new RequestSpecBuilder();
		requestSpec.setBaseUri("https://reqres.in/");
		requestSpec.log(LogDetail.ALL);
		requestSpecification=requestSpec.build();
		
		ResponseSpecBuilder responseSpec=new ResponseSpecBuilder();
		responseSpec.expectStatusCode(200);
		responseSpec.expectContentType(ContentType.JSON);
		responseSpec.log(LogDetail.ALL);
		responseSpecification=responseSpec.build();
		
	}
	
	@Test
	public void getFirstUserDetails()
	{
		Response res = given()
		
		.spec(requestSpecification)
		
		.pathParam("id",2)
		
		.log().all()
		
		.when()
		
		.get("api/users/{id}")
		
		.then()
		
		.spec(responseSpecification)
		
		.extract()
		
		
		.response();
		
		JsonPath jp = res.jsonPath();
		
		int id=jp.getInt("data.id");
		System.out.println(id);
		
		Assert.assertEquals(2,id,"ID Dosen't Matched!!! please check once again");
		
	}
	
	@Test
	public void secondUser()
	{
		Response res = given()
		
		.spec(requestSpecification)
		
		.pathParam("id",4)
		
		.log().all()
		
		.when()
		
		.get("api/users/{id}")
		
		.then()
		
		.spec(responseSpecification)
		
		.extract()
		
		.response();
		
		JsonPath jp = res.jsonPath();
		
		String lastName=jp.getString("data.last_name");
		
		System.out.println(lastName);
	}
	

}

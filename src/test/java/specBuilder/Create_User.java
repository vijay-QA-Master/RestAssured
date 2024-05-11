package specBuilder;

import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Create_User 
{
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void initRequestandResponseBuilder() 
	{
		RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://reqres.in");
		requestSpecBuilder.addHeader("Content-Type", "application/json");
		requestSpecBuilder.log(LogDetail.ALL);
		
		requestSpecification=requestSpecBuilder.build();
		
		ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
		responseSpecBuilder.expectStatusCode(201);
		responseSpecBuilder.expectContentType(ContentType.JSON);
		responseSpecBuilder.log(LogDetail.ALL);
		responseSpecification=responseSpecBuilder.build();
	}
	
	@Test
	public void createUser()
	{
		given()
		.spec(requestSpecification)
		
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		
		.when()
		
		.post("api/users")
		
		.then()
		
		.spec(responseSpecification);
	}
}

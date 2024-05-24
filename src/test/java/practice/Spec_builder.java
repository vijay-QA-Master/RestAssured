package practice;

import org.junit.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Spec_builder
{
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void initrequestandresponsebuilder()
	{
		RequestSpecBuilder requestSpecbuilder=new RequestSpecBuilder();
		requestSpecbuilder.setBaseUri("https://reqres.in");
		requestSpecbuilder.addHeader("Content-Type","application/json");
		requestSpecbuilder.log(LogDetail.ALL);
		requestSpecification=requestSpecbuilder.build();
		
		ResponseSpecBuilder responseSpeacbuilder=new ResponseSpecBuilder();
		responseSpeacbuilder.expectStatusCode(200);
		responseSpeacbuilder.expectContentType(ContentType.JSON);
		responseSpeacbuilder.log(LogDetail.ALL);
		responseSpecification=responseSpeacbuilder.build();
	}
	@Test
	public void createUser()
	{
		given()
		
		.spec(requestSpecification)
		
		.body("{\"name\":\"morpheus\",\"job\":\"leader\"}")
		.when()
		.post("api/users")
		
		.then()
		
		.log().all()
		.spec(responseSpecification);
	}
}



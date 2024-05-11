package basic_Calls;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class SerializationAndDeserialization
{
	@Test
	public void myMethod()
	{
		Request_POJO mainObject=new Request_POJO();
		mainObject.setName("Vijay");
		mainObject.setJob("leader");
		
		RestAssured.baseURI="https://reqres.in";
		Response_POJO responseObject = given()
		
		.body(mainObject)
		
		.header("Content-Type", "application/json")
		
		.log().all()
		
		.when()
		
		.post("api/users")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response().as(Response_POJO.class);
		
		String name=responseObject.getName();
		int id	=responseObject.getId();
		String job=responseObject.getJob();
		String create=responseObject.getCreatedAt();
		
		System.out.println("Name:- "+name);
		System.out.println("Id:- "+id);
		System.out.println("Job:- "+job);
		System.out.println("Created Date & Time"+create);
		
		
	}
			

	
}	

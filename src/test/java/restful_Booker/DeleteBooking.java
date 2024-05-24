package restful_Booker;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

@Listeners(listners.ListnerAPI.class)
public class DeleteBooking extends BaseData
{
	@Test
	public void bookingDelete() 
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		
		given()
		
		.header("Content-Type","application/json")
		
		.header("Cookie",token)
		
		.pathParam("id",bookingID)
		
		.log().all()
		.when()
		
		.delete("/booking/{id}")
		
		.then()
		
		.log()
		
		.all()
		.extract()
		
		.response();
		
		
	}
}

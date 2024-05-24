package restful_Booker;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

@Listeners(listners.ListnerAPI.class)
public class Update_Booking extends BaseData
{
	
	@Test
	public void Booking_Update()
	{
		ObjectMapper objectmapper=new ObjectMapper();
		
		ObjectNode updateDetails = objectmapper.createObjectNode();
		
		updateDetails.put("firstname","James");
		updateDetails.put("lastname","Brown");
		updateDetails.put("totalprice",111);
		updateDetails.put("depositpaid",true);
		
		ObjectNode bookingdate = objectmapper.createObjectNode();
		bookingdate.put("checkin","2018-01-01");
		bookingdate.put("checkout","2019-01-01");
		
		updateDetails.set("bookingdates",bookingdate);
		updateDetails.put("additionalneeds","Breakfast");
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RestAssured.basePath="/booking/1";
		
		given()
		
		.header("Content-Type","application/json")
		
		.header("Accept","application/json")
		
		.header("Cookie","token")
		
		.body(updateDetails)
		
		.when()
		
		.put()
		
		.then()
		
		.extract()
		
		.response();
		
	}

}

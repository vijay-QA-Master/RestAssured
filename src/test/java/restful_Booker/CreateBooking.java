package restful_Booker;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
@Listeners(listners.ListnerAPI.class)
public class CreateBooking extends BaseData
{
	@Test
	public void myBooking()
	{
		
		ObjectMapper objectmapper=new ObjectMapper();
		
		ObjectNode passengerDetails = objectmapper.createObjectNode();
		
		passengerDetails.put("firstname", "Jim");
		passengerDetails.put("lastname", "Brown");
		passengerDetails.put("totalprice",111);
		passengerDetails.put("depositpaid",true);
		
		
		
		ObjectNode bookingdate = objectmapper.createObjectNode();
		bookingdate.put("checkin","2018-01-01");
		bookingdate.put("checkout","2019-01-01");
		
		passengerDetails.set("bookingdates", bookingdate);
		passengerDetails.put("additionalneeds", "Breakfast");
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RestAssured.basePath="booking";
		
		Response resp = given()
		
		.header("Content-Type","application/json")
		.header("Connection","keep-alive")
		.header("Accept","*/*")
		.body(passengerDetails)
		
		.log().all()
		.when()
		
		.post()
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		System.out.println(resp.asPrettyString());
		
		JsonPath jp = resp.jsonPath();
		bookingID=jp.getInt("bookingid");
		
		
		
		
		
	}

}

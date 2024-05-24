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
public class GetBooking
{
	@Test
	public void booking_Details()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		Response resp = given()
				.header("Accept","application/json")
		
		.pathParam("id","2")
		
		.when()
		
		.get("/booking/{id}")
		
		.then()
		
		.extract()
		
		.response();
		
		String response=resp.asPrettyString();
		
		System.out.println(response);
		
		int code=resp.getStatusCode();
		System.out.println("This is the response code:- "+code);
		
		JsonPath jp = resp.jsonPath();
		
		String fname=jp.getString("firstname");
		
		System.out.println("This is the First Name:- "+fname);
		
		String lname=jp.getString("lastname");
		System.out.println("Thi is the Last Name:- "+lname);
		
		int amount=jp.getInt("totalprice");
		System.out.println("Total Paid Amount:- "+amount);
		
		String inDate=jp.getString("bookingdates.checkin");
		System.out.println("Checked in Date:- "+inDate);
		
		Headers res_header = resp.getHeaders();
		
		List<Header> total_Headers = res_header.asList();
		
		for(Header a:total_Headers)
		{
			System.out.println(a);
		}
		
		
		
	}
}

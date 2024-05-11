package practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateBooking
{
	@Test
	public void create_Booking()
	{
//		Post_Pojo mainObject=new Post_Pojo();
//		mainObject.setFirstname("Jim");
//		mainObject.setLastname("Brown");
//		mainObject.setTotalprice(111);
//		mainObject.setAdditionalneeds("Breakfast");
//		mainObject.setCheckin("2018-01-01");
//		mainObject.setCheckout("2019-01-01");
//		mainObject.setDepositpaid(true);
//		mainObject.setCheckin("2018-01-01");
//		mainObject.setCheckout("2019-01-01");
		String xmlBody="<booking>\\r\\n\"\r\n"
				+ "						+ \"    <firstname>Jim</firstname>\\r\\n\"\r\n"
				+ "						+ \"    <lastname>Brown</lastname>\\r\\n\"\r\n"
				+ "						+ \"    <totalprice>111</totalprice>\\r\\n\"\r\n"
				+ "						+ \"    <depositpaid>true</depositpaid>\\r\\n\"\r\n"
				+ "						+ \"    <bookingdates>\\r\\n\"\r\n"
				+ "						+ \"      <checkin>2018-01-01</checkin>\\r\\n\"\r\n"
				+ "						+ \"      <checkout>2019-01-01</checkout>\\r\\n\"\r\n"
				+ "						+ \"    </bookingdates>\\r\\n\"\r\n"
				+ "						+ \"    <additionalneeds>Breakfast</additionalneeds>\\r\\n\"\r\n"
				+ "						+ \"  </booking>\"";
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		Response resp = given()
		
			
		
				.contentType("application/xml")
				
				.body(xmlBody)
			
					
						.log().all()
							.when()
		
							.post("booking")
		
								.then()
								
								.log()
								
								.all()
		
									.extract()
		
										.response();
		
		String response=resp.asPrettyString();
		System.out.println(response);
		
		int code=resp.getStatusCode();
		System.out.println(code);
	}

}

package ecom;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PlaceOrder extends BaseData {
	
	@Test
	public void placingOrder() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";

		Response response = given()

				.header("Content-Type", "application/json")
				.header("Authorization", token)

				.body("{\"orders\": [\r\n"
						+ "        {\r\n"
						+ "        \"country\": \"India\", \r\n"
						+ "        \"productOrderedId\" : \""+productId+"\"\r\n"
						+ "        }\r\n"
						+ "    ]\r\n"
						+ "}")
				.log().all()

				.when()

				.post("api/ecom/order/create-order")

				.then()
				
				.log().all()

				.extract()

				.response();


}
}
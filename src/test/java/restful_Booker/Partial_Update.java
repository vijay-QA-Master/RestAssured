package restful_Booker;

import org.testng.annotations.Test;
import org.testng.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Partial_Update extends BaseData
{
	@Test
	public void update_Partial()
	{
		ObjectMapper objectmapper=new ObjectMapper();
		ObjectNode updateUser = objectmapper.createObjectNode();
		updateUser.put("firstname","vijay");
		updateUser.put("lastname","Brown");
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		//RestAssured.basePath="booking/1";
		
		Response resp = given()
		
		.header("Content-Type","application/json")
		
		.header("Accept","application/json")
		
		.header("Cookie",token)
		
		.pathParam("id",bookingID)
		
		.log().all()
		.body(updateUser)
		
		.when()
		
		.patch("/booking/{id}")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		//org.testng.Assert.assertEquals(resp.statusCode(),200,"Test failed");
		
		
	}

}

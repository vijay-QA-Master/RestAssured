package ecom;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddProduct extends BaseData

{
	
	@Test
	public void addProduct() {
		
	String path	= System.getProperty("user.dir")+"\\src\\test\\resources\\LevisJeans.png";
		
	File file = new File(path);
	
	
		RestAssured.baseURI = "https://rahulshettyacademy.com/";

		Response response = given()

				.header("Authorization", token)
				.param("productName", "Tshirt")
				.param("productAddedBy", userId)
				.param("productCategory", "casuals")
				.param("productSubCategory", "Jeans")
				.param("productPrice", "2000")
				.param("productDescription", "Levis jeans")
				.param("productFor", "Women")
				.multiPart("productImage", file)		
				.log().all()

				.when()

				.post("api/ecom/product/add-product")

				.then()
				.log().all()

				.extract()

				.response();
		
		JsonPath jp = response.jsonPath();

		 productId = jp.getString("productId");
		
		System.out.println(productId);
}
	
}
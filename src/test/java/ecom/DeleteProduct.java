package ecom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class DeleteProduct extends BaseData{
	
	
	
	@Test
	public void deleteProduct()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		given()
		
		.pathParam("prdId", productId)
		
		.header("Authorization", token)
		
		.log().all()
		
		.when()
		
		.delete("/api/ecom/product/delete-product/{prdId}")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
		
	}

}
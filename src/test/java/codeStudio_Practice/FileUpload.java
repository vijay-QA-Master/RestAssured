package codeStudio_Practice;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class FileUpload 
{
	@Test
	public void file_upload()
	{
		//create file object
		
		File myfileUpload=new File("C:\\Users\\vijay\\Desktop\\Test_File.txt");
		File myfileUpload2=new File("C:\\Users\\vijay\\Desktop\\Test_File2.txt");
		RestAssured.baseURI="https://httpbin.org/post";
		
		Response res = given()
		
		.header("Content-Type","multipart/form-data")
		
		.multiPart("files",myfileUpload)//here we used files because we are sending multiple files
		.multiPart("files",myfileUpload2)//if we want to send only one file that time we will use file only
		.when()
		
		.post()
		
		.then()
		
		.extract()
		
		.response();
		
		System.out.println(res.asPrettyString());
		
		Assert.assertEquals(res.getStatusCode(),200);
		
	}
	
	@Test
	public void uploadImage()
	{
		File myfileUpload=new File("C:\\Users\\vijay\\Desktop\\productImage_1650649434146.jpeg");
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet/1/uploadImage";
		
		Response res = given()
		
		.header("Content-Type","multipart/form-data")
		
		.header("accept","application/json")
		
		.multiPart("file",myfileUpload)
		
		.when()
		
		.post()
		
		.then()
		
		.extract()
		
		.response();
		
		System.out.println(res.asPrettyString());
		
		Assert.assertEquals(res.getStatusCode(),200);
	}

}

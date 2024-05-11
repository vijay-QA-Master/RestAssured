package codeStudio_Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Get_List_Users 
{
	@Test
	public void totalUsers() throws IOException
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
		
	Response resp = given()
		
		.queryParam("page",2)
		
		.when()
		
		.get()
		
		.then()
		
		.statusCode(200)
		
		
		
		.extract()
		
		.response();
	
	System.out.println(resp.asPrettyString());
	
	JsonPath jp = resp.jsonPath();
	
	int totalPages=jp.getInt("total_pages");
	System.out.println(totalPages);
		String avatar=jp.getString("data[0].avatar");
	
	System.out.println(avatar);
	
	Headers headers = resp.getHeaders();
	
	for(Header h:headers)
	{
		System.out.println(h);
		
	}
	
	String value = resp.getHeader("Server");
	Assert.assertEquals(value, "cloudflare");
	
	System.out.println(jp.getString("support.url"));
	
	String responseBody = resp.asPrettyString();
	String filePath="C:\\Users\\vijay\\Desktop\\MYJSON.json";
	File file=new File(filePath);
	
	 FileWriter fileWriter = new FileWriter(file);
	 
	 fileWriter.write(responseBody);
	 fileWriter.close();
	
	}

}

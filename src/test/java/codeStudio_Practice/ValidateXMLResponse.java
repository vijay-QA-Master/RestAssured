package codeStudio_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class ValidateXMLResponse 
{
	@Test
	public void addPet() 
	{
		String xmlRequestData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		
		String jsonData="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		RestAssured.baseURI="https://petstore.swagger.io";
		RestAssured.basePath="/v2/pet";
		
		Response resp = given()
		
		//.header("accept","application/json")
		
		.header("accept","application/xml")// if we want to get response in xml format
		
		.header("Content-Type","application/xml")
		
		.body(xmlRequestData)
		
		.when()
		
		.post()
		
		.then()
		
		.log()
		
		.all()
		.extract()
		
		.response();
		
		int code=resp.getStatusCode();
		
		String response=resp.asPrettyString();
		
		
		Assert.assertEquals(code,200,"Response Code didn't matched");
		
		resp.then().body("pet.name",Matchers.equalTo("doggie"));
		
		//2nd approach to validate XML response
		XmlPath objxmlPath=new XmlPath(response);
		
		String petname=objxmlPath.get("pet.name");
		
		Assert.assertEquals(petname,"doggie");
		
		List<String> mylist = objxmlPath.getList("pet.photourls");//to get all elements as a list
		
		System.out.println(mylist.size());
		
		
	}

}

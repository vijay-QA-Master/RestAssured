package practice;

import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Create_Nested_JSON_Using_JacksonAPI 
{
	@Test
	public void myMethod()
	{	
		
		ObjectMapper objmapper=new ObjectMapper();
		
		//create ObjectNode i.e JSON Nod
		
		ObjectNode userdetails = objmapper.createObjectNode();
		
		userdetails.put("Name","Vijay");
		userdetails.put("Class","BTech");
		userdetails.put("Age", 33);
		userdetails.put("address","New Gandhi Colony");
		userdetails.put("Status",false);
		
		ObjectNode technicalSkills = objmapper.createObjectNode();
		technicalSkills.put("FrameWork","TestNG");
		technicalSkills.put("Language","Java");
		technicalSkills.put("IDE","Eclipse");
		
		userdetails.set("Tech", technicalSkills);
		
		Iterator<Entry<String, JsonNode>> all_Details = userdetails.fields();
		while(all_Details.hasNext())
		{
			System.out.println(all_Details.next());
		}
		
		
		
		
		
		
	}
}

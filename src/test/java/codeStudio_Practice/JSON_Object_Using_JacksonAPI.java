package codeStudio_Practice;

import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSON_Object_Using_JacksonAPI
{
	/*{
“firstname”:”vijay”,
“lastname”:”bhagat”,
“age”:23,
“ismarried”:false
“Techskill”:{ 
		“Programming Language”:”java”,
		“WebAutomation”:”Selenium”,
		“API testing”:”Rest Assured”
}		}
*/
	@Test
	public void createUser() throws JsonProcessingException
	{
	//Create ObjectMapper class instance
		
		ObjectMapper objectmapper=new ObjectMapper();
		
		//create ObjectNode i.e JSON Node
		
		ObjectNode userdetails = objectmapper.createObjectNode();
		
		userdetails.put("firstname","vijay");
		userdetails.put("lastname","awasthi");
		userdetails.put("age",23);
		userdetails.put("ismarried",false);
		userdetails.put("salary",10000.56);
		
		ObjectNode techSkills = objectmapper.createObjectNode();
		
		techSkills.put("programming language","java");
		techSkills.put("webAutomation","Selenium");
		techSkills.put("API Testing","Rest Assured");
		
		userdetails.set("Techskill",techSkills);//(nodeOrKey,node)
		
		//print user details JSON Object
		
		try {
			String userdetailsAsString=objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetails);
			System.out.println("Created JSON Node is: "+userdetailsAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Retrive field value
		
		String firstName=userdetails.get("firstname").asText();
		System.out.println("Value of first name is : - "+firstName);
		
		
		//Retrive the value from the nested object i.e TechSkill
		
		String webautomation=userdetails.get("Techskill").get("webAutomation").asText();
		System.out.println("value of webautomation is :- "+webautomation);
		
		//Retrieve all fields Names only
		Iterator<String> fieldNameiterator = userdetails.fieldNames();
		
		System.out.println("----------------------Printing all fields Names only------------------");
		while(fieldNameiterator.hasNext())
		{
			System.out.println(fieldNameiterator.next());
		}
		
		
		//Retriev all fields values only
		
		Iterator<JsonNode> fieldValueIterator = userdetails.elements();
		
		System.out.println("--------------------Printing fields values only-----------------------");
		while(fieldValueIterator.hasNext())
		{
			System.out.println(fieldValueIterator.next());
		}
		
		System.out.println("--------------------Printing all fields and values together----------");
		Iterator<Entry<String, JsonNode>> KeyValueEntries = userdetails.fields();
		
		while(KeyValueEntries.hasNext())
		{
			Entry<String, JsonNode> node = KeyValueEntries.next();
			
			node.getKey();
			
			System.out.println("Key: "+node.getKey()+", "+"value: "+node.getValue());
		}
		
		//remove firstname field from jsonobject or objectnode
		
		String removedValue=userdetails.remove("firstname").asText();
	
		System.out.println("removed Field:- "+removedValue);
		
		userdetails.put("lastname","Shastri");
		
		String userdetailsAsString=objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetails);
		System.out.println("Created JSON Node is: "+userdetailsAsString);
	}

}

package Heliosz_Service;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

import com.aventstack.extentreports.ReportAggregatesListener;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import POJO_class._data;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Util_Reuseable extends URL_File{
	
	public static String campid;
	static String Camp_Message;
	static String New_Campaign_name;
	static String Campaign_Random_name;
	static String Random_name = "QA_Campaign_Paid Search_";
	

public static  void Creation_Request() {

	report("Calendar_Report.html");
	test=report.startTest("Campaign Calendar Creation");

	Response Cretaion_req =	given().baseUri(Calendar_url).log().all().contentType(header_json).body(paylood.creation(Util_Reuseable.Campaign_Random_Name(), Util_Reuseable.cost())). 
    when().post("api/Campaign").then().statusCode(200).log().all().extract().response();
	
	//Create jsonpath
	JsonPath Create_path = Cretaion_req.jsonPath();

	//System.out.println(Create_path.get("_msg"));
	
	//Getting Camp name
	// Create_path.get("_data[0].CampaignName");
	 
	
	Camp_Message = Create_path.get("_msg");
	if (Camp_Message!=null)
	{
		
		test.log(LogStatus.PASS,"Response Message"+"  " +Camp_Message);
	}
	else {
		test.log(LogStatus.FAIL,"Response Message"+"  " +Camp_Message);
	}
	 
	 
	//Getting Camp ID
	 	campid = Create_path.get("_data[0].CampaignID");
		//System.out.println(campid);
	 	System.out.println(campid);
	 	
	 	if (campid!=null) {
	 		
	 		test.log(LogStatus.PASS, "Campaign Id dispalyed ");
	 	}
	 	else {
	 		test.log(LogStatus.FAIL, "Campaign Id not dispalyed ");
	 		
	 	}
	// return campid;
	 	
	 	int statuscode = Cretaion_req.getStatusCode();

		   if(statuscode == 200) {
			   	 
			   	 test.log(LogStatus.PASS,  "Get status code"+" "+ statuscode);
			    }
			    else 
			    {
			   	 test.log(LogStatus.FAIL,"Get status code"+ "  "+ statuscode);
			    }
	 	
	 	report.endTest(test);
	 	//report.flush();
}


public static void get_campaign() {
	
	//Util_Reuseable get_id = new Util_Reuseable();
	//get_id.Creation_Request();
	
	
	test=report.startTest("Campaign Get Calendar ");
	
	System.out.println(campid);
	Response Cretaion_get = given().baseUri(Calendar_url).contentType(header_json).queryParam("cId", campid).log().all()
    .when().get(Campaign_get).then().extract().response();
	
	//Create jsonpath
		JsonPath Create_path = Cretaion_get.jsonPath();
		String Get_Message = Create_path.get("_msg");
		
		 if (Get_Message!=null) 
		 {
			 test.log(LogStatus.PASS, "Response Message"+"  " +Get_Message);
		 }
		 else 
		 {
			 test.log(LogStatus.FAIL, "Response Message"+"  " +Get_Message);
		 }
		 
//		 int statuscode = Cretaion_get.getStatusCode();
//
//		   if(statuscode == 200) {
//			   	 
//			   	 test.log(LogStatus.PASS,  "Get status code"+" "+ statuscode);
//			    }
//			    else 
//			    {
//			   	 test.log(LogStatus.FAIL,"Get status code"+ "  "+ statuscode);
//			    }
//		 
		 
		    report.endTest(test);
		 	//report.flush();
		 
}


public static void Retrive_all_camps() throws Exception, Exception, IOException {
	
	ObjectMapper objectMapper=new ObjectMapper();
	File file=new File("C:\\Users\\sivaraj\\eclipse-workspace\\API_Test\\Getpayload.json");
	LinkedHashMap<String, Object> value = objectMapper.readValue(file, new TypeReference<LinkedHashMap<String,Object>>(){});
	JSONObject object=new JSONObject(value);
	object.put("SelectedMonthAndYear", "2023-11");
	System.out.println(object.get("SelectedMonthAndYear").toString());
	//String Date  =  object.get("SelectedMonthAndYear").toString();
	//String object2 = object.get("ViewType").toString();
	//System.out.println(object2);
	//object.getJSONObject("password").put("password2", "SHDA");
	String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object.toString());
    System.out.println(prettyJson);
//   JsonNode node = objectMapper.readTree(object.toString());
//   System.out.println(node.toPrettyString());
    Response Campaign_Retrive =  given().baseUri(Calendar_url).contentType(header_json).body(file).log().all().when().post(Campaign_retrive)
    .then().log().all().assertThat().statusCode(200).extract().response();
    
    JsonPath jsonPath = Campaign_Retrive.jsonPath();
    	
    
   int statuscode = Campaign_Retrive.getStatusCode();

   if(statuscode == 200) {
	   	 
	   	 test.log(LogStatus.PASS,  "Retrive status code"+" "+ statuscode);
	    }
	    else 
	    {
	   	 test.log(LogStatus.FAIL,"Retrive status code"+ "  "+ statuscode);
	    }
   
//    
//    int data_size = jsonPath.getInt("_data.size()");
//    
//    System.out.println("datasize value "+ + data_size);
//    
//    
//    for(int i=0;i<data_size;i++){
//    	
//    	String CampaignID = jsonPath.getString("_data["+i+"].CampaignID");
//    	
//    			if (CampaignID == campid ) {
//    				
//    				System.out.println("Test case pass");
//    		
//    		test.log(LogStatus.PASS, "Created CampaignID Retriveed"+ " " +campid);
//    	}
//    			else {
//    				System.out.println("Test case fail");
//    				
//    				test.log(LogStatus.PASS, "Created CampaignID not Retriveed"+ " " +campid);
//    			}
//    	
//    }
    
}


public static void edit_camps() throws IOException, IOException, IOException {
	
	test=report.startTest("Campaign Calendar updated");
	ObjectMapper objectMapper=new ObjectMapper();
	File file=new File("C:\\Users\\sivaraj\\eclipse-workspace\\API_Test\\camp_put_payload.json");
	LinkedHashMap<String, Object> value = objectMapper.readValue(file, new TypeReference<LinkedHashMap<String,Object>>(){});
	JSONObject object=new JSONObject(value);
	object.put("CampaignName", "new data");
	String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object.toString());
    System.out.println(prettyJson);
    Response Res =   given().baseUri(Calendar_url).contentType(header_json).queryParam("cId", campid).body(file).log().all().when().put(Campaign_get).then().log().all().extract().response();
	
    JsonPath jsonPath = Res.jsonPath();
     String Message = jsonPath.getString("_msg");
     
     int status_code = Res.getStatusCode();
     
     if(status_code == 200) {
  	   	 
  	   	 test.log(LogStatus.PASS,  "Update status code"+" "+ status_code);
  	    }
  	    else 
  	    {
  	   	 test.log(LogStatus.FAIL,"Update status code"+ "  "+ status_code);
  	    }
     
     if(Message!=null) {
    	 
    	 test.log(LogStatus.PASS,  "Data updated"+" "+ Message);
     }
     else 
     {
    	 test.log(LogStatus.FAIL,"Data Not updated"+ "  "+ Message);
     }
     report.endTest(test);
}



public static void delete_camps() {
	
	test=report.startTest("Campaign Calendar deteled");
	

	Response res = given().baseUri(Calendar_url).contentType(header_json).queryParam("cId", campid).log().all().when().delete(Campaign_creation).then().assertThat().statusCode(200).log().all().extract().response();
	
	JsonPath jsonPath = res.jsonPath();
	
    String Message = jsonPath.getString("_msg");
    
   int status_code = res.getStatusCode();
   
   if(status_code == 200) {
	   	 
	   	 test.log(LogStatus.PASS,  "Delete status code"+" "+ status_code);
	    }
	    else 
	    {
	   	 test.log(LogStatus.FAIL,"Delete status code"+ "  "+ status_code);
	    }
   
    
    if(Message!=null) {
   	 
   	 test.log(LogStatus.PASS,  "Data deteled"+" "+ Message);
    }
    else 
    {
   	 test.log(LogStatus.FAIL,"Data Not deteled"+ "  "+ Message);
    }
    report.endTest(test);
    report.flush();
}




public static String company_name() {
	 
	Faker faker1 = new Faker();
     String productName = faker1.lorem().characters(10); // Generate a random string of 10 characters
    // System.out.println(productName);
     return productName;
 }

 public static String cost() {
 	 Faker faker1 = new Faker();
 	//  String cost = cost(faker);
	     //   System.out.println(cost);
 
 	 double amount = faker1.number().randomDouble(2, 1, 1000); // Generate a random double between 1 and 1000 with 2 decimal places
 	// System.out.println(amount);
 	 return String.format("%.2f", amount); // Format the amount as currency
 
 }
 
 public static String Campaign_Random_Name() {
	 
	 String Campaign_Random_name1 = (Random_name +RandomStringUtils.randomAlphabetic(6).toLowerCase());
	 System.out.println(Campaign_Random_name1);
	return Campaign_Random_name1;
	 
}


}

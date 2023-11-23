package Heliosz_Service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class Simulation_Service extends URL_File {

	static RequestSpecification req;
	static ResponseSpecification res;

	
		
	
	public static RequestSpecification Req_and_res(String[] key,int[]value ) {
		RequestSpecification req=null;
		for(int i=0;i<key.length;i++) {
		if(i==1) {
			
			req = new RequestSpecBuilder().setBaseUri(Simulation_url).addQueryParam(key[i], value[i]).setContentType(header_json).build();		
			res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(header_json).build();
	
		}
		else{
				
			 req = new RequestSpecBuilder().setBaseUri(Simulation_url).addQueryParam(key[i], value[i]).setContentType(header_json).build();
			  	res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(header_json).build();
		}
		
		
		}
		return req;
	}
	
	public static int getStatusCode(Response res) {
		int code=res.statusCode();
        Assert.assertEquals(code, 200);
		return code;
	}
	
	public static void Incremental_Sales(String Resource, int param1, int param2 ) {
		
    report("Campaign_Simulation_report.html");
    
    test=report.startTest("Campaign Simulation Incremental Sales");
		
		Enum_API_resources Resoucre_name = 	Enum_API_resources.valueOf(Resource);
		 
		System.out.println(Resoucre_name.get_Resource());
		
		String[]  value1 = {"CategoryID","BrandID"};
		int[] keys = {param1,param2};
		RequestSpecification requestSpecification = Req_and_res(value1,keys);
		
		 Response response = given().spec(requestSpecification).when().get(Resoucre_name.get_Resource()).then().spec(res).extract().response();
		 
		 int statusCode = getStatusCode(response);
		 
		 System.out.println(statusCode);
		 
		 test.log(LogStatus.PASS, "Campaign Simulation status code"+ "  "+statusCode);
		 
		 
		JsonPath jsonPath = response.jsonPath();
		
		String	message =jsonPath.getString("_msg");
		System.out.println(jsonPath.getString("_msg"));
		
		if (message !=null) {
			
			test.log(LogStatus.PASS,  "Campaign Simulation"+" "+ jsonPath.getString("_msg"));
		}
		else {
			test.log(LogStatus.FAIL,  "Campaign Simulation"+" "+ message);
		}
		
		System.out.println(jsonPath.get("_msg"));
		
		report.endTest(test);
	 
	}

	
	public static void Filter_Campaign_Simulation(String Resource,int param1) {
		

	    test=report.startTest("Campaign Simulation Filter");
	    Enum_API_resources Resoucre_name = 	Enum_API_resources.valueOf(Resource);
		System.out.println(Resoucre_name.get_Resource());
	   String[]  value1 = {"brandID"};
		int[] keys = {param1};
		RequestSpecification requestSpecification = Req_and_res(value1,keys);
		Response response = given().spec(requestSpecification).when().get(Resoucre_name.get_Resource()).then().spec(res).extract().response();
	
		JsonPath jsonPath = response.jsonPath();
		
		 int statusCode = getStatusCode(response);
		 
		 test.log(LogStatus.PASS, "Filter_Campaign_Simulation_Name_Status_code"+ " " +statusCode);
		 
		jsonPath.get("_msg");
		
		if (jsonPath.get("_msg") !=null) {
			
			test.log(LogStatus.PASS,  "Filter_Campaign_Simulation_Name"+" "+ jsonPath.getString("_msg"));
			//System.out.println("Filter message"+ jsonPath.getString("_msg"));
		}
		else {
			test.log(LogStatus.FAIL,  "Filter_Campaign_Simulation_Name"+" "+ jsonPath.getString("_msg"));
		}
		
		report.endTest(test);
		//report.flush();
		
	}
	
	public static void Impression_Details(String Resource, int param1, int param2) {
		
	    test=report.startTest("Campaign Impression Details");
	    Enum_API_resources Resoucre_name = 	Enum_API_resources.valueOf(Resource);
		//System.out.println(Resoucre_name.get_Resource());
		
		String[]  value1 = {"CategoryID","BrandID"};
		int[] keys = {param1,param2};
		RequestSpecification requestSpecification = Req_and_res(value1,keys);
		
		Response response =	given().spec(requestSpecification).when().get(Resoucre_name.get_Resource()).then().spec(res).extract().response();
	
		JsonPath jsonPath = response.jsonPath();
		
		 int statusCode = getStatusCode(response);
		 
		 test.log(LogStatus.PASS, "Campaign_Impression_Details_Status_code"+ "  "+statusCode);
		 
		if(jsonPath.getString("_msg") !=null) {
			
			test.log(LogStatus.PASS,  "Campaign_Impression_Details"+" "+ jsonPath.getString("_msg"));
			//System.out.println("Filter message"+ jsonPath.getString("_msg"));
		}
		else 
		{
			test.log(LogStatus.FAIL,  "Campaign_Impression_Details"+" "+ jsonPath.getString("_msg"));
		}
		
		report.endTest(test);
		//report.flush();
			
		}
	
	public static void Scurve_graph_data(String Resource,int param1, int param2) {
		
		test=report.startTest("Scurve_Graph_Data");
	    Enum_API_resources Resoucre_name = 	Enum_API_resources.valueOf(Resource);
	    String[]  value1 = {"CategoryID","BrandID"};
		int[] keys = {param1,param2};
		RequestSpecification requestSpecification = Req_and_res(value1,keys);
		
		Response response =	given().spec(requestSpecification).when().get(Resoucre_name.get_Resource()).then().spec(res).extract().response();
		JsonPath jsonPath = response.jsonPath();
		
	 int statusCode = getStatusCode(response);
		 
		 test.log(LogStatus.PASS, "Scurve_Graph_Data_Status_code"+ "  " +statusCode);
		 
		if(jsonPath.getString("_msg") !=null) {
			
			test.log(LogStatus.PASS,  "Scurve_Graph_Data"+" "+ jsonPath.getString("_msg"));
			//System.out.println("Filter message"+ jsonPath.getString("_msg"));
		}
		else 
		{
			test.log(LogStatus.FAIL,  "Scurve_Graph_Data"+" "+ jsonPath.getString("_msg"));
		}
		
		report.endTest(test);
		//report.flush();
			
		}
	    

	public static void SCurve_Threshold_Data(String Resource,int param1) {
		
		test=report.startTest("SCurve_Threshold_Data");
	    Enum_API_resources Resoucre_name = 	Enum_API_resources.valueOf(Resource);
	    String[]  value1 = {"BrandID"};
		int[] keys = {param1};
		RequestSpecification requestSpecification = Req_and_res(value1,keys);
		
		Response response =	given().spec(requestSpecification).when().get(Resoucre_name.get_Resource()).then().spec(res).extract().response();
		
		JsonPath jsonPath = response.jsonPath();
		
 int statusCode = getStatusCode(response);
		 
		 test.log(LogStatus.PASS, "Scurve_Graph_Data_Threshold"+ " " +statusCode);
		
	if(jsonPath.getString("_msg") !=null) {
			
			test.log(LogStatus.PASS,  "Scurve_Graph_Data_Threshold"+" "+ jsonPath.getString("_msg"));
			//System.out.println("Filter message"+ jsonPath.getString("_msg"));
		}
		else 
		{
			test.log(LogStatus.FAIL,  "Scurve_Graph_Data_Threshold"+" "+ jsonPath.getString("_msg"));
		}
		
		report.endTest(test);
		//report.flush();
	}
	
	
//	public static void API_Filter_Campaign_Simulation(String Resource) {
//		
//		test=report.startTest("Filter_Campaign_Simulation_Data");
//	    Enum_API_resources Resoucre_name = 	Enum_API_resources.valueOf(Resource);
//	    
//   Response Response =	given().spec(requestSpecification).when().get(Resoucre_name.get_Resource()).then().spec(res).extract().response();
//		
//		JsonPath jsonPath = Response.jsonPath();
//		
//	if(jsonPath.getString("_msg") !=null) {
//			
//			test.log(LogStatus.PASS,  "Scurve_Graph_Data"+" "+ jsonPath.getString("_msg"));
//			//System.out.println("Filter message"+ jsonPath.getString("_msg"));
//		}
//		else 
//		{
//			test.log(LogStatus.FAIL,  "Scurve_Graph_Data"+" "+ jsonPath.getString("_msg"));
//		}
//		
//		report.endTest(test);
//		report.flush();
//	}
	
	
	
	

	
		}
	    
		
	
	


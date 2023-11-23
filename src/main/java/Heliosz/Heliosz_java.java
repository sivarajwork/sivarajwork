package Heliosz;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.awt.color.CMMException;

import File.payload;

public class Heliosz_java {
	
	static String Url ="http://192.168.2.38";
	static String header_CT="Content-Type";
	static String header_json ="application/json";
    static String campid;
	
	public static void main(String[] args) {
		
		RestAssured.baseURI=Url;
		
			given().header(header_CT,header_json).body(payload.Camp_creation_post("java_back","11.2")).when()
		.post(Resource_Name.Create_camp1).then().assertThat().statusCode(200).log().all().extract().response();
		
		Response response = given().header(header_CT,header_json).body(payload.getcalenderdetails("11-2023")).when().post(Resource_Name.getCamp_detail)
		.then().log().all().extract().response();
		
		  JsonPath js = response.jsonPath();
		  
        int data_size = js.getInt("_data[0].size()");
        
        System.out.println("data size"+ + data_size);
        
        for (int i=0;i<data_size;i++) {
        	
        	 String Channal_name =	js.get("_data["+i+"].campaignName");
        	//System.out.println(Channal_name);
        	 
        	 if (Channal_name.equalsIgnoreCase("java_back")) {
        		campid = js.get("_data["+i+"].id");
        		String Sub_Channal_Name = Channal_name;
        		 System.out.println(Sub_Channal_Name);
        		 i++;
       break;
        	 }
        	 
        }
        
       // System.out.println(campid);
        
        Response response_viewcamp = given().contentType(header_json).queryParam("ID", campid).when().post(Resource_Name.view_camp_data)
        .then().log().all().extract().response();
         
       /* JsonPath load = response_viewcamp.jsonPath();
      String json_data =  load.getString("_data");
      
      System.out.println(json_data);*/
		
     System.out.println("Strated");
	 given().contentType(header_json).body(payload.editcamp()).log().all().when().post(Resource_Name.edit_camp_data).
	 then().log().all().extract().response();
	 
        
        given().contentType(header_json).queryParam("ID", campid).when().post(Resource_Name.delete_camp_data)
        .then().log().all().extract().response();
        
        given().contentType(header_json).body("{\"year\":\"2023\"}").when().post(Resource_Name.Excel_camp_data)
        .then().log().all().extract().response();
	}
	

		
	
}

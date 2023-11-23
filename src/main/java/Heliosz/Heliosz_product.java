package Heliosz;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import File.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Heliosz_product {
	
	static String url = "http://192.168.2.38";
	payload load = new payload();

	
/*	
@Test()
	
  
	public void Create_camp() {
		RestAssured.baseURI=url;
		given().contentType("application/json").body(payload.Camp_creation_post(Reuseable_method.company_name(),Reuseable_method.cost())).when()
		.post("/api/campaign/createcampaign").then().log().all().extract().response();
	}*/
	
	@Test()
	
public void Create_camp1( ) 
{
		RestAssured.baseURI=url;
		given().contentType("application/json").body(payload.Camp_creation_post("java_back","11.2")).when()
		.post("/api/campaign/createcampaign").then().log().all().extract().response();
	}
	
     @Test()
     
public void getCamp_detail() {
    		String exptected ="java_test";
    	
	RestAssured.baseURI=url;
    Response response =	given().header("Content-Type","application/json").body(payload.getcalenderdetails("11-2023")).when().post("/api/campaign/getcalendardata")
	.then().log().all().extract().response();
    
    JsonPath js = response.jsonPath();
    
    String CampID =  js.getString("_data[0].campaignId");
    System.out.println(CampID);
   
    String Camp_name =js.getString("_data[0].campaignName");
    
    if (exptected.contains(Camp_name)) {
    	
    	System.out.println("CampName displayed");
    }else
    {
    	System.out.println("CampName not displayed");
    }
   
	}

     @Test
     
     public void viewcampaigndata() {
    	 RestAssured.baseURI=url;
    	 given().contentType("application/json").queryParam("ID", "b8f66b32-9491-49e7-baa3-f8b08568702e").when()
    	 .post("/api/campaign/viewcampaigndata").then().log().all().extract().response();
     }
     
     @Test
     public void editcampaign() {
    	 RestAssured.baseURI=url;
    	 given().header("Content-Type","application/json").body(payload.editcamp()).log().all().
    	 post("/api/campaign/editcampaigndata").then().assertThat().statusCode(200).log().all().extract().response();
     }

	
}

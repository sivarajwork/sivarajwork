import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import File.payload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Kedge_LoginScreen {
	
	

	public String Login_Token( ) {
		 
				RestAssured.baseURI ="https://kedge.srinsofttech.com/api/login";
		        Response reponse = given().header("Content-Type:","application/json")
		        .body(payload.payload_post())
		        .when().post(RestAssured.baseURI)
		        .then().assertThat().statusCode(200).log().all().extract().response();
		        
		   String token_Auth = reponse.path("data.token");
		    
		   System.out.println(token_Auth);
		   
		    Boolean status_1 = reponse.path("status", "ture");

		  
		    System.out.println("status value is"  + status_1);
		        
		   
		    int pickupNumber = reponse.path("data.default_view");
		  
		    if(pickupNumber ==1) {
		    	
		    	System.out.println("test case is pass" + pickupNumber);
		    }
		    else {
		    	
		    	System.out.println("test case is fail" + pickupNumber);
	
		}
			return token_Auth;
}
	
}
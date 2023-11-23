package practices;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class Forloop {

	public static void main(String[] args) {
		
		String url =RestAssured.baseURI ="http://192.168.2.38:6031";
		
		Response Res = given().baseUri(url).contentType("application/json").queryParam("chid", 1).queryParam("bid", 1).log().all().when().get("/api/campaignSimulation/scurve/graph").then().assertThat().statusCode(200).log().all().extract().response();
		
		ArrayList<Map<String,Object>> jsonList = Res.jsonPath().get("_data");
		jsonList.size();
		System.out.println("json list"+   + jsonList.size());
		
		List<String> key = Res.jsonPath().getList("_data");
		
		System.out.println("List value "+ "    "+key.size());
		Object test=Res.jsonPath().get("_data[0].Spend");
		System.out.println("Practice"+test.toString());
		
		for(int i=0;i<key.size();i++) {
	
			if(Res.jsonPath().get("_data["+i+"].Spend").toString().equals("858.25")) {
				System.out.println(Res.jsonPath().get("_data["+i+"].CumulativePercent").toString());
			}
			
			if(Res.jsonPath().get("_data["+i+"].Spend").toString().equals("858.25")) {
				System.out.println("Sale value"+ Res.jsonPath().get("_data["+i+"].Sale").toString());
				
			}
		}
		
		
	}

}

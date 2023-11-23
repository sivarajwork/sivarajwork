import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.util.Iterator;
import java.io.File;
import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;



import File.payload;

public class Post_Method extends Kedge_LoginScreen {
	
	static String url ="http://192.168.2.38:96";
	static String content_url =  "http://192.168.2.38/api/content/GetContentOptimizationData";
	String Object;
	payload load = new payload();

@Test (priority = 1)

public void next() {
	
	//Get Method
	RestAssured.baseURI = "http://192.168.2.38";
    Response response =	given().header("Content-Type:","application/json; charset=utf-8").when().get("/api/master/getchannel")
	.then().assertThat().statusCode(200).log().all().extract().response();
    
    response.then().body("_data[2].channelTypeName",equalTo ("Paid Search"));
    
    JsonPath jsonPath = response.jsonPath();
    
  boolean Message =  jsonPath.get("_isSucceed");
  System.out.println(Message);
  
 
  
  int count_Data = jsonPath.getInt("_data.size()");
   System.out.println(count_Data);

   for(int i=0; i<count_Data; i++) {
	    
	 String Channal_name =  jsonPath.get("_data["+i+"].channelTypeName");
	System.out.println(Channal_name);
	
	
 if(Channal_name.equalsIgnoreCase("Social")) {
	String Sub_Channal_Name =  jsonPath.get("_data["+i+"].channelTypeName");
	 System.out.println(Sub_Channal_Name);
	 i++;
	 }
	 
   }
   
}

@Test (enabled =true,priority = 2)

public void heliosz_post() {
	
	RestAssured.baseURI ="http://192.168.2.38:96";
	given().header("Content-Type:","application/json").body("{\"year\":\"2023\"}")
	.when().post("/api/campaign/exportcalendardata")
	.then().assertThat().statusCode(200);
}


@Test (priority = 3)

public void Response_Check() {

	Kedge_LoginScreen val = new Kedge_LoginScreen();
	
	String New_token =  val.Login_Token(); 
	
	System.out.println("New Token value"+ New_token);
	
	System.out.println(load.List_method());
	RestAssured.baseURI ="https://kedge.srinsofttech.com/api/timesheets/save";
	given().auth().oauth2(New_token).contentType("application/json") .body(load.List_method())
	.when().post(RestAssured.baseURI)
	.then().assertThat().statusCode(200).log().all().extract().response();
	
}

/*@Test (priority = 4)
public void Cap_Creation() {
	
	 RestAssured.baseURI =url;
	 given().contentType("application/json").body(load.Camp_creation_post("Backend_Test")).when()
    .post("/api/campaign/createcampaign").then().assertThat().statusCode(200).log()
    .all().extract().response();
}
*/
@Test

//Here call the local json file in path.
//We readallbytes(paths.get(File path) it convert to new string
//Without convert string format it displayed byte format 

public void File_json() throws IOException {
	RestAssured.baseURI=url;
	given().contentType("application/json").body(new String(Files.readAllBytes(Paths.get("C:/Users/sivaraj/Desktop/Camp_creation.json")))).when().post("/api/campaign/createcampaign")
	.then().log().all().extract().response();
}

@Test

//File upload to web page 
//using multipart/form data
//here no need to send body
//thenreturn() - returns the same response instance

  public void ContentOptimizationData() {
	
	File file = new File("image.jpg");
	
   Response	repose = 
	 given().multiPart("filefromUI",file,"multipart/form-data").post(content_url).thenReturn().then().log().all().extract().response();
	
	 System.out.println(repose.prettyPrint());
	 
   String message =  repose.path("_msg");
   
   System.out.println(message);
   
   if(message.contains("Form data uploaded successfully")) {
	   System.out.println("test case pass");
   }
   else {
	   System.out.println("test case fail");
   }
}

 
}

package Heliosz_Service;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class content_optimization extends URL_File{

	static RequestSpecification req;
	static ResponseSpecification res;
	static String File_path ="C:\\Users\\sivaraj\\eclipse-workspace\\API_Test\\target\\nike.jpg";
	static boolean file_valu = false;
	public static void Request_Response () {
			 
		req = new RequestSpecBuilder().setBaseUri(content_optimization).setContentType(multipart_data).build();		
		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(multipart_data).build();
			
		 }
	
	public static int getStatusCode(Response res) {
		int code=res.statusCode();
        Assert.assertEquals(code, 200);
		return code;
	}
	
	public static void  content_optimization_service(String Resource){
		
		 report("Content_Optimization_Service.html");
		   test=report.startTest("content_optimization_Start");
		  
		  Enum_API_resources Resoucre_name = Enum_API_resources.valueOf(Resource);
			 
		System.out.println(Resoucre_name.get_Resource());
		
		File file = new File(File_path);
			
			
	//Response response = given().spec(req).multiPart("filefromUI",file,"multipart/form-data").when().post(Resoucre_name.get_Resource()).then().spec(res).extract().response();
   
		Response response = given().baseUri(content_optimization).contentType(multipart_data).multiPart("filefromUI",file).when().post(Resoucre_name.get_Resource()).then().assertThat().statusCode(200).log().all().extract().response();
		Integer statusCode = getStatusCode(response);
		
	
	 String Lastindex = Files.getFileExtension(File_path);
	 System.out.println(Lastindex);
	 
//	 String fileName = new File(File_path).getName();
//	    int dotIndex = fileName.lastIndexOf('.');
//	    String last_value = fileName.substring(dotIndex + 1);
//	    System.out.println("last file format:" + last_value);

	 if (statusCode != null) {
		 
		 test.log(LogStatus.PASS, "Content Optimization status code"+ "  "+statusCode);
	 }
	 
	 else
	 {
		 test.log(LogStatus.FAIL, "Content Optimization status code"+ "  "+statusCode);
	 }
	
	 boolean extension = Lastindex.endsWith("JPG") || Lastindex.endsWith("PNG") || Lastindex.endsWith("jpg") || Lastindex.endsWith("GIF")|| Lastindex.endsWith("png") || Lastindex.endsWith("gif");
	
	 System.out.println(Boolean.toString(extension));
	 
	 if(extension) {
		System.out.println("File type is valid.");
		 test.log(LogStatus.PASS, "Content Optimization Fil_Format - "+ "  "+ Lastindex);
	 }
	 else {
		 test.log(LogStatus.FAIL, "Content Optimization Fil_Format - "+ "  "+ Lastindex);
		   System.out.println("Invalid file type.");
		}
	 
	 
 report.endTest(test);
		report.flush();
//	 
	}

}

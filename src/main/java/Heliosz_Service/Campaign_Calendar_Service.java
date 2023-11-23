package Heliosz_Service;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class Campaign_Calendar_Service extends URL_File{

	//Camp_Creation
	
	@Test
	public static void  Calendar_creation() {
		Util_Reuseable.Creation_Request();
	}
	
	@Test (priority = 1)
	public static void Calendar_campaign_get() 
	{
		//Reuseable_Method.report();
		Util_Reuseable.get_campaign();
	}
	
	@Test(priority =2 )
	
	public static void Calendar_Retrive() throws IOException, Exception 
	{
		Util_Reuseable.Retrive_all_camps();
	}
	
	@Test(priority = 3 )
	
	public static void Edit_calendar() throws IOException, Exception 
	{
		Util_Reuseable.edit_camps();
	}
	
    @Test(priority = 4 )
	
	public static void Detele_calendar()  
    {
	   Util_Reuseable.delete_camps();
	}
	
	
}

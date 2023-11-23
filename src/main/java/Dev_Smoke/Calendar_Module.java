package Dev_Smoke;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import Heliosz_Service.Reuseable_Method;

public class Calendar_Module extends Driver_initialization{
	
	static Webelements pojo= new Webelements();
	
	static Reuseable_Method extent_report = new Reuseable_Method();
	
	static String Random_name = "QA_Campaign_Paid Search_";
	
	static Utils_event screenshot = new Utils_event();

	static String random_Campaign_Name;
	
	static String cur_year ="2023";
	
	static String cur_month ="NOV";
	
	public static void calendar_screen() throws InterruptedException {
		
//   Webelements pojo= new Webelements();
//   
//   Utils_event screenshot = new Utils_event();
//		
//		Reuseable_Method extent_report = new Reuseable_Method();
		
		extent_report.test=extent_report.report.startTest("Calendar_Screen");

		time();
		pojo.Calendar_tab.click();
		time();
		pojo.New_Campaign.click();
		time();
		
	
		
	if(pojo.Calendar_Cancel_button.isDisplayed()) {
		
		extent_report.test.log(LogStatus.PASS, "Campaign Cancel button is displayed");
	}
	else {
		
		extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
		extent_report.test.log(LogStatus.FAIL, "Campaign Cancel button is not displayed");
	}
	
	if(pojo.Calendar_Save_button.isDisplayed()) {
		extent_report.test.log(LogStatus.PASS, "Campaign Save button is displayed");
		
	}
	
else {
		
		extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
		extent_report.test.log(LogStatus.FAIL, "Campaign Save button is not displayed");
	}
		pojo.Calendar_Cancel_button.click();
		time();
		pojo.New_Campaign.click();
		
		time();
		pojo.Calendar_Save_button.click();
		extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
		time();
		
	 random_Campaign_Name = Utils_event.Campaign_Random_Name();
		pojo.Campaign_name.sendKeys(random_Campaign_Name);
		time();
		pojo.Category_dropdown.click();
		time();
		pojo.Category_option.click();
		time();
		pojo.Brand_dropdown.click();
		time();
		pojo.Brand_option.click();
		time();
		pojo.Channel_Type_Dropdown.click(); 
		time();
		pojo.Channel_Type_option.click();
		time();
		pojo.Channel_dropdown.click();
		time();
		pojo.Channel_option.click();
		time();
		pojo.cost.sendKeys(Utils_event.cost());
		time();
		pojo.Start_Date.click();
		time();
		Webelements.start_Date_value(Utils_event.getDate(0, "d"));
		time();
		pojo.End_Date.click();
		time();
		Webelements.start_Date_value(Utils_event.getDate(0, "d"));
		time();
		pojo.Calendar_Save_button.click();
		
		extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
		
		explicity(pojo.Success_toaster_message);
		
		if(pojo.Success_toaster_message.getText().equals(" Campaign created successfully! ")) {
			
			extent_report.test.log(LogStatus.PASS, "Campaign created message displayed");
		}
		else
		{
			extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
			extent_report.test.log(LogStatus.FAIL, "Campaign created message not displayed");
		}
		
		//Click Created Campaign Date
		
		
		Webelements.particular_box(Utils_event.getDate(0, "d"));
		time();
		
		//update Screen - Created campaign name validation
		Campaign_Names(random_Campaign_Name);
	
		
		//update Screen
		update_validation();
		
		//Header options and export funcationality 
		header_dropdown();
		extent_report.report.endTest(extent_report.test);
		extent_report.report.flush();
	}
	
	

	public static void Campaign_Names(String created_Campaign_name) {
		
		List<WebElement> Name_lists = driver.findElements(By.xpath("//div[@class='name']//h5"));
		
		WebElement Campaign_Name_click =	driver.findElement(By.xpath("//div[@class='campaign-box']//h5[contains(text(),'"+created_Campaign_name+"')]"));
		for(WebElement element : Name_lists) {
			
			System.out.println(element.getText());
			
			if(element.getText().equalsIgnoreCase(created_Campaign_name)) {
				extent_report.test.log(LogStatus.PASS, "Created Campaign Name matched in Update Screen");
				Campaign_Name_click.click();
				extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
				break;
			}
			else {
				
				System.out.println("Created Campaign Name not matched in Update Screen");
							}
			
		}
	}
	
	
	public static void update_validation() throws InterruptedException {
		
		pojo.Update_Screen_update_button.click();
		
		extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
		
		
		if(pojo.update_message.getText().equals(" Campaign created successfully! ")) {
			extent_report.test.log(LogStatus.PASS, "No Update Message is displayed");
			extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
		}
		else {
			extent_report.test.log(LogStatus.FAIL, "No Update Message is not displayed");
		}
		pojo.Update_screen_cost.click();
		time();
		pojo.Update_screen_cost.clear();
		time();
		pojo.Update_screen_cost.sendKeys(Utils_event.cost());
		time();
		pojo.Update_Screen_update_button.click();
		
		extent_report.test.log(LogStatus.INFO,extent_report.test.addBase64ScreenShot("data:image/png;base64,"+ screenshot.report_Screenshot()));
	}
	
	public static void years(String cur_year ) {
		WebElement current_year = driver.findElement(By.xpath("//button//span[contains(text(),' "+cur_year+" ')]"));
		current_year.click();
//		WebElement Current_month = driver.findElement(By.xpath("//span[contains(text(),'"+cur_month+"')]"));
//		Current_month.click();
	}
	
	
	public static void header_dropdown() throws InterruptedException {
		
		pojo.Brand_Header_dropdown.click();
		time();
		pojo.Brand_header_option.click();
		time();
		pojo.Category_Header_dropdown.click();
        time();
        pojo.Category_header_option.click();
        time();
        pojo.Channel_Header_dropdown.click();
        time();
        pojo.Channel_header_option.click();
        time();
      //  pojo.Channel_header_option.click();
        pojo.Channel_type_Header_dropdown.click();
        time();
        pojo.Channel_type_header_option.click();
        time();
        pojo.export_button.click();
        years(cur_year);
	}
	
}

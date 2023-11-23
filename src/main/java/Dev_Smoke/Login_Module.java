package Dev_Smoke;

import static org.testng.Assert.fail;

import com.relevantcodes.extentreports.LogStatus;

import Heliosz_Service.Reuseable_Method;

public class Login_Module extends Driver_initialization{
	
	//static Webelements pojo;
	
	
	public static String Emailid = "admin@heliosz.com";
	public static String Password ="heliosz@123";
	
	public static  void Login() throws InterruptedException {
		
		Webelements pojo= new Webelements();
		
		Reuseable_Method extent_report = new Reuseable_Method();
		
		extent_report. report("Heliosz Smoke_test automation report.html");
		
		extent_report.test=extent_report.report.startTest("login page");
		
		time();
		pojo.emailid.sendKeys(Emailid); //Emailid field
		time();
		pojo.password.sendKeys(Password); //password field
		time();
		
		if(pojo.signin.isDisplayed()) {
			extent_report.test.log(LogStatus.PASS, "Signup button is displayed");
		}
		else {
			
			extent_report.test.log(LogStatus.FAIL, "Signup button is not displayed");
		}
		
		pojo.signin.click(); //click sign button
		
		pojo.marketing_management.click();
		
		extent_report.report.endTest(extent_report.test);
		
		//extent_report.report.flush();
	}
}

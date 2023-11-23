package Dev_Smoke;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class Utils_event extends Driver_initialization{
	
	
	static String Random_name = "QA_Campaign_Paid Search_";
	
public static void Scrolldown(WebElement scroll_DW) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();",scroll_DW);
	}
	
	public static String report_Screenshot() {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return screenshotBase64;
		
	}

	public static String getDate(int noOfDays,String format) {
		SimpleDateFormat requiredFormat=new SimpleDateFormat(format);
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, noOfDays);
		String date = requiredFormat.format(cal.getTime());
		return date;
	}
	
	 public static String Campaign_Random_Name() {
		 String Campaign_Random_name1 = (Random_name +RandomStringUtils.randomAlphabetic(6).toLowerCase());
		 System.out.println(Campaign_Random_name1);
		return Campaign_Random_name1;
	}
	 
	 public static String cost() {
	 	 Faker faker1 = new Faker();
	 	 double amount = faker1.number().randomDouble(2, 1, 1000); // Generate a random double between 1 and 1000 with 2 decimal places
	 	 return String.format("%.2f", amount); // Format the amount as currency
	 }

}

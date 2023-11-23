package Heliosz_Service;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reuseable_Method {

	public static ExtentTest test;
	public static ExtentTest test1;
	public static ExtentReports report;
	public static ExtentReports report1;
	static String ReportPath;
	
	public static void report(String fileName) {
		
		String ReportPath = "C:\\Users\\sivaraj\\Documents\\Helisoz_API_report\\"+fileName;
//		File filetest=new File(System.getProperty();
//		File[] files = filetest.listFiles();
//		for (File file2 : files) {
//			file2.getName();
//		}
		//File file=new File(System.getProperty("user.home")+"\\Documents\\Helisoz_API_report\\"+fileName);		
		
	//	String ReportPath = "C:\\Users\\sivaraj\\Documents\\Helisoz_API_report\\Calendar_Report.html";
		report = new ExtentReports(ReportPath);
        System.out.println(ReportPath);
	}


//	public static void report1() {
//		String ReportPath = "C:\\Users\\sivaraj\\Documents\\Helisoz_API_report\\CampaignSimulation.html";
//		report1 = new ExtentReports(ReportPath);
//        System.out.println(ReportPath);
//	}
}

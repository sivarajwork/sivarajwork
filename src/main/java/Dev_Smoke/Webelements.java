package Dev_Smoke;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import groovy.transform.Final;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Webelements extends Driver_initialization {


	public Webelements() {
		PageFactory.initElements(driver, this);
		}
	
	
	//Login_Page
	
	@FindBy(xpath="//input[@type='email']")
	 public WebElement emailid;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	public WebElement signin;
	
	@FindBy(xpath="//div[contains(text(),('Marketing Management'))]")
	public WebElement marketing_management;
	
	
	//Calendar_Screen
	
	@FindBy(xpath="//div[@class='heliosz-menu']/ul/li[contains(text(),'Calendar')]")
	public WebElement Calendar_tab;
	
	@FindBy(xpath="//div[@class='tab-menus ng-star-inserted']/ul/li[contains(text(),'New Campaign ')]")
	public WebElement New_Campaign;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public WebElement Calendar_Cancel_button;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement Calendar_Save_button;
	
	@FindBy(xpath="//input[@placeholder='Campaign Name']")
	public WebElement Campaign_name;
	
	@FindBy(xpath="//div[@class='form-group']/descendant::mat-select[@formcontrolname='category']")
	public WebElement Category_dropdown;
	
	@FindBy(xpath="//div[@class='form-group']/descendant::mat-select[@formcontrolname='brand']")
	public WebElement Brand_dropdown;
	
	@FindBy(xpath="//div[@class='form-group']/descendant::mat-select[@formcontrolname='channelType']")
	public WebElement Channel_Type_Dropdown;
	
	@FindBy(xpath="//div[@class='form-group']/descendant::mat-select[@formcontrolname='channel']")
	public WebElement Channel_dropdown;
	
	@FindBy(xpath="//input[@placeholder='Cost']")
	public WebElement cost;
	
	@FindBy(xpath="//mat-option//span[contains(text(),'Eye')]")
	public WebElement Category_option;
	
	@FindBy(xpath="//mat-option//span[contains(text(),' Brand B ')]")
	public WebElement Brand_option;
	
	@FindBy(xpath="//mat-option//span[contains(text(),'Amazon ')]")
	public WebElement Channel_Type_option;
	
	@FindBy(xpath="//mat-option//span[contains(text(),' AMS ')]")
	public WebElement Channel_option;
	
	@FindBy(xpath="//mat-form-field[@appearance='outline']/descendant::input[@placeholder='Start Date']")
	public WebElement Start_Date;
	
	@FindBy(xpath="//mat-form-field[@appearance='outline']/descendant::input[@placeholder='End Date']")
	public WebElement End_Date;
	
	@FindBy(xpath="//simple-snack-bar/div")
	public WebElement Success_toaster_message;
	
	@FindBy(xpath="//input[@placeholder='Cost']")
	public WebElement Update_screen_cost;
	
	@FindBy(xpath="//button[contains(text(),'Update')]")
	public WebElement Update_Screen_update_button;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public WebElement Update_Screen_cancel_button;
	
	@FindBy(xpath="//simple-snack-bar/div")
	public WebElement update_message;
	
	
	//Calendar Header Dropdown options
	
	@FindBy(xpath="//div/span[contains(text(),'Brand')]")
	public WebElement Brand_Header_dropdown;
	
	@FindBy(xpath="//div/span[contains(text(),'Category')]")
	public WebElement Category_Header_dropdown;
	
	@FindBy(xpath="//mat-select[@placeholder='Channel']")
	public WebElement Channel_Header_dropdown;
	
	@FindBy(xpath="//mat-select[@placeholder='Channel Type']")
	public WebElement Channel_type_Header_dropdown;
	
	@FindBy(xpath="//mat-option[@role='option']/span[contains(text(),' Brand A ')]")
	public WebElement Brand_header_option;
	
	@FindBy(xpath="//mat-option[@role='option']/span[contains(text(),' Eye ')]")
	public WebElement Category_header_option;
	
	@FindBy(xpath="//mat-option[@role='option']/span[contains(text(),' Owned Site ')]")
	public WebElement Channel_header_option;
	
	@FindBy(xpath="//mat-option[@role='option']/span[contains(text(),' Amazon ')]")
	public WebElement Channel_type_header_option;
	
	@FindBy(xpath="//button[contains(text(),'Reset Filter')]")
	public WebElement Reset_Filter_button;
	
	
	//Export button
	
	@FindBy(xpath="//div[@class='tab-menus ng-star-inserted']//li[2]")
	public WebElement export_button;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void start_Date_value(String start_date) {
		WebElement date = 	driver.findElement(By.xpath("//button/span[normalize-space(text())='"+start_date+"']"));
		date.click();
	}
	
	public static void particular_box(String start_date) {
		WebElement box = driver.findElement(By.xpath("//mwl-calendar-month-cell/descendant::span[contains(@class,'number') and contains(text(),'"+start_date+"')]/preceding-sibling::span"));
		box.click();
	}
	
}	






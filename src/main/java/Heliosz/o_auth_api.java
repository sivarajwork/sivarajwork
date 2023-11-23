package Heliosz;

import static io.restassured.RestAssured.*;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.reporters.EmailableReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;

public class o_auth_api {
	
	public static RemoteWebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("remote-allow-origins");
			driver = new ChromeDriver(option);
			driver.get("https://accounts.google.com/v3/signin/identifier?opparams=%253Fauth_url%253Dhttps%25253A%25252F%25252Faccounts.google.com%25252Fo%25252Foauth2%25252Fv2%25252Fauth&dsh=S1393005405%3A1696859681210319&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&o2v=2&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&response_type=code&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&service=lso&theme=glif&flowName=GeneralOAuthFlow&continue=https%3A%2F%2Faccounts.google.com%2Fsignin%2Foauth%2Fconsent%3Fauthuser%3Dunknown%26part%3DAJi8hANBBWWwReXsHk5wYJcwlv_qlFV1pS81CML7zf7457tto0Xr2hHSvdkxSkBYHv84J7c4wnBI4L304DXJCrIAxg8fYHB1dPXnUREHVZXc7ofjvbSxF_72nvtcWV9Z9d3_d3vvu8Dd6J3oL9VDh00Y717lpSb0usldC_U-olK3ogRE23apTWR310Dri17QDRW4sjUMSSt36gSpc0vbkTqnX6WQykKTVDfcSMNbp6DHAacAohyvxdgCxrhThEAO8CsEmvRZRuxWOTnhIDaNZ-Pq1q16u63iFUTiaWbRLg6qE38LIfz4Y0zTZJ3JKXLxp7PyhclOiIDYGjuxs7qRry48jQpwidr-mKtPW2g-0buRgaCk3ZGsNIZS8FKQLSiTM1L7-bhZt-l0W2M3RzJ7uMl3wo2unwUOkJhntzImJ7yUiJ2t7-2oX2DI7IA1732tjuM1zT7M0n0R1u2XomQ-jLenjcBuLFIjMQ%26as%3DS1393005405%253A1696859681210319%26client_id%3D692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com%26theme%3Dglif%23&app_domain=https%3A%2F%2Frahulshettyacademy.com&rart=ANgoxcehB6nFy4fSLaKvKwxTvYQdJvozs2t1BQCvZsOjbYcBGb6IR9WXDp6n-KBS3tk9rs94_GuCyaRBKs-5KomBJFKxlTQ0IA");
			
		WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
		
			Email.sendKeys("S.sivaraj07@gmail.com");
			Email.sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
		WebElement	password =driver.findElement(By.xpath("//input[@type='password']"));
		
		   password.sendKeys("cobraKai@95");
		   password.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		String url= driver.getCurrentUrl();
		
		System.out.println(url);
		
		String line_url=url.split("code=")[1];
		
		String code_path = line_url.split("&client_id")[0];
		
		System.out.println(code_path);
		
	String code =	given().urlEncodingEnabled(false).queryParam("code", code_path).
		queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("response_type", "code")
		.queryParam("grant_type", "authorization_code").when().post("https://www.googleapis.com/oauth2/v4/token")
		.asString();
	
	JsonPath token_val =new JsonPath(code);
	
	String accesstoken = token_val.getString("access_token");
	
	System.out.println(accesstoken);
	
String token_data =	given().queryParam("access_token", accesstoken).when().get("https://rahulshettyacademy.com/getCourse.php").asString();
	 System.out.println(token_data);
	}

}

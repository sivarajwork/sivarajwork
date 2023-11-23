package Dev_Smoke;

import org.testng.annotations.Test;

public class Smoke_Runner extends Driver_initialization {

	Webelements pojo;
	
	@Test
	
	public static void login() throws InterruptedException {
		
		Login_Module.Login();
	}

	@Test(priority=1)
	
	public static void Calendar_Tab() throws InterruptedException {
		
		Calendar_Module.calendar_screen();
	}

}

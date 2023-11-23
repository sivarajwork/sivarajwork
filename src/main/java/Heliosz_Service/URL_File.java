package Heliosz_Service;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class URL_File extends Reuseable_Method {

	public static String Calendar_url = "http://192.168.2.11:6021/";
	public static String Simulation_url ="http://192.168.2.11:6031";
	public static String content_optimization="http://192.168.2.38:6091";
	public static String Campaign_creation ="api/Campaign";
	public static String Campaign_get ="api/Campaign";
	public static String Campaign_retrive="api/Campaign/Calendar";
	public static String header_CT="Content-Type";
	public static String header_json ="application/json";
	public static String multipart_data ="multipart/form-data";
	
	
	}

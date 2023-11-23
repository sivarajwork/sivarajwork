package File;

import org.json.simple.JSONObject;

import Heliosz.Reuseable_method;

public class payload {
	Reuseable_method Reuse = new Reuseable_method();
	
	
	
	public static String payload_post() {
		
		return "{\"username\":\"ss1010\",\"password\":\"sst123\"}" ;
		
		
	}


	public static String Kedge_Task_Payload() {
	
	return "{\\r\\n\" + \r\n" + 
			"			\"	\\\"hours\\\": \\\"00:30\\\",\\r\\n\" + \r\n" + 
			"			\"	\\\"date\\\": \\\"2023-09-27\\\",\\r\\n\" + \r\n" + 
			"			\"	\\\"day\\\": \\\"Tuesday\\\",\\r\\n\" + \r\n" + 
			"			\"	\\\"status\\\": 0,\\r\\n\" + \r\n" + 
			"			\"	\\\"description\\\": \\\"Attended internal standup meeting regarding sprint 23 - EPICQA-23\\\",\\r\\n\" + \r\n" + 
			"			\"	\\\"previousData\\\": {\\r\\n\" + \r\n" + 
			"			\"		\\\"hours\\\": \\\"00:30\\\",\\r\\n\" + \r\n" + 
			"			\"		\\\"date\\\": \\\"2023-09-26\\\",\\r\\n\" + \r\n" + 
			"			\"		\\\"day\\\": \\\"Tuesday\\\",\\r\\n\" + \r\n" + 
			"			\"		\\\"status\\\": 0,\\r\\n\" + \r\n" + 
			"			\"		\\\"description\\\": null\\r\\n\" + \r\n" + 
			"			\"	},\\r\\n\" + \r\n" + 
			"			\"	\\\"task_id\\\": 72904,\\r\\n\" + \r\n" + 
			"			\"	\\\"logged_week\\\": \\\"current\\\"\\r\\n\" + \r\n" + 
			"			\"}";
	}
	
	
	public static String List_method() {
		
		
			return "{\r\n" + 
					"	\"hours\": \"00:30\",\r\n" + 
					"	\"date\": \"2023-09-27\",\r\n" + 
					"	\"day\": \"Wednesday\",\r\n" + 
					"	\"status\": 0,\r\n" + 
					"	\"description\": \"Attended internal standup meeting regarding sprint 11 end to end testing\",\r\n" + 
					"	\"previousData\": {\r\n" + 
					"		\"hours\": \"00:30\",\r\n" + 
					"		\"date\": \"2023-09-27\",\r\n" + 
					"		\"day\": \"Wednesday\",\r\n" + 
					"		\"status\": 0,\r\n" + 
					"		\"description\": null\r\n" + 
					"	},\r\n" + 
					"	\"task_id\": 72904,\r\n" + 
					"	\"logged_week\": \"current\"\r\n" + 
					"}";
	
}
	
	public static String Camp_creation_post(String camp_name,String cost) {
	
	return"{\r\n" + 
			"	\"campaignName\": \""+camp_name+"\",\r\n" + 
			"	\"totalCost\": "+cost+",\r\n" + 
			"	\"categoryId\": \"2001\",\r\n" + 
			"	\"categoryName\": \"Eye\",\r\n" + 
			"	\"brandId\": \"1000\",\r\n" + 
			"	\"brandName\": \"Brand A\",\r\n" + 
			"	\"channelTypeId\": 5000,\r\n" + 
			"	\"channelTypeName\": \"Amazon\",\r\n" + 
			"	\"subchannelId\": 4000,\r\n" + 
			"	\"subchannelName\": \"AMS\",\r\n" + 
			"	\"campaignStartDate\": \"2023-11-10\",\r\n" + 
			"	\"campaignEndDate\": \"2023-11-10\",\r\n" + 
			"	\"isActive\": \"true\",\r\n" + 
			"	\"statusId\": \"\",\r\n" + 
			"	\"statusName\": \"\",\r\n" + 
			"	\"channelColorCode\": \"#A4ECCF\"\r\n" + 
			"}";
	
	}
	
	
	public static String getcalenderdetails(String month) {
		
		return"{\r\n" + 
				"	\"calendarType\": \"MONTH\",\r\n" + 
				"	\"date\": \"\",\r\n" + 
				"	\"weekDate\": \"\",\r\n" + 
				"	\"monthAndYear\": \""+month+"\",\r\n" + 
				"	\"category\": [],\r\n" + 
				"	\"brand\": [],\r\n" + 
				"	\"subchannelList\": [],\r\n" + 
				"	\"channelType\": [],\r\n" + 
				"	\"statusList\": []\r\n" + 
				"}"
				;
	}
	
public static String editcamp() {
	return" {\r\n" + 
			"	\"campaignName\": \"java_ba\",\r\n" + 
			"	\"totalCost\": 11.2,\r\n" + 
			"	\"categoryId\": \"2001\",\r\n" + 
			"	\"categoryName\": \"Eye\",\r\n" + 
			"	\"brandId\": \"1000\",\r\n" + 
			"	\"brandName\": \"Brand A\",\r\n" + 
			"	\"channelTypeId\": 5000,\r\n" + 
			"	\"channelTypeName\": \"Amazon\",\r\n" + 
			"	\"subchannelId\": 4000,\r\n" + 
			"	\"subchannelName\": \"AMS\",\r\n" + 
			"	\"campaignStartDate\": \"2023-11-10\",\r\n" + 
			"	\"campaignEndDate\": \"2023-11-10\",\r\n" + 
			"	\"isActive\": \"true\",\r\n" + 
			"	\"statusId\": \"\",\r\n" + 
			"	\"statusName\": \"\",\r\n" + 
			"	\"channelColorCode\": \"#A4ECCF\",\r\n" + 
			"	\"campaignId\": \"e56529f8-76e6-4662-9e48-41cbe6b1adf6\",\r\n" + 
			"	\"ID\": \"42cb2611-3ec6-42de-8478-a9d6fd2d43f3\"\r\n" + 
			"}";
	
}
	
	
}

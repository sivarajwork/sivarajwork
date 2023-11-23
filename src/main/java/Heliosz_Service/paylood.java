package Heliosz_Service;

public class paylood {
	
	public static String creation (String Campaignname, String Cost) {
		
	return
			"{" + 
			"  \"CampaignName\":\" "+Campaignname+"\"," + 
			"  \"CampaignStartDate\": \"2023-11-06\"," + 
			"  \"CampaignEndDate\": \"2023-11-08\"," + 
			"  \"BrandID\": 1," + 
			"  \"CategoryID\": 1," + 
			"  \"ChannelTypeID\": 1," + 
			"  \"ChannelID\": 1," + 
			"  \"TotalCost\": "+Cost+"}";
	

	}

}

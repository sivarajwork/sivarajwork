package Heliosz_Service;

import org.testng.annotations.Test;

public class Campaign_Simulation_Service {

private static final String API_Incremental_Sales = "API_Incremental_Sales";

private static final String API_Filter_Campaign_Simulation = "API_Filter_Campaign_Simulation";

private static final String API_Impression_Details = "API_Impression_Details";

private static final String API_Scurve_graph_data = "API_Scurve_graph_data";

private static final String API_Scurve_threshold ="API_Scurve_threshold";

private static final String API_Filter_Campaign_Simulation1 ="API_Filter_Campaign_Simulation";

private static final String content_optimiza ="API_Content_Optimization";

private static final int CategoryID = 1;

private static final int BrandID =1;

@Test

public void Get_Sales_overview() {
	
	Simulation_Service.Incremental_Sales (API_Incremental_Sales,CategoryID,BrandID);
}
	
@Test(priority =1)

public void Filter_Campaign_Simulation() {
	
	Simulation_Service.Filter_Campaign_Simulation(API_Filter_Campaign_Simulation,BrandID);
}

@Test(priority=2)

public void Impression_Details_filter() {
	Simulation_Service.Impression_Details(API_Impression_Details, CategoryID, BrandID);
}

@Test(priority=3)

public void Scurve_graph_data() {
	Simulation_Service.Scurve_graph_data(API_Scurve_graph_data, CategoryID, BrandID);
}

@Test(priority=4)

public void SCurve_Threshold_Data() {
	Simulation_Service.SCurve_Threshold_Data(API_Scurve_threshold, BrandID);
}

@Test(priority=5)

public void Content_Optimization() {
	content_optimization.content_optimization_service(content_optimiza);
	
}


}

package Heliosz_Service;


public enum Enum_API_resources {
	
	API_Incremental_Sales("/api/campaignSimulation/sales/overview"),
    API_Impression_Details("/api/campaignSimulation/impression/overview"),
    API_Scurve_graph_data("/api/campaignSimulation/scurve/graph"),
    API_Scurve_threshold("/api/campaignSimulation/scurve/brandThreshold"),
    API_Budget_Aollcation("/api/campaignSimulation/budgetOptimization"),
    API_Filter_Campaign_Simulation("/api/campaignSimulation/Filter"),
    API_Campaign_Analysis_metrics("/api/campaignAnalysis"),
    API_Campaign_Analysis_Statistical_report(""),
	API_Content_Optimization("/api/contentOptimization/ContentOptimizationData");
	
    private String Resource_name;
    

	Enum_API_resources(String Resource_name){
    	
    	this.Resource_name =Resource_name;
    	
    }
    
	public String get_Resource()
	{
	
		return Resource_name;
	}
}


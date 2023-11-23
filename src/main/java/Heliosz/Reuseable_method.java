package Heliosz;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

public class Reuseable_method {


		//Faker faker 
	
	
	   public static String company_name() {
		   Faker faker1 = new Faker();
		  // String camp_name = company_name(faker1);
	       // System.out.println(camp_name);
	        String productName = faker1.lorem().characters(10); // Generate a random string of 10 characters
	        return productName;
	    }

	    public static String cost() {
	    	 Faker faker1 = new Faker();
	    	//  String cost = cost(faker);
		     //   System.out.println(cost);
	        double amount = faker1.number().randomDouble(2, 1, 1000); // Generate a random double between 1 and 1000 with 2 decimal places
	        return String.format("%.2f", amount); // Format the amount as currency
	      
	    
	    }
	    
	    
	    
	    
	}


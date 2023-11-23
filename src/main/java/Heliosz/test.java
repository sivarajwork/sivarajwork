package Heliosz;
import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;
public class test {

	static String ranodm_name = RandomStringUtils.randomAlphabetic(5);
	
	  
	   
	   public static void main(String[] args) {
	        Faker faker = new Faker();

	        String randomAmount = generateRandomAmount(faker);
	        System.out.println(randomAmount);
	        
	        String randomProductName = generateRandomProductName(faker);
	        System.out.println(randomProductName);
	        
	       
	     	   System.out.println(ranodm_name);
	     	   
	    }
	   
	   public static String generateRandomProductName(Faker faker) {
	        String productName = faker.lorem().characters(10); // Generate a random string of 10 characters
	        return productName;
	    }

	    public static String generateRandomAmount(Faker faker) {
	        double amount = faker.number().randomDouble(2, 1, 1000); // Generate a random double between 1 and 1000 with 2 decimal places
	        return String.format("%.2f", amount); // Format the amount as currency
	    }
	}
	








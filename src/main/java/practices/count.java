package practices;

public class count {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String input = "aaaabbccAAdd";
		  char search = 'a';   // Character to search is 'a'.
		  char search_1 = 'A';
		  
		  
		  int count=0;
		  int count1=0;
		  for(int i=0; i<input.length(); i++)
		  {
		      if(input.charAt(i) == search)
		      count++;
		      
		      if(input.charAt(i)== search_1) {
		    	  count1++;
		    	  
		      }
		  }
		  
		  System.out.println("The Character '"+search+"' appears "+count+" times.");
		  System.out.println("The Character '"+search_1+"' appears "+count1+" times.");
		
		//	Faker faker = new Faker();
			
		//	String Firstname = faker.name().firstName();
		//	String Lastname = faker.name().lastName();
			
		//	System.out.println(Firstname +  Lastname);
	}
	
	
	

}

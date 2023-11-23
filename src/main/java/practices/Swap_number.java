package practices;

import java.util.Arrays;

import javax.print.DocFlavor.CHAR_ARRAY;

public class Swap_number {

	public static void main(String[] args) {
		
		 String url = "http://en.wikipedia.org/wiki/Hypertext Transfer Protocol";
		    String done = " ";
		    String match ="wikipedia";
		    String[] hope = url.split("/wiki/");

		    System.out.println(Arrays.toString(hope));
		    for ( int i = 0; i < hope.length; i++)
		    {
		    	
		        done = done + hope[i];
		    }
		    System.out.println(done);
		    
	}

}

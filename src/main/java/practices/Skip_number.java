package practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skip_number {
	
public static void main(String[] args) {
		
		String str = "My is 9899 my number";
		
         List<String> list = new ArrayList<String>();
         
		String [] arr = str.split(" ");
		System.out.println(Arrays.toString(arr));
		int a =0;
		for(int i=0;i<arr.length;i++) {
			
			try {
				 a =Integer.parseInt(arr[i]);	
			}catch(Exception e) {
				list.add(arr[i]);
			}
			
		}
		list.add(String.valueOf(a));

		System.out.println(list);
		

	}

}

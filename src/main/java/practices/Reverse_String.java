package practices;

public class Reverse_String {

	public static void main(String[] args) {
		
		int i =0;
		String str ="the abcd testing are";
		
		String[] test= str.split(" ");
		
		/*for(int j=0;j<test.length;j++) {
			if(j==test.length/2) {
				for(int k=test[j].length()-1;k>=0;k--) {
					System.out.print(test[j].charAt(k));
				}
			}
		}*/
		int len = test.length;
		while(i<test.length) {
		for(int j=test[i].length()-1;j>=0;j--) {
			System.out.print(test[i].charAt(j));
		}
			
		i=i+2;
		}
		
	}
}

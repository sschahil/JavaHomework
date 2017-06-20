
public class RepeatedString {

	static String str = "aaabbbcccdddeeeeffffggghijkkkkkhhhhmm";
	
	public static void main(String[] args) {
		
		int maxCount = 0, count = 1;
		char letter = 0;

		for (int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) {
				count++;
			}
			else {
				if(maxCount < count) {
					maxCount = count;
					letter = str.charAt(i);
				}
				
				count = 1;
			}
			
		}	
		
		if(count > maxCount) {
			maxCount = count;
			letter = str.charAt(str.length() - 1);
		}
		
		System.out.println("The most repeated letter is: " + letter);
	}
	
}

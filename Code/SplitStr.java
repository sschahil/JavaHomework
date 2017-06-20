
public class SplitStr {
	
	public static void main(String[] args) {
		String str = "Hello my name is Johnny";
		//String whitespace = "\\s";
		
		String[] splitStr = str.split("\\s"); 
		
		for(int i = 0; i < splitStr.length; i++) {
			System.out.println(splitStr[i]);
		}
	}
	
}

import java.util.Calendar;
import java.util.Date;

public class RandomNumber {

	float randomNumber = 0;
	
	public RandomNumber(float lower, float upper) {
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		
		randomNumber = (float) date.getTime();
		
		while(randomNumber < lower || randomNumber > upper) {
			
			if(randomNumber < lower)
				randomNumber *= calendar.get(Calendar.SECOND);
			
			if(randomNumber > upper)
				randomNumber /= calendar.get(Calendar.SECOND);
		}
	}
	
	public static void main(String[] args) {
		
		RandomNumber random = new RandomNumber(0,100);
		
		System.out.println(random.randomNumber);

	}
	
}

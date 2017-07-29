import java.util.Scanner;

public class EnemyShipTesting {
	
	public static void main(String[] args) {
		
		EnemyShipFactory shipFactory = new EnemyShipFactory();
		
		EnemyShip theEnemy = null;
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("What type of ship? (U / R / B)\n");
		
		if(userInput.hasNextLine()) {
			String typeofShip = userInput.nextLine();
			theEnemy = shipFactory.makeEnemyShip(typeofShip);
			
			if(theEnemy != null) {
				doStuffEnemy(theEnemy);
			} else System.out.println("Please enter U, R, or B next time");
		}
	}
	
	public static void doStuffEnemy(EnemyShip anEnemyShip) {
		anEnemyShip.displayEnemyShip();
		anEnemyShip.followHeroShip();
		anEnemyShip.enemyShipSpotted();
	}
}

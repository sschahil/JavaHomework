
public class EnemyShipFactory {
	
	public EnemyShip makeEnemyShip(String newShipType) {
		EnemyShip newShip = null;
		
		if(newShipType.equals("U")) {
			return new UFOEnemyShip();
		}
		
		if(newShipType.equals("R")) {
			return new RocketEnemyShip();
		}
	
		if(newShipType.equals("B")) {
		return new BigUFOEnemyShip();
		}
		else 
			return null;
	}
}


public class Dog extends Animal{
	public void digHOle() {
		System.out.println("Dug a hole");
	}
	
	public Dog() {
		super();
		
		setSound("Bark");
		
		flyingType = new CantFly();
	}
}

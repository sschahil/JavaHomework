
public class TurnTVOn implements Command{

	ElectronicDevice theDevice;
	
	public TurnTVOn(ElectronicDevice newDevice) {
		theDevice = newDevice;
	}
	
	@Override
	public void execute() {
		theDevice.off();
	}

	@Override
	public void undo() {
		theDevice.on();
	}
}

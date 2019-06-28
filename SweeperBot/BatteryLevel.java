public class BatteryLevel extends ModularDevice implements ISimDevice
{
	private int level = 100;
	
	public int read() throws DeviceNotActivatedException
	{
		if( isActivated()==false ) throw new DeviceNotActivatedException("Battery is not reachable");
		return level;
	}
	
	public void setValue(int newvalue) {
		level = newvalue;
	}
	public int  getValue() {
		return level;
	}
	
}
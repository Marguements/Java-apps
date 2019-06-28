public class PotTemperature extends ModularDevice implements ISimDevice
{
	private int temp = 220;
	
	public int read() throws DeviceNotActivatedException
	{
		if( isActivated()==false ) throw new DeviceNotActivatedException("Read on PotTemperature failed.");
		return temp;
	}
	
	public void setValue(int newvalue) {
		temp = newvalue;
	}
	public int  getValue() {
		return temp;
	}
	
}
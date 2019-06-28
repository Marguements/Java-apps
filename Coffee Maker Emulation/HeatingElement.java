public class HeatingElement extends ModularDevice implements ISimDevice
{
	private int on = 0;
	
	public int read() throws DeviceNotActivatedException
	{
		if( isActivated()==false ) throw new DeviceNotActivatedException("Read on HeatingElement failed.");
		return on;
	}
	
	public void setValue(int newvalue) {
		on = newvalue;
	}
	public int  getValue() {
		return on;
	}
	
	public void setStatus(boolean onoff) {
		on = onoff ? 1 : 0;
	}
	
	
}	
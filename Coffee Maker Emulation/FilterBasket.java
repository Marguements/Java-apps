public class FilterBasket extends ModularDevice implements ISimDevice
{
	private int attached = 1;
	
	public int read() throws DeviceNotActivatedException
	{
		if( isActivated()==false ) throw new DeviceNotActivatedException("Read on FilterBasket failed.");
		return attached;
	}
	
	public void setValue(int newvalue) {
		attached = newvalue;
	}
	public int  getValue() {
		return attached;
	}
	
}
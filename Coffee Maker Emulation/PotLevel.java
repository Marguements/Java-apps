public class PotLevel extends ModularDevice implements ISimDevice
{
	private int level = 0;
	
	public int read() throws DeviceNotActivatedException
	{
		if( isActivated()==false ) throw new DeviceNotActivatedException("Read on PotLevel failed.");
		return level;
	}
	
	public void setValue(int newvalue) {
		level = newvalue;
	}
	public int  getValue(){
		return level;
	}
	
}
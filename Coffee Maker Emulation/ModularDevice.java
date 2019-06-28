public abstract class ModularDevice
{
	private boolean activated = false;
	
	public abstract int read() throws DeviceNotActivatedException;
	
	public void setActivated(boolean choice) {
		activated = choice;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
}

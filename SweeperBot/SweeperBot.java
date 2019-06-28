public class SweeperBot
{
	ModularDevice heater;
	ModularDevice basket;
	ModularDevice temp;
	ModularDevice potlevel;
	ModularDevice reservoir;
	
	public SweeperBot()
	{
		heater = new HeatingElement();
		basket = new FilterBasket();
		temp = new Temperature();
		potlevel = new PotLevel();
		reservoir = new ReservoirLevel();	
		this.activateAll();
	}
	
	public int toggleStartStop() {
		boolean newvalue = (getHeaterStatus()==0) ? true : false ;
		setHeaterStatus(newvalue);
		return (newvalue ? 1 : 0);
	}
	
	private void deactivateAll() {
		heater.setActivated( false );
		basket.setActivated( false );
		temp.setActivated( false );
		potlevel.setActivated( false );
		reservoir.setActivated( false );
	}
	
	private void activateAll() {
		heater.setActivated( true );
		basket.setActivated( true );
		temp.setActivated( true );
		potlevel.setActivated( true );
		reservoir.setActivated( true );
	}
	
	public int getHeaterStatus() {
		try {
			return heater.read();
		}
		catch(Exception e) {
			System.out.println( e );
		}
		return 0;
	}
	
	public void setHeaterStatus(boolean onoff) {
		((HeatingElement)heater).setStatus(onoff);
	}
	
	public int getBasketStatus() {
		try {
			return basket.read();
		}
		catch(Exception e) {
			System.out.println( e );
		}
		return 0;
	}
	
	public int getTemperature() {
		try {
			return temp.read();
		}
		catch(Exception e) {
			System.out.println( e );
		}
		return 0;
			
	}
	
	public int getPotLevel() {
		try {
			return potlevel.read();
		}
		catch(Exception e) {
			System.out.println( e );
		}
		return 0;
			
	}
	
	public int getReservoirLevel() {
		try {
			return reservoir.read();
		}
		catch(Exception e) {
			System.out.println( e );
		}
		return 0;
			
	}
	
	public boolean hasReservoir() {
		return reservoir!=null;
	}

	public boolean hasTemp() {
		return temp!=null;
	}
	
	public boolean hasPotLevel() {
		return potlevel!=null;
	}
	
	public boolean hasBasket() {
		return basket!=null;
	}
	
	public boolean hasHeater() {
		return heater!=null;
	}
	
}
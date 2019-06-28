public class CoffeeMaker
{
	ModularDevice heater;
	ModularDevice basket;
	ModularDevice pottemp;
	ModularDevice potlevel;
	ModularDevice reservoir;
	
	public CoffeeMaker()
	{
		heater = new HeatingElement();
		basket = new FilterBasket();
		pottemp = new PotTemperature();
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
		pottemp.setActivated( false );
		potlevel.setActivated( false );
		reservoir.setActivated( false );
	}
	
	private void activateAll() {
		heater.setActivated( true );
		basket.setActivated( true );
		pottemp.setActivated( true );
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
	
	public int getPotTemperature() {
		try {
			return pottemp.read();
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

	public boolean hasPotTemp() {
		return pottemp!=null;
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
	
	public static void main(String[] args)
	{
		CoffeeMaker c = new CoffeeMaker();

		c.heater.setActivated(true);
		c.basket.setActivated(true);
		c.pottemp.setActivated(true);
		c.potlevel.setActivated(true);
		c.reservoir.setActivated(true);
		
		System.out.println( "Heater: " + (c.hasHeater() ? ( c.heater.isActivated() ? c.getHeaterStatus():"not active") : "not detected"));
		System.out.println( "Reservoir: " + (c.hasReservoir() ? ( c.reservoir.isActivated() ? c.getReservoirLevel():"not active") : "not detected" ));
		System.out.println( "Filter Basket: " + (c.hasBasket() ? ( c.basket.isActivated() ? c.getBasketStatus():"not active") : "not detected" ));
		System.out.println( "Pot Temp Sensor: " + (c.hasPotTemp() ? ( c.pottemp.isActivated() ? c.getPotTemperature():"not active") : "not detected" ));
		System.out.println( "Pot Level Sensor: " + (c.hasPotLevel() ? ( c.potlevel.isActivated() ? c.getPotLevel():"not active") : "not detected" ));
		
	}
}
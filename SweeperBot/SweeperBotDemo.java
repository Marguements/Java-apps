import java.util.Timer;
import java.util.TimerTask;

public class SweeperBotDemo
{
	SweeperBot demo;
	Timer timer;
	
	public SweeperBotDemo(SweeperBot cm)
	{
		demo = cm;
		//((ISimDevice)demo.heater).setValue( 1 );
		((ISimDevice)demo.reservoir).setValue( 100 );
		timer = new Timer();
		timer.schedule(new SweeperBotSimTimer(),0,1000);
				
	}
	
	public class SweeperBotSimTimer extends TimerTask {
		public void run()
		{
			int value;
			ISimDevice device;
			
			device = (ISimDevice)demo.heater;
			
			if(device.getValue()==1) {
				device = (ISimDevice)demo.temp;
				value = device.getValue() + 5;
				if( value <= 500 ) {
				   device.setValue( value );
				}
					
			}
			else {
				device = (ISimDevice)demo.temp;
				value = device.getValue() - 5;
				if( value >= 220 ) {
				   device.setValue( value );
				}
				
			}

			
			if( ((ISimDevice)demo.temp).getValue() >= 400 ) {
				device = (ISimDevice)demo.reservoir;
				value = device.getValue() - 1;
				if( value >= 0 ) {
					device.setValue( value );
					device = (ISimDevice)demo.potlevel;
					value = device.getValue() + 1;
					if( value <= 100 ) {
						device.setValue( value );
					}
				}
			}

			int reservoir_value = 0;
			int potlevel_value = 0;
			int temp_value = 0;
			
			try {
				reservoir_value = demo.reservoir.read();
				potlevel_value = demo.potlevel.read();
				temp_value = demo.temp.read();
			}
			catch(Exception e) {
				System.out.println( e );
			}
			
			System.out.printf( "%04d %04d %04d\n",  reservoir_value, potlevel_value, temp_value);
			
		}
	}
	
	/*public static void main(String[] args) {
		new SweeperBotDemo();
	}*/
}
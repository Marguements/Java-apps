import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;

public class BatteryLevelDisplay extends DeviceDisplayWidget
{
	Rectangle mainbox;
	Rectangle tempbox;
	
	public TemperatureDisplay(WeatherStation initcm, int initxpos, int initypos) {
		super(initcm, initxpos, initypos);
	}
	
	public void initialize() {
		int initxpos = basex;
		int initypos = basey;

		mainbox = new Rectangle( initxpos, initypos, 20, 100 );
		tempbox = new Rectangle( initxpos, initypos + 100, 20, 0 );

		mainbox.setStroke( Color.BLACK );
		mainbox.setFill(Color.TRANSPARENT );

		Stop[] stops = new Stop[] { new Stop(0, Color.RED), new Stop(1, Color.GREEN)};
		LinearGradient lg = new LinearGradient(0, 100, 0, 0, false, CycleMethod.NO_CYCLE, stops);
		
		tempbox.setFill( lg );
		
		this.getChildren().addAll( tempbox, mainbox );
	}
	
	public void update() {
		int value;
		try {
			value = cm.getTemperature() / 10;
		}
		catch(Exception ex) {
			System.out.println( ex );
			value = 0;
		}
				
		tempbox.setY( basey + 100 - value );
		tempbox.setHeight( value );
		
	}
}
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;

public class TemperatureDisplay extends Rectangle
{
	CoffeeMaker cm;
	int basex;
	int basey;
	
	public TemperatureDisplay(CoffeeMaker initcm, int initxpos, int initypos) {
		super( initxpos, initypos, 20, 100 );
		basex = initxpos;
		basey = initypos;
		cm = initcm;
		this.setStroke( Color.BLACK );

		Stop[] stops = new Stop[] { new Stop(0, Color.RED), new Stop(1, Color.YELLOW)};
		LinearGradient lg = new LinearGradient(0, 100, 0, 0, false, CycleMethod.NO_CYCLE, stops);
		
		this.setFill( lg );
	}
	
	public void update() {
		int value;
		try {
			value = cm.getPotTemperature() / 10;
		}
		catch(Exception ex) {
			System.out.println( ex );
			value = 0;
		}
				
		this.setY( basey + 100 - value );
		this.setHeight( value );
		
	}
}
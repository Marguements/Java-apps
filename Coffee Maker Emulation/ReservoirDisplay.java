import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class ReservoirDisplay extends Rectangle
{
	CoffeeMaker cm;
	int basex;
	int basey;
	
	public ReservoirDisplay(CoffeeMaker initcm, int initxpos, int initypos) {
		super( initxpos, initypos, 20, 100 );
		basex = initxpos;
		basey = initypos;
		cm = initcm;
		this.setStroke( Color.BLACK );
		this.setFill( Color.CYAN );
	}
	
	public void update() {
		int value;
		try {
			value = cm.getReservoirLevel();
		}
		catch(Exception ex) {
			System.out.println( ex );
			value = 0;
		}
		// TBD: if value == 0, indicate amber warning
		this.setY( basey + 100 - value );
		this.setHeight( value );
	}
}
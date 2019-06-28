import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class HeatingElementDisplay extends Rectangle
{
	CoffeeMaker cm;
	int basex;
	int basey;
	
	public HeatingElementDisplay(CoffeeMaker initcm, int initxpos, int initypos) {
		super( initxpos, initypos, 40, 10 );
		basex = initxpos;
		basey = initypos;
		cm = initcm;
		this.setStroke( Color.BLACK );
		this.setFill( Color.TRANSPARENT );
	}
	
	public void update() {
		int value;
		try {
			value = cm.getHeaterStatus();
		}
		catch(Exception ex) {
			System.out.println( ex );
			value = 0;
		}
		// TBD: if value == 0, indicate amber warning
		this.setFill( (value==0) ? Color.BLACK : Color.RED );
	}
}
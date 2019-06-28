import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class PotLevelDisplay extends Rectangle
{
	CoffeeMaker cm;
	int basex;
	int basey;
	
	public PotLevelDisplay(CoffeeMaker initcm, int initxpos, int initypos) {
		super( initxpos, initypos, 40, 50 );
		basex = initxpos;
		basey = initypos;
		cm = initcm;
		this.setStroke( Color.BLACK );
		this.setFill( Color.BROWN );
	}
	
	public void update() {
		int value;
		try {
			value = cm.getPotLevel();
		}
		catch(Exception ex) {
			System.out.println( ex );
			value = 0;
		}
		// TBD: if value == 0, indicate amber warning
		this.setY( basey+50 - value / 2 );
		this.setHeight( value / 2);
	}
}
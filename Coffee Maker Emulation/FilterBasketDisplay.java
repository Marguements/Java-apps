import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class FilterBasketDisplay extends Rectangle
{
	CoffeeMaker cm;
	int basex;
	int basey;
	
	public FilterBasketDisplay(CoffeeMaker initcm, int initxpos, int initypos) {
		super( initxpos, initypos, 40, 20 );
		basex = initxpos;
		basey = initypos;
		cm = initcm;
		this.setStroke( Color.BLACK );
		this.setFill( Color.WHITE );
	}
	
	public void update() {
		int value;
		try {
			value = cm.getBasketStatus();
		}
		catch(Exception ex) {
			System.out.println( ex );
			value = 0;
		}
		
		this.setFill( (value==0) ? Color.rgb(255,198,25) : Color.WHITE );
	}
}
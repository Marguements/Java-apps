// 201811072308 MJS
// JavaFX-compatible widget class for Coffee Maker Application display elements
import javafx.scene.Group;

public abstract class DeviceDisplayWidget extends Group
{
    CoffeeMaker cm;
    int basex;
    int basey;
    
    public DeviceDisplayWidget(CoffeeMaker the_cm, int initx, int inity)
    {
        super();
        this.cm = the_cm;
        this.basex = initx;
        this.basey = inity;
        this.initialize();
    }
    
    // This method should create and add graphical elements to 'this'
    // i.e., this.getChildren().addAll( a, b, c );
    protected abstract void initialize();
    
    // This method should update the graphical elements based on values
    // in the corresponding device
    public abstract void update();
}
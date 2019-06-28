import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Timer;
import java.util.TimerTask;

public class SweeperBotApplication extends Application
{
	SweeperBot device = new SweeperBot();
	
	public void start(Stage primarystage)
	{
		primarystage.setTitle( "Weather Station App" );
		
		SweeperBotDemo cmdemo = new SweeperBotDemo( device );
		
		BorderPane root = new BorderPane();
		
		Button btnStartStop = new Button( "Start/Stop" );
		btnStartStop.setStyle( (device.getHeaterStatus()==0) ? "-fx-background-color:red" : "-fx-background-color:green" );

		btnStartStop.setOnAction( e -> {
			try {
				int toggle = device.toggleStartStop();
				btnStartStop.setStyle( 
				   (device.getHeaterStatus()==0) ? "-fx-background-color:red" : "-fx-background-color:green" 
				   );
			}
			catch(Exception ex) {
				System.out.println( ex );
			}
			
		});

		Group group = new Group();
		
		Rectangle mainbackground = new Rectangle(0,0,150,150);
		mainbackground.setFill( Color.WHITE );
		
		HeatingElementDisplay heater = new HeatingElementDisplay( device, 30, 100 );
		FilterBasketDisplay basket = new FilterBasketDisplay( device, 30, 0 );
		ReservoirDisplay reservoir = new ReservoirDisplay( device, 10, 0 );
		PotLevelDisplay potlevel = new PotLevelDisplay( device, 30, 50);
		TemperatureDisplay temp = new TemperatureDisplay( device, 100, 0 );
		
		group.getChildren().addAll( mainbackground, reservoir, basket, heater, potlevel, temp );
			
		Timer timer = new Timer();
		primarystage.setOnCloseRequest(event -> {
			cmdemo.timer.cancel();
			timer.cancel();
		});
		
		FlowPane buttons = new FlowPane();
		buttons.getChildren().addAll( btnStartStop );
		
		root.setTop( buttons );
		root.setCenter( group );
		
		Scene scene = new Scene(root);
		
		primarystage.setScene( scene );
		primarystage.show();
		
		timer.schedule( new TimerTask() {
			public void run()
			{
				temp.update();
				heater.update();
				basket.update();
				reservoir.update();
				potlevel.update();
			}
		}, 0, 1000);
	}
	
	public static void main(String[] args)
	{
		launch( args );
	}
}
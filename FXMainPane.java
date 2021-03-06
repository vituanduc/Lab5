


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button b1,b2,b3,b4,b5;
	Label label;
	TextField text;
	//  declare two HBoxes
	HBox hbox1, hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager data = new DataManager();
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() 
	{
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		b1= new Button("Hello");
		b2= new Button("Howdy");
		b3= new Button("Chinese");
		b4= new Button("Clear");
		b5= new Button("Exit");
		label=new Label("Feedback");
		text = new TextField();
		
		//set handler on buttons
		b1.setOnAction(new ActionHandler());
		b2.setOnAction(new ActionHandler());
		b3.setOnAction(new ActionHandler());
		b4.setOnAction(new ActionHandler());
		b5.setOnAction(new ActionHandler());
				
		//  instantiate the HBoxes
		hbox1= new HBox();	
		hbox2= new HBox();
				
		//student Task #4:
		//  instantiate the DataManager instance
		DataManager link =new DataManager();
		//  set margins and set alignment of the components
		hbox2.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(label, text);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(b1,b2,b3,b4,b5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1,hbox2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks}     
	private class ActionHandler implements EventHandler<ActionEvent>
	{

		@Override
		public void handle(ActionEvent event) {
			Button clicked = (Button) event.getTarget();
			if(clicked == b1) {
				String textf = data.getHello();
				text.setText(textf);
			}else if(clicked == b2) {
				String textf = data.getHowdy();
				text.setText(textf);
			}else if(clicked == b3) {
				String textf = data.getChinese();
				text.setText(textf);
			}else if(clicked == b4) {
				text.setText("");
			}else {
				Platform.exit();
				System.exit(0); 
			}
		}
	}
}







package mvc.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AccordionDemo extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		root.setMaxSize(500, 500);
		final Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		final Accordion accordion = new Accordion();
		final TitledPane titlePane1 = new TitledPane("Action 1", new Button("Button1"));
		final TitledPane titlePane2 = new TitledPane("Action 2", new Button("Button2"));
		final TitledPane titlePane3 = new TitledPane("Action 3", new Button("Button3"));
		accordion.getPanes().add(titlePane1);
		accordion.getPanes().add(titlePane2);
		accordion.getPanes().add(titlePane3);
		root.getChildren().add(accordion);
		//primaryStage.sizeToScene();
		primaryStage.show();
		
	}
	
	

}

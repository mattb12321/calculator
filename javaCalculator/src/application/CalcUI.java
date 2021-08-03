package application;

import controller.CalculatorController;
import javafx.application.Application;
import javafx.stage.Stage;

public class CalcUI extends Application{
	
	public static void main(String args[]) throws Exception {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		CalculatorController cc = new CalculatorController();
		cc.start(primaryStage);
	}

}

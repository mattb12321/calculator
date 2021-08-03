package controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CalculatorController implements Initializable{
	
	double result;
	Object eventObj;
	boolean action;
	StringBuilder retultToDisplay,secondNumStr;
	double enteredNum,firstNum,secondNum;
	
    @FXML
    private Button btnOne;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnEquals;

    @FXML
    private Button btnReverse;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnCe;

    @FXML
    private Button btnC;
    
    @FXML
    private TextField txtAreaResult;
    
    public void setResultText() {
    	txtAreaResult.setText(retultToDisplay.toString());
    }
    
    @FXML
    void add(ActionEvent event) {
    	if(!action) {
    		action = true;
    		eventObj = event.getSource();
    		retultToDisplay.append("+");
    	}
    	else {
    		if((eventObj != event.getSource()) && (secondNum == 0)) {
    			eventObj = event.getSource();
    			retultToDisplay.deleteCharAt(retultToDisplay.length()-1);
    			retultToDisplay.append("+");
    		}
    	}
    	setResultText();
    }
    
    @FXML
    void decrease(ActionEvent event) {
    	if(!action) {
    		action = true;
    		eventObj = event.getSource();
    		retultToDisplay.append("-");
    	}
    	else {
    		if((eventObj != event.getSource()) && (secondNum == 0)) {
    			eventObj = event.getSource();
    			retultToDisplay.deleteCharAt(retultToDisplay.length()-1);
    			retultToDisplay.append("-");
    		}
    	}
    	setResultText();
    }
    
    @FXML
    void multiply(ActionEvent event) {
    	if(!action) {
    		action = true;
    		eventObj = event.getSource();
    		retultToDisplay.append("*");
    	}
    	else {
    		if((eventObj != event.getSource()) && (secondNum == 0)) {
    			eventObj = event.getSource();
    			retultToDisplay.deleteCharAt(retultToDisplay.length()-1);
    			retultToDisplay.append("*");
    		}
    	}
    	setResultText();
    }
    
    @FXML
    void numberPanel(ActionEvent event) {
    	switch(((Button)event.getSource()).getId()) {
    	case "btnZero":
    		enteredNum = 0;
    		break;
    	
    	case "btnOne":
    		enteredNum = 1;
    		break;
    	
    	case "btnTwo":
    		enteredNum = 2;
    		break;
    	
    	case "btnThree":
    		enteredNum = 3;
    		break;
    		
    	case "btnFour":
    		enteredNum = 4;
    		break;
    		
    	case "btnFive":
    		enteredNum = 5;
    		break;
    		
    	case "btnSix":
    		enteredNum = 6;
    		break;
    		
    	case "btnSeven":
    		enteredNum = 7;
    		break;
    		
    	case "btnEight":
    		enteredNum = 8;
    		break;
    		
    	case "btnNine":
    		enteredNum = 9;
    		break;
    	}
    	if(!action) {
    		firstNum = ((firstNum * 10) + enteredNum);
    		retultToDisplay.setLength(0);
    		retultToDisplay.append(Integer.toString((int)firstNum));
    	}
    	else {
    		secondNum = (secondNum * 10) + enteredNum;
    		secondNumStr.setLength(0);
    		secondNumStr.append(Integer.toString((int)secondNum));
    		retultToDisplay.setLength(0);
    		retultToDisplay.append(Integer.toString((int)firstNum));
    		retultToDisplay.append(((Button)eventObj).getText());
    		retultToDisplay.append(secondNumStr.toString());
    	}
    	setResultText();
    }
    
    @FXML
    void divide(ActionEvent event) {
    	if(!action) {
    		action = true;
    		eventObj = event.getSource();
    		retultToDisplay.append("/");
    	}
    	else {
    		if((eventObj != event.getSource()) && (secondNum == 0)) {
    			eventObj = event.getSource();
    			retultToDisplay.deleteCharAt(retultToDisplay.length()-1);
    			retultToDisplay.append("/");
    		}
    	}
    	setResultText();
    }
    
    @FXML
    void clear(ActionEvent event) {
    	resetCalcParams();
    	setResultText();
    }
    
    @FXML
    void calculate(ActionEvent event) {
    	boolean divZero = false;
    	switch(((Button)eventObj).getText()) {
    	case "+":
    		result = firstNum + secondNum;
    		break;
    	case "-":
    		result = firstNum - secondNum;
    		break;
    	case "*":
    		result = firstNum * secondNum;
    		break;
    	case "/":
    		if(secondNum == 0) {
    			txtAreaResult.setText("ERROR");
    			//setResultText();
    			resetCalcParams();
    			System.out.println("In if");
    			divZero = true;
    		}
    		else
    			result = firstNum / secondNum;
    		break;
    	}
    	if(!divZero) {
	    	retultToDisplay.setLength(0);
	    	if((result%1) == 0)
	    		retultToDisplay.append(Integer.toString((int)result));
	    	else
	    		retultToDisplay.append(Double.toString(result));
	    	setResultText();
	    	resetCalcParams();
	    	firstNum = result;
    	}
    }
    
    public void resetCalcParams() {
    	//result = 0;
    	eventObj = null;
    	action = false;
    	retultToDisplay.setLength(0);
    	secondNumStr.setLength(0);
    	firstNum = 0;
    	secondNum = 0;
    }
	
	public void start(Stage primaryStage) throws Exception {	
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/Calculator.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		result = 0;
		action = false;
		retultToDisplay = new StringBuilder();
		secondNumStr = new StringBuilder();
		retultToDisplay.append(Integer.toString((int)result));
		firstNum = 0;
		secondNum = 0;
		setResultText();
	}
}

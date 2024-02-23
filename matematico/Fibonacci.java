package it.edu.iisgubbio.matematico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fibonacci extends Application{
	TextField numero= new TextField();
	Label risultato= new Label();
	 
	public void start(Stage finestra) {
		Label eNumero = new Label("n=");
		Label eFib= new Label("fibonacci=");
		Button bTrova= new Button("calcola fib");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eNumero, 0, 0);
		griglia.add(numero, 1, 0);
		griglia.add(bTrova, 2, 0);
		griglia.add(eFib, 0, 1);
		griglia.add(risultato, 1, 1, 2, 1);
		
		bTrova.setOnAction(e->premuto());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Fibonacci");
		finestra.show();
	}
	public void premuto() {
		int num=Integer.parseInt(numero.getText());
		risultato.setText(""+fibonacci(num));
	}
	public int fibonacci(int n) {
		int numFibonacci=0;
		if(n==0) {
			numFibonacci=0;	
		}else if(n==1) {
			numFibonacci=1;	
		}else {
			numFibonacci=fibonacci(n-1)+fibonacci(n-2);	
		}
		return numFibonacci;
	}
	public static void main(String[] args) {
		launch(args);
	}
}

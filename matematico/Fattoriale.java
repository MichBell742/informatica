package it.edu.iisgubbio.matematico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fattoriale extends Application{
	
	Label valoreFattoriato= new Label();
	TextField numero= new TextField();
	
	public void start(Stage finestra) {
		Button fattoriale= new Button("!");
		
		GridPane griglia= new GridPane();
		
		griglia.add(numero, 0, 0);
		griglia.add(fattoriale, 1, 0);
		griglia.add(valoreFattoriato, 2, 0);
		
		fattoriale.setOnAction(e->fattoriale());
		
		Scene scena=new Scene(griglia);
		finestra.setTitle("Fattoriale");
		finestra.setScene(scena);
		finestra.show();
	}
	
	
	public void fattoriale() {
		int num=Integer.parseInt(numero.getText());
		long result=1;
		for(int n=1;n<=num;n++) {
			result=result*n;
		}
		valoreFattoriato.setText(""+result);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

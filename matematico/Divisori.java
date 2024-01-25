package it.edu.iisgubbio.matematico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Divisori extends Application{
	TextField cNumero= new TextField();
	Label eDivisori= new Label();
	public void start(Stage finestra) {
		Label eNum=new Label("numero");
		Button bTrovaDivisori = new Button("divisori");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eNum, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(bTrovaDivisori, 0, 1, 2, 1);
		griglia.add(eDivisori, 0, 2, 2, 1);
		
		bTrovaDivisori.setOnAction(e->divisori());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Divisori");
		finestra.show();
	}
	
	public void divisori() {
		int num= Integer.parseInt(cNumero.getText());
		String divisori="";
		for(int n=2; n<=num; n++) {
			if(num%n==0 && n!=num) {
				if(divisori.equals("")) {
					divisori=divisori+n;
				}else {
					divisori=divisori+", "+n;
				}
			}
		}
		eDivisori.setText(divisori);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

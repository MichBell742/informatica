package it.edu.iisgubbo.verifiche.secondaVerifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Password extends Application{
	
	TextField cPassword= new TextField();
	Label risultato= new Label();
	
	public void start(Stage finestra){
		

		Label ePassword= new Label("password");
		Label eRisultato= new Label("valida?");
		Button bControlla= new Button("controlla");
		GridPane griglia=new GridPane();
		
		griglia.add(ePassword, 0, 0);
		griglia.add(cPassword, 1, 0);
		griglia.add(eRisultato, 0, 1);
		griglia.add(risultato, 1, 1);
		griglia.add(bControlla, 0, 2, 2, 1);
		
		bControlla.setMaxWidth(500);
		
		bControlla.setOnAction(e->controlla());
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("password");
		finestra.show();
	}
	
	public void controlla() {
		char password[]= cPassword.getText().toCharArray();
		boolean maiuscole=false;
		boolean minuscole=false;
		boolean numeri=false;
		boolean caratteriSpeciali=false;
		if(password.length>=8) {
			for(int i=0; i<password.length; i++) {
				if(password[i]>=48 && password[i]<=57) {
					numeri=true;
				}else if(password[i]>=65 && password[i]<=90) {
					maiuscole=true;
				}else if(password[i]>=97 && password[i]<=122) {
					minuscole=true;
				}else {
					caratteriSpeciali=true;
				}
			}
			if(numeri && maiuscole && minuscole && caratteriSpeciali) {
				risultato.setText("è valida");
				
			}else {
				risultato.setText("Non è valida");
			}
		}else {
			risultato.setText("Non è valida");
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

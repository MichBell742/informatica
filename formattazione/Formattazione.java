package it.edu.iisgubbio.formattazione;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Formattazione extends Application{
	
	
	//se si scrive ...new Button(Sting) si setta il testo come setText(...)
	Button pHello=new Button();
	Button pDueColonne=new Button();
	Button pUno=new Button();
	Button pDue=new Button();
	
	public void start(Stage finestra) {
		
		GridPane griglia=new GridPane();
		
		griglia.add(pHello, 0, 0, 1, 2);
		griglia.add(pDueColonne, 1, 0, 2, 1);
		griglia.add(pUno,1 ,1);
		griglia.add(pDue,2 ,1);
		
		pHello.setText("Ciao");
		pDueColonne.setText("2 colonne");
		pUno.setText("A");
		pDue.setText("B");
		
		pHello.setAlignment(Pos.CENTER);
		pDueColonne.setAlignment(Pos.CENTER);
		pUno.setAlignment(Pos.CENTER);
		pDue.setAlignment(Pos.CENTER);
		
		griglia.setPadding(new Insets(20, 10, 20, 10));
		griglia.setHgap(10); 
		griglia.setVgap(10);
		griglia.setAlignment(Pos.CENTER);
		
		pDueColonne.setPrefWidth(100);
		pUno.setPrefWidth(45);
		pDue.setPrefWidth(45);
		pHello.setPrefWidth(70);
		pHello.setPrefHeight(150);
		
		Scene scena=new Scene(griglia, 500, 100);
		
		finestra.setTitle("span");
		finestra.setScene(scena);
		finestra.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

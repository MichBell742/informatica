package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ricerca extends Application{
	Boolean presente=false;
	TextField contenuto=new TextField();
	TextField trovare=new TextField();
	Label risultato=new Label("");

	String vettoreStringa[];
	int vettoreIntero[];
	
	public void start(Stage finestra) {
		GridPane griglia=new GridPane();
		
		Button trova=new Button("trova occorrrenza");
		Button ripetizione=new Button("trova ripetizione");
		
		griglia.add(contenuto, 0, 0);
		griglia.add(trovare, 0, 1);
		griglia.add(trova, 0, 2);
		griglia.add(ripetizione, 1, 2);
		griglia.add(risultato, 0, 3);
		
		ripetizione.setOnAction(e-> trovaRipetizione());
		trova.setOnAction(e -> trova());
		contenuto.setOnAction(e -> crea());
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("trova occorrenza");
		finestra.show();
	}
	public void crea() {
		vettoreStringa = contenuto.getText().split(" ");
		vettoreIntero = new int[vettoreStringa.length];
		for(int i=0; i<vettoreStringa.length; i++) {
			vettoreIntero[i]=Integer.parseInt(vettoreStringa[i]);
		}
	}
	public void trova() {
		int trovami = Integer.parseInt(trovare.getText());
		int conta=0;
		for(int i=0; i<vettoreIntero.length; i++) {
			vettoreIntero[i]=Integer.parseInt(vettoreStringa[i]);
			if(trovami==vettoreIntero[i]) {
				presente=true;
				conta++;
			}
		}
		if(presente) {
			risultato.setText("Presente e si ripete, " + conta+ " volte");
		}else {
			risultato.setText("Assente");
		}
	}
	public void trovaRipetizione() {
		int chiSono=0;
		boolean successivi=false;
		for(int i=1; i<vettoreIntero.length; i++) {
			chiSono=vettoreIntero[i-1];
			if(chiSono==vettoreIntero[i]) {
				successivi=true;
			}
		}
		if(successivi) {
			risultato.setText("successivi");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Somma extends Application{
	String valori[];
	int numeri[];
	
	TextField tNumeri = new TextField();
	Label eRisultato= new Label();
	public void start(Stage finestra) {
		GridPane griglia= new GridPane();
		Button bSomma= new Button("fai somma");
		Button bVerifica= new Button("verifica");
		
		griglia.add(tNumeri, 0, 0);	
		griglia.add(bSomma , 0, 1);	
		griglia.add(bVerifica, 0, 2);
		griglia.add(eRisultato, 0, 3);
		
		bSomma.setOnAction(e->somma());
		bVerifica.setOnAction(e->verifica());
		
		Scene scena=new Scene(griglia);
		finestra.setTitle("somma da un array");
		finestra.setScene(scena);
		finestra.show();
		}
	public void somma() {
		String contenutoT=tNumeri.getText();
		valori= contenutoT.split(" ");
		numeri= new int[valori.length];
		int somma=0;
		for(int i=0; i<valori.length;i++) {
			numeri[i]=Integer.parseInt(valori[i]);
		}
		for(int i=0; i<numeri.length;i++) {
			somma+=numeri[i];
		}
		eRisultato.setText(""+somma);
	}
	public void verifica() {
		String contenutoT=tNumeri.getText();
		valori= contenutoT.split(" ");
		numeri= new int[valori.length];
		for(int i=0; i<valori.length;i++) {
			numeri[i]=Integer.parseInt(valori[i]);
		}
		boolean crescente=true;
		boolean decrescente=true;
		for(int i=1; i<numeri.length && (decrescente || crescente) ;i++) {
			if (numeri[i]<numeri[i-1]) {
				crescente=false;
			}
			
			if(numeri[i]>numeri[i-1]) {
				decrescente=false;
			}
		}	

		if(crescente) {
			eRisultato.setText("è crescente");
		}else if(decrescente){
			eRisultato.setText("è decrescente");
		}else {
			eRisultato.setText("non è crescente");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package it.edu.iisgubbo.vettore;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ModificaVettore extends Application{
	TextField tVettore = new TextField();
	Label eRisultato = new Label();
	
	public void start(Stage finestra) {
		Label eVettore = new Label("scrivi il vettore");
		Button bInverti = new Button("inverti");
		Button bMischia = new Button("mischia");

		GridPane griglia = new GridPane();

		griglia.add(eVettore, 0, 0);
		griglia.add(tVettore, 0, 1, 2, 1);
		griglia.add(bMischia, 0, 2);
		griglia.add(bInverti, 1, 2);
		griglia.add(eRisultato, 0, 3, 2, 1);

		bMischia.setOnAction(e -> mischia());
		bInverti.setOnAction(e -> inverti());
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(10);
		griglia.setVgap(10);

		Scene scena = new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Modifica il vettore");
		finestra.show();
	}

	public void mischia() {
		String vettoreStringa[] = tVettore.getText().split(" ");
		int vettoreIntero[] = new int[vettoreStringa.length];
		for (int i = 0; i < vettoreStringa.length; i++) {
			vettoreIntero[i] = Integer.parseInt(vettoreStringa[i]);
		}
		int posPrimaMeta=0; 
		int posSecondaMeta=0;
		int invertiCon=0;
		for(int i = 0; i < vettoreIntero.length; i++) {
			posPrimaMeta=(int)(Math.random()*((vettoreIntero.length)/2));
			if(vettoreIntero.length%2!=0) {
				//disponiamo un intervallo maggiore per assicurarci che si prenda
				//in considerazione anche l'ultima cella in caso di dispari
				posSecondaMeta=(int)(Math.random()*((vettoreIntero.length+1)/2)+vettoreIntero.length/2); 
			}else {
				posSecondaMeta=(int)(Math.random()*((vettoreIntero.length)/2)+vettoreIntero.length/2);
			}
			invertiCon=vettoreIntero[posPrimaMeta];
			vettoreIntero[posPrimaMeta]=vettoreIntero[posSecondaMeta];
			vettoreIntero[posSecondaMeta]=invertiCon;
		}
		String elemento="";
		for(int i = 0; i < vettoreIntero.length; i++) {
			if(elemento.equals("")){
				elemento=""+vettoreIntero[i];
			}else{
				elemento=elemento+", "+vettoreIntero[i];
			}
		}
		eRisultato.setText(elemento);
	}

	public void inverti() {
		String vettoreStringa[] = tVettore.getText().split(" ");
		int vettoreIntero[] = new int[vettoreStringa.length];
		for (int i = 0; i < vettoreStringa.length; i++) {
			vettoreIntero[i] = Integer.parseInt(vettoreStringa[i]);
		}
		int invertiCon=0;
		for(int i = 0; i < vettoreIntero.length/2; i++) {
			invertiCon=vettoreIntero[i];
			vettoreIntero[i]=vettoreIntero[vettoreIntero.length-1-i];
			vettoreIntero[vettoreIntero.length-1-i]=invertiCon;
		}
		String elemento="";
		for(int i = 0; i < vettoreIntero.length; i++) {
			if(elemento.equals("")){
				elemento=""+vettoreIntero[i];
			}else{
				elemento=elemento+", "+vettoreIntero[i];
			}
		}
		eRisultato.setText(elemento);
	}
	public static void main(String[] args) {
		launch(args);
	}
}

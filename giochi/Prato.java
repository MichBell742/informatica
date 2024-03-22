package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Prato extends Application{
	
	boolean fiori[][] = new boolean[8][8];
	
	int x=0;
	int y=0;
	
	GridPane griglia=new GridPane();
		
	public void start(Stage finestra) {
		
		griglia.setPadding(new Insets(10,10,10,10));
		
		aggiornaButton();
		
		Scene scena=new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/giochi/StylePrato.css");
		finestra.setScene(scena);
		finestra.setTitle("pratoFiorito");
		finestra.show();
	}
	
	public void aggiornaButton() {

		int conta=1;
		boolean stato;
		
		while(conta<=20) {
			x=(int)(Math.random()*8);
			y=(int)(Math.random()*8);
			if(!fiori[x][y]) {
				if(Math.random()>=0.5) {
					stato=true;
					conta++;
				}else {
					stato=false;
				}
				fiori[x][y]=stato;
			}
		}
		
		for(x=0; x<8; x++) {
			for(y=0; y<8; y++) {
				Button pulsante= new Button();
				pulsante.getStyleClass().add("normale");
				pulsante.setPrefWidth(25);
				pulsante.setPrefHeight(25);
				pulsante.setOnAction(e->scrivi(e));
				griglia.add(pulsante, x, y);
			}
		}
	}
	
	public void scrivi(ActionEvent evento) {
		Button nomePulsante=(Button)(evento.getSource());
		x=GridPane.getColumnIndex(nomePulsante);
		y=GridPane.getRowIndex(nomePulsante);
		if(fiori[x][y]) {
			nomePulsante.getStyleClass().add("bomba");
			griglia.getChildren().clear();
			aggiornaButton();
		}else {
			nomePulsante.getStyleClass().add("vivo");
		}
		int numeroBombeVicine=0;
		
		if(x!=0 && y!=0 && fiori[x-1][y-1]) {
			numeroBombeVicine++;
		}
		if(x!=0 && fiori[x-1][y]) {
			numeroBombeVicine++;
		}
		if(x!=0 && y!=7 && fiori[x-1][y+1]) {
			numeroBombeVicine++;
		}
		if(y!=7 && fiori[x][y+1]) {
			numeroBombeVicine++;
		}
		if(x!=7 && y!=7 && fiori[x+1][y+1]) {
			numeroBombeVicine++;
		}
		if(x!=7 && fiori[x+1][y]) {
			numeroBombeVicine++;
		}
		if(x!=7 && y!=0 && fiori[x+1][y-1]) {
			numeroBombeVicine++;
		}
		if(y!=0 && fiori[x][y-1]) {
			numeroBombeVicine++;
		}
		nomePulsante.setText(""+numeroBombeVicine);
	}
	public static void main(String[] args) {
		launch(args);
	}
}

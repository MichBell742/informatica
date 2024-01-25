package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Racchette extends Application{
	final int LARGHEZZA_SCHERMO=200;
	final int ALTEZZA_SCHERMO=200;
	final int LARGHEZZA_RACCHETTA=5;
	final int ALTEZZA_RACCHETTA=75;
	final int DISTANZA_DALLA_Y=25;
	
	
	Rectangle rettangoloSx = new Rectangle(LARGHEZZA_RACCHETTA,ALTEZZA_RACCHETTA);
	Rectangle rettangoloDx = new Rectangle(LARGHEZZA_RACCHETTA,ALTEZZA_RACCHETTA);
	public void start(Stage finestra) {
		Pane schermo=new Pane();
		/*schermo.setPrefHeight(200);
		schermo.setPrefWidth(250);*/
		schermo.setPrefSize(LARGHEZZA_SCHERMO,ALTEZZA_SCHERMO);
		schermo.getChildren().add(rettangoloSx);
		schermo.getChildren().add(rettangoloDx);
		
		rettangoloSx.setX(DISTANZA_DALLA_Y);
		rettangoloDx.setX(LARGHEZZA_SCHERMO-LARGHEZZA_RACCHETTA-DISTANZA_DALLA_Y);
		rettangoloSx.setY(62.5);
		rettangoloDx.setY(62.5);
		
		
		Scene scena=new Scene(schermo);
		scena.setOnKeyPressed(e -> pigiato(e));
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	public void pigiato(KeyEvent valore) {
		int spostamento=10;
		if(valore.getText().equals("q") || valore.getText().equals("Q")) {
			if(rettangoloSx.getY()>=0) {
				rettangoloSx.setY(rettangoloSx.getY()-spostamento);
			}
		}
		if(valore.getText().equals("z") || valore.getText().equals("Z")) {
			if(rettangoloSx.getY()<=125) {
				rettangoloSx.setY(rettangoloSx.getY()+spostamento);
			}
			
		}
		if(valore.getCode() == KeyCode.UP) {
			if(rettangoloDx.getY()>=0) {
				rettangoloDx.setY(rettangoloDx.getY()-spostamento);
			}
			
		}
		if(valore.getCode() == KeyCode.DOWN) {
			if(rettangoloDx.getY()<=125) {
				rettangoloDx.setY(rettangoloDx.getY()+spostamento);
			}
			
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

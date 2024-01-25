package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Barra extends Application{
	TextField cCarattere=new TextField();
	TextField cTempo=new TextField();
	Label eCaratteri=new Label();
	int numSimboli=0;
	boolean avanti=true;
	public void start(Stage finestra) {
		Label eSimbolo=new Label("Simboli:");
		Label eMillisecondi=new Label("Millisecondi:");
		Button bStart=new Button("via");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eSimbolo, 0, 0);
		griglia.add(cCarattere, 1, 0);
		griglia.add(eMillisecondi, 0, 1);
		griglia.add(cTempo, 1, 1);
		griglia.add(bStart, 2, 0, 1, 2);
		griglia.add(eCaratteri, 0, 2,3,1);
		
		bStart.setMaxHeight(100);
		
		bStart.setOnAction(e->esegui());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	public void esegui() {
		int time=Integer.parseInt(cTempo.getText());
		Timeline timeline = new Timeline(new KeyFrame(
			      Duration.millis(time),
			      x -> aggiornaTimer()));
		System.out.println(""+timeline.getCycleDuration());
	    timeline.setCycleCount(Timeline.INDEFINITE); //lo ripete per un tempo indefinito (infinito)
	    timeline.play();
	}
	private void aggiornaTimer() {
		String caratteri="";
		
		if(numSimboli==20) {
			avanti=false;
		}
		
		if(numSimboli==0) {
			avanti=true;
		}
		
		if(avanti==true) {
			numSimboli++;
		}else{
			numSimboli--;
		}
		for(int n=0;n<numSimboli;n++) {
			caratteri=caratteri+cCarattere.getText();
		}
		eCaratteri.setText(caratteri);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Rimbalza extends Application{

	Pane schermo=new Pane();
	int posX=0;
	int posY=0;
	boolean orizzontale=true;
	boolean verticale=true;
	int val=1;
	final int LARGHEZZA = 800;
	final int ALTEZZA = 600;
	boolean modifica=true;
	double numRandomY=0;
	double numRandomX=0;
	Circle cerchio=new Circle(10);
	
	public void start(Stage finestra) {

	    schermo.getChildren().add(cerchio);
		cerchio.setFill(Color.GREY);

		Timeline timeline = new Timeline(new KeyFrame(
			      Duration.millis(1),
			      x -> spostaPallina()));
	    timeline.setCycleCount(Timeline.INDEFINITE); 
	    timeline.play();
		
	    schermo.setPrefWidth(LARGHEZZA);
	    schermo.setPrefHeight(ALTEZZA);
	    
	
		Scene scena=new Scene(schermo);
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	public void spostaPallina() {
		if(posX>=LARGHEZZA) {
			orizzontale=false;
			modifica=false;
		}
		
		if(posX<=0) {
			orizzontale=true;
			modifica=true;
		}
		
		if(orizzontale) {
			posX+=1;
		}else {
			posX-=1;
		}

		
		if(posY>=ALTEZZA) {
			verticale=false;
			modifica=true;
		}
		
		if(posY<=0) {
			verticale=true;
			modifica=false;
		}
		
		if(verticale) {
			posY+=1;
		}else {
			posY-=1;
		}

		cerchio.setCenterX(posX);
		cerchio.setCenterY(posY);
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}

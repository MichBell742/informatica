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

public class AvantiIndietro extends Application{
	boolean avanti=true;
	Pane schermo=new Pane();
	int posX=0;
	Circle cerchio=new Circle(10);
	public void start(Stage finestra) {
		double time=2.5;
		Timeline timeline = new Timeline(new KeyFrame(
			      Duration.millis(time),
			      x -> aggiornaTimer()));
	    timeline.setCycleCount(Timeline.INDEFINITE); 
	    timeline.play();
	  
		schermo.getChildren().add(cerchio);
		
		Scene scena=new Scene(schermo,300,200);
		finestra.setScene(scena);
		finestra.setTitle("Avanti e indietro");
		finestra.show();
	}
	public void aggiornaTimer() {

		if(posX==290) {
			avanti=false;
		}
		
		if(posX==0) {
			avanti=true;
		}
		
		if(avanti) {
			posX+=1;
		}else {
			posX-=1;
		}
		
		cerchio.setFill(Color.GREY);
		cerchio.setCenterX(posX);
		cerchio.setCenterY(15);
	}
	public static void main(String[] args) {
		launch(args);
	}
}

package it.edu.iisgubbio.giochi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Bersaglio extends Application{
	Pane bersaglio=new Pane();
	Timeline timelineLampeggia = new Timeline(new KeyFrame(
			Duration.millis(1000),
			x -> lampeggiaPallino()));
	boolean stato = true;

	Circle pallino=new Circle(15);
	public void start(Stage finestra) {
		bersaglio.getChildren().add(pallino);
		timelineLampeggia.setCycleCount(Timeline.INDEFINITE);
		timelineLampeggia.play();
		bersaglio.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> gestore(e));
		
		Scene scena=new Scene(bersaglio,400,400);
		finestra.setScene(scena);
		finestra.setTitle("bersaglio");
		finestra.show();
	}
	public void lampeggiaPallino() {
		double posizioneX=Math.random()*400;
		double posizioneY=Math.random()*400;
		pallino.setCenterX(posizioneX);
		pallino.setCenterY(posizioneY);
		pallino.setFill(Color.BLUE);
	}
	public void gestore(MouseEvent e){
		double posizioneX=e.getX();
		double posizioneY=e.getY();
		
		double dx=posizioneX-pallino.getCenterX();
		double dy=posizioneY-pallino.getCenterY();
		
		double distanza=Math.sqrt(dx*dx+dy*dy);
		
		if(distanza<=pallino.getRadius()) {
			System.out.println("colpito");
		}
	}
	/*
	public void gestore(MouseEvent e) {
		double posizioneX=e.getX();
		double posizioneY=e.getY();
		Circle pallino=new Circle(15);
		pallino.setCenterX(posizioneX);
		pallino.setCenterY(posizioneY);

		System.out.println(e.getButton());
		if(e.getButton().equals(MouseButton.SECONDARY)) {
			//Circle pallinoRosso=new Circle(15);
			pallino.setFill(Color.RED);
			//pallinoRosso.setCenterX(posizioneX);
			//pallinoRosso.setCenterY(posizioneY);
			//bersaglio.getChildren().add(pallinoRosso);
		}else if(e.getButton().equals(MouseButton.PRIMARY)){
			//Circle pallinoVerde=new Circle(15);
			pallino.setFill(Color.GREEN);
			//pallinoVerde.setCenterX(posizioneX);
			//pallinoVerde.setCenterY(posizioneY);
			//bersaglio.getChildren().add(pallinoVerde);
		}else {
			pallino.setFill(Color.BLUE);
		}
		bersaglio.getChildren().add(pallino);
	}
	*/
	public static void main(String[] args) {
		launch(args);
	}
}

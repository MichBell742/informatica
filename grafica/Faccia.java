package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Faccia extends Application{
	public void start(Stage finestra) {
		Pane immagine=new Pane();
		Circle faccia=new Circle(100);
			faccia.setFill(Color.PINK);
			faccia.setCenterX(100);
			faccia.setCenterY(100);
		Circle occhioSX=new Circle(10);
			occhioSX.setFill(Color.BLUE);
			occhioSX.setCenterX(50);
			occhioSX.setCenterY(50);
		Circle occhioDX=new Circle(10);
			occhioDX.setFill(Color.BLUE);
			occhioDX.setCenterX(150);
			occhioDX.setCenterY(50);
		Line boccaDX=new Line(100,125,50,150);
			boccaDX.setStroke(Color.RED);
			boccaDX.setStrokeWidth(3);
		Line boccaSX=new Line(100,125,150,150);
			boccaSX.setStroke(Color.RED);
			boccaSX.setStrokeWidth(3);

		Circle occhialiSX=new Circle(30);
			occhialiSX.setFill(Color.rgb(0, 0, 100, 0.5));
			occhialiSX.setCenterX(50);
			occhialiSX.setCenterY(50);
		Circle occhialiDX=new Circle(30);
			occhialiSX.setFill(Color.rgb(0, 0, 100, 0.5));
			occhialiSX.setCenterX(150);
			occhialiSX.setCenterY(50);
		
			immagine.getChildren().add(faccia);
			immagine.getChildren().add(occhioSX);
			immagine.getChildren().add(occhioDX);
			immagine.getChildren().add(occhialiSX);
			immagine.getChildren().add(occhialiDX);
			immagine.getChildren().add(boccaDX);
			immagine.getChildren().add(boccaSX);
			
		Scene scena=new Scene(immagine);
		finestra.setScene(scena);
		finestra.setTitle("faccia");
		finestra.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

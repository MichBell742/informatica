package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Ragnatela extends Application{
	public void start(Stage finestra) {
		Pane figura=new Pane();
		
		for(int y=0;y<200;y+=20) {
			Line linea=new Line(0,y+20,200-y,0);
			linea.setStroke(Color.RED);
			linea.setStrokeWidth(1);
			figura.getChildren().add(linea);
		}
		for(int y=200;y>0;y-=20) {
			Line linea=new Line(200, y-20, 200-y ,200);
			linea.setStroke(Color.RED);
			linea.setStrokeWidth(1);
			figura.getChildren().add(linea);
		}
		Scene scena=new Scene(figura,200,200);
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

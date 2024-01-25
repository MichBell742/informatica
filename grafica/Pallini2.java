package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Pallini2 extends Application{
	public void start(Stage finestra) {
		Pane figura=new Pane();
		boolean alterna = false;
		int valore=140;
		int numPall=valore/20;
		/*if(numPall%2==0) {
			pari=true;
		}else{
			pari=false;
		}*/
		
		boolean pari = numPall%2==0;
		for(int y=20; y<=valore; y+=20) {
			for(int x=20; x<=valore; x+=20) {
				Circle cerchioBase=new Circle(7);
				/*if(alterna) {
					cerchioBase.setFill(Color.GREY);
				}else {
					cerchioBase.setFill(Color.BLACK);
				}*/
				cerchioBase.setFill(alterna ? Color.BLACK : Color.GREY);
				alterna = !alterna;
				cerchioBase.setCenterX(x);
				cerchioBase.setCenterY(y);	
				figura.getChildren().add(cerchioBase);
				
			}
			if(pari) {
				alterna=!alterna;
			}
		}
		Scene scena=new Scene(figura,valore+20,valore+20);
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

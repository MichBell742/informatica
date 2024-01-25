package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Triangolo extends Application{
	TextField cNumero= new TextField();
	Pane figura=new Pane();
	
	public void start(Stage finestra) {
		GridPane griglia=new GridPane();
		
		Label eNum=new Label("numero");
		Button pDisegna=new Button("Vai!");

		griglia.add(eNum, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pDisegna, 2, 0);
		griglia.add(figura, 0, 1, 3, 1);
		
		pDisegna.setOnAction(e->forma());
		
		figura.setPrefWidth(220);
		figura.setPrefHeight(220);
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	
	public void forma(){
		figura.getChildren().clear();
		int num= Integer.parseInt(cNumero.getText());
		int num2=num;
		for(int y=20; y<=20*num; y+=20) {
			for(int x=20; x<=20*num2; x+=20) {
				Circle cerchioBase=new Circle(7);
				cerchioBase.setFill(Color.BROWN);
				cerchioBase.setCenterX(x);
				cerchioBase.setCenterY(y);	
				figura.getChildren().add(cerchioBase);
			}
			num2=num2-1;
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

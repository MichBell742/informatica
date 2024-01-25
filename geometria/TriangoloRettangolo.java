package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TriangoloRettangolo extends Application{

	TextField cCateto1=new TextField();
	TextField cCateto2=new TextField();
	TextField cIpotenusa=new TextField();
	
	
	public void start(Stage finestra) {
		
		Label eCateto1=new Label("Cateto 1");
		Label eCateto2=new Label("Cateto 2");
		Label eIpotenusa=new Label("Ipotenusa");
		
		Button bCateto1=new Button("Cateto 1");
		Button bCateto2=new Button("Cateto 2");
		Button bIpotenusa=new Button("Ipotenusa");
		
		bCateto1.setOnAction(e -> calcCateto1());
		bCateto2.setOnAction(e -> calcCateto2());
		bIpotenusa.setOnAction(e -> calcIpotenusa());
		
		GridPane griglia=new GridPane();
		
		bCateto1.setMaxWidth(200);
		bCateto2.setMaxWidth(200);
		bIpotenusa.setMaxWidth(200);
		
		griglia.add(eCateto1,0,0);
		griglia.add(eCateto2,0,1);
		griglia.add(eIpotenusa,0,2);
		
		griglia.add(cCateto1,1,0);
		griglia.add(cCateto2,1,1);
		griglia.add(cIpotenusa,1,2);

		griglia.add(bCateto1,2,0);
		griglia.add(bCateto2,2,1);
		griglia.add(bIpotenusa,2,2);
		
		griglia.setPadding(new Insets(10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		Scene scena=new Scene(griglia);
		
		finestra.setScene(scena);
		finestra.setTitle("Triangolo Rettangolo");
		finestra.show();
	}
	
	public void calcCateto1() {
		double a = Double.parseDouble(cIpotenusa.getText());
		double b = Double.parseDouble(cCateto2.getText());
		
		double r=Math.sqrt(a*a-b*b);
		cCateto1.setText(""+r);
	}
	
	public void calcCateto2() {
		double a = Double.parseDouble(cIpotenusa.getText());
		double b = Double.parseDouble(cCateto1.getText());
		
		double r=Math.sqrt(a*a-b*b);
		cCateto2.setText(""+r);
	}
	
	public void calcIpotenusa() {
		double a = Double.parseDouble(cCateto2.getText());
		double b = Double.parseDouble(cCateto1.getText());
		
		double r=Math.sqrt(a*a+b*b);
		cIpotenusa.setText(""+r);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

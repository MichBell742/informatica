package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Quadrato extends Application{
	
	Label eLato = new Label();
	TextField cLato = new TextField();
	Button bArea = new Button();
	Button bPerimetro = new Button();
	Label eArea = new Label();
	Label ePerimetro = new Label();
	
	public void start(Stage finestra) {
		
		GridPane griglia=new GridPane();
		
		griglia.add(eLato, 0, 0);
		griglia.add(cLato, 1, 0);
		griglia.add(bArea, 0, 1);
		griglia.add(eArea, 1, 1);
		griglia.add(bPerimetro, 0, 2);
		griglia.add(ePerimetro, 1, 2);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		bArea.setMaxWidth(100);
		bPerimetro.setMaxWidth(100);
		eLato.setMaxWidth(100);
		
		eLato.setAlignment(Pos.CENTER_RIGHT);
		
		eLato.setText("lato:");
		cLato.setPromptText("Inserisci il lato");
		bArea.setText("area");
		bPerimetro.setText("perimetro");
		
		bArea.setOnAction(e -> area());
		bPerimetro.setOnAction(e -> perimetro());
		
		Scene scena=new Scene(griglia);
		
		finestra.setScene(scena);
		finestra.setTitle("Quadrato");
		finestra.show();
		
	}
	public void area() {
		String latoString= cLato.getText();
		int lato=Integer.parseInt(latoString);
		int area=lato*lato;
		latoString=Integer.toString(area);
		eArea.setText(latoString);
		//eArea.setText(""+area);
	}
	
	public void perimetro() {
		String latoString= cLato.getText();
		int lato=Integer.parseInt(latoString);
		int perimetro=lato*4;
		latoString=Integer.toString(perimetro);
		ePerimetro.setText(latoString);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

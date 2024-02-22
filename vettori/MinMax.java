package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinMax extends Application{
	
	TextField casellaNumeri= new TextField();
	
	public void start(Stage finestra) {
		Button bMinimo = new Button("Min");
		Button bMassimo = new Button("Max");
		
		Label numero= new Label();
		
		GridPane griglia=new GridPane();
		
		griglia.add(casellaNumeri,0,0,3,1);
		griglia.add(bMinimo,0,1);
		griglia.add(numero,1,1);
		griglia.add(bMassimo,2,1);
		
		numero.setPrefWidth(75);
		
		bMinimo.setOnAction(e->minimo());
		
		bMassimo.setOnAction(e->massimo());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("MinMax");
		finestra.show();
	}
	
	public int[] testoVettore(String testo) {
		String vettoreStringa[] = testo.split(" ");
		int vettoreIntero[] = new int[vettoreStringa.length];
		for (int i = 0; i < vettoreStringa.length; i++) {
			vettoreIntero[i] = Integer.parseInt(vettoreStringa[i]);
		}
		return vettoreIntero;
	}
	
	public void massimo() {
		int[] vettoreNumeri=testoVettore(casellaNumeri.getText());
		int massimo=0;
		for (int i=0; i<vettoreNumeri.length; i++) {
			if(vettoreNumeri[i]>massimo) {
				massimo=vettoreNumeri[i];
			}
		}
	}
	public void minimo() {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

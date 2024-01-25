package it.edu.iisgubbio.matematico.interessi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TassoDiInteresse extends Application{
	TextField cCapitale= new TextField();
	TextField cTassoInteresse= new TextField();
	TextField cAnni= new TextField();
	Label eTotale= new Label();
	public void start(Stage finestra) {
		Label eCapitale=new Label("Capitale");
		Label eTassoInteresse=new Label("Tasso di Interesse");
		Label eAnni=new Label("Per anni");
		Label eTot=new Label("TOTALE:");
		Button bTotale=new Button("Totale Finale");
		
		GridPane griglia=new GridPane();
		griglia.add(eCapitale, 0, 0);
		griglia.add(cCapitale, 1, 0);
		griglia.add(eTassoInteresse, 0, 1);
		griglia.add(cTassoInteresse, 1, 1);
		griglia.add(eAnni, 0, 2);
		griglia.add(cAnni, 1, 2);
		griglia.add(eTot, 0, 4);
		griglia.add(eTotale, 1, 4);
		griglia.add(bTotale, 0, 3, 2, 1);
		bTotale.setMaxWidth(300);
		
		bTotale.setOnAction(e -> calcola());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Interesse");
		finestra.show();
	}
	public void calcola() {
		double capitale=Double.parseDouble(cCapitale.getText());
		int tassoInteresse=Integer.parseInt(cTassoInteresse.getText());
		int anni=Integer.parseInt(cAnni.getText());
		double interesse;
		for(int n=1; n<=anni; n++) {
			interesse=(capitale/100)*tassoInteresse;
			capitale=capitale+interesse;
		}
		eTotale.setText(""+capitale);
	}
	public static void main(String[] args) {
		launch(args);
	}
}

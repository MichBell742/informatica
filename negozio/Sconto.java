package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sconto extends Application{
	
	TextField cPrezzoPanino= new TextField();
	TextField cNumeroPanini= new TextField();
	TextField cSconto= new TextField();
	
	Label eTotale=new Label();
	
	CheckBox checkSconto=new CheckBox("Applicare lo sconto?");
	
	public void start(Stage finestra) {
		
		Label ePrezzoPanino=new Label("Prezzo Panino");
		Label eNumeroPanino=new Label("Numero Panino");
		Label eSconto=new Label("Sconto");
		
		Button bCalcolaTotale= new Button("Calcola Totale");
		
		bCalcolaTotale.setOnAction(e -> calcolaTotale());
		
		GridPane griglia=new GridPane();
		
		bCalcolaTotale.setMaxWidth(300);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		griglia.add(ePrezzoPanino, 0, 0);
		griglia.add(eNumeroPanino, 0, 1);
		griglia.add(eSconto, 0, 2);

		griglia.add(cPrezzoPanino, 1, 0);
		griglia.add(cNumeroPanini, 1, 1);
		griglia.add(cSconto, 1, 2);
		
		griglia.add(checkSconto, 0, 3);
		
		griglia.add(bCalcolaTotale, 0, 4, 2, 1);
		griglia.add(eTotale, 0, 5, 2, 1);
		
		Scene scena= new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Sconto");
		finestra.show();
	}
	
	public void calcolaTotale() {
		int numeroPanini=Integer.parseInt(cNumeroPanini.getText());
		double prezzoUno=Double.parseDouble(cPrezzoPanino.getText());
		double totale=prezzoUno*numeroPanini;
		if(checkSconto.isSelected()) {
			double sconto=Double.parseDouble(cSconto.getText());//leggiamo la casella di testo qui perchè vogliamo evitare l'errore della casella vuota
			double valoreSconto=sconto*totale/100;
			totale=totale-valoreSconto;
		}
		eTotale.setText(""+totale);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

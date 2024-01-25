package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgenziaViaggi extends Application{
	
	TextField cPersoneAutobus= new TextField();
	TextField cPartecipanti= new TextField();
	TextField cCostoAutobus= new TextField();
	
	Button bCalcola=new Button("calcola biglietto");
	
	Label eRisultato= new Label();
	
	public void start(Stage finestra) {
		Label ePersoneAutobus=new Label("persona per autobus");
		Label ePartecipanti=new Label("numero partecipanti");
		Label eCostoAutobus=new Label("costo di un autobus");
		Label eCostoBiglietto=new Label("costo biglietto");
		
		GridPane griglia=new GridPane();
		
		griglia.add(ePersoneAutobus, 0, 0);
		griglia.add(ePartecipanti, 0, 1);
		griglia.add(eCostoAutobus, 0, 2);
		griglia.add(bCalcola, 0, 3, 2, 1);
		griglia.add(eCostoBiglietto, 0, 4);
		
		bCalcola.setMaxWidth(500);
		
		griglia.add(cPersoneAutobus, 1, 0);
		griglia.add(cPartecipanti, 1, 1);
		griglia.add(cCostoAutobus, 1, 2);
		griglia.add(eRisultato, 1, 4);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		bCalcola.setOnAction(e->Caclola());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Agenzia Viaggi");
		finestra.show();
	}
	
	public void Caclola() {
		int persAuto=Integer.parseInt(cPersoneAutobus.getText());
		int partecipanti=Integer.parseInt(cPartecipanti.getText());
		double costoAuto=Double.parseDouble(cCostoAutobus.getText());
		double costoBiglietto;
		
		int nAutobus=partecipanti/persAuto;
		if(partecipanti%persAuto!=0) {
			nAutobus=nAutobus+1;
		}
		double prezzo=nAutobus*costoAuto;
		costoBiglietto=prezzo/partecipanti;
		eRisultato.setText(""+costoBiglietto);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BellucciMicheleRistorante extends Application{
	
	TextField cNumHamurger = new TextField();
	TextField cPrezzHamburger = new TextField();
	TextField cNumPatatine = new TextField();
	TextField cPrezzPatatine = new TextField();
	
	CheckBox checkSalse= new CheckBox("salse + 0,2€");
	CheckBox checkSconto= new CheckBox("sconto 10%");
		
	Label eScriviTotale= new Label("??");
	
	public void start(Stage finestra) {
		Label eNumHam= new Label("Numero Hamburger:");
		eNumHam.getStyleClass().add("fontQuantita");
		Label ePrezzHam= new Label("Prezzo Hamburger:");
		Label eNumPata= new Label("Numero Patatine:");
		eNumPata.getStyleClass().add("fontQuantita");
		Label ePrezzPata= new Label("Prezzo Patatine:");
		Label eTotale= new Label("Totale:");
		
		
		Button bCalcolaPrezzo=new Button("Calcola Prezzo");
		
		GridPane griglia=new GridPane();
		
		griglia.setId("griglia");
		
		griglia.add(eNumHam, 0, 0);
		griglia.add(ePrezzHam, 1, 0);
		griglia.add(cNumHamurger, 0, 1);
		griglia.add(cPrezzHamburger, 1, 1);
		griglia.add(eNumPata, 0, 2);
		griglia.add(ePrezzPata, 1, 2);
		griglia.add(cNumPatatine, 0, 3);
		griglia.add(cPrezzPatatine, 1, 3);
		griglia.add(checkSalse, 0, 4);
		griglia.add(checkSconto, 1, 4);
		griglia.add(bCalcolaPrezzo, 0, 5, 2, 1);
		griglia.add(eTotale, 0, 6);
		griglia.add(eScriviTotale, 1, 6);
		
		bCalcolaPrezzo.setOnAction(e -> calcola());
		
		bCalcolaPrezzo.setMaxWidth(400);
		
		Scene scena=new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/verifica/BellucciMichele.css");
		
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	
	public void calcola(){
		int numHambu=Integer.parseInt(cNumHamurger.getText());
		double preHambu=Double.parseDouble(cPrezzHamburger.getText());
		int numPatate=Integer.parseInt(cNumPatatine.getText());
		double prePatate=Double.parseDouble(cPrezzPatatine.getText());
		
		double totHamb=0.0;
		totHamb=numHambu*preHambu;
		double totPatate=0.0;
		double totSalse=0.0;
		double totale=0.0;
		if (checkSalse.isSelected()) {
			totSalse=numPatate*0.2;
		}
		totPatate=numPatate*prePatate+totSalse;
		totale=totPatate+totHamb;
		if(checkSconto.isSelected()) {
			totale=totale-(totale/100*10);
		}
		eScriviTotale.setText(""+totale);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

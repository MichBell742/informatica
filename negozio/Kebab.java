package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Kebab extends Application{
	final double PREZZO_CARNE = 4.00;
	final double PREZZO_FORMAGGIO = 1.00;
	final double PREZZO_POMODORO = 1.00;
	final double PREZZO_SALSA = 0.50;
	final double PREZZO_CIPOLLA = 0.50;
	
	CheckBox checkCarne= new CheckBox("Carne ["+PREZZO_CARNE+"€]");
	CheckBox checkFormaggio= new CheckBox("Formaggio ["+PREZZO_FORMAGGIO+"€]");
	CheckBox checkPomodoro= new CheckBox("Pomodoro ["+PREZZO_POMODORO+"€]");
	CheckBox checkSalsa= new CheckBox("Salsa ["+PREZZO_SALSA+"€]");
	CheckBox checkCipolla= new CheckBox("Cipolla ["+PREZZO_CIPOLLA+"€]");
	
	Label ePrezzo=new Label();
	
	Slider numeroPanini=new Slider(0,10,5);
	
	public void start(Stage finestra) {
		Button bTotale=new Button("Totale:");
		
		GridPane griglia=new GridPane();
		
		
		numeroPanini.setShowTickMarks(true);
		numeroPanini.setShowTickLabels(true);
		numeroPanini.setMajorTickUnit(1);
        numeroPanini.setMinorTickCount(0);
        numeroPanini.setSnapToTicks(true);
		
		griglia.add(numeroPanini, 0, 0, 2, 1);
		griglia.add(checkCarne, 0, 1);
		griglia.add(checkFormaggio, 0, 2);
		griglia.add(checkPomodoro, 0, 3);
		griglia.add(checkSalsa, 0, 4);
		griglia.add(checkCipolla, 0, 5);
		griglia.add(bTotale, 0, 6);
		griglia.add(ePrezzo, 1, 6);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);

		ePrezzo.setPrefWidth(25);
		ePrezzo.setAlignment(Pos.CENTER_LEFT);
		
		bTotale.setOnAction(e -> totale());
		
		Scene scena = new Scene(griglia);
		
		finestra.setScene(scena);		
		finestra.setTitle("Kebab");
		finestra.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	public void totale() {
		double dPrezzo=0;
		double iPanini=numeroPanini.getValue();
		
		if(checkCarne.isSelected()) {
			dPrezzo=dPrezzo+PREZZO_CARNE;
		}
		if(checkFormaggio.isSelected()) {
			dPrezzo=dPrezzo+PREZZO_FORMAGGIO;
		}
		if(checkSalsa.isSelected()) {
			dPrezzo=dPrezzo+PREZZO_SALSA;
		}
		if(checkPomodoro.isSelected()) {
			dPrezzo=dPrezzo+PREZZO_POMODORO;
		}
		if(checkCipolla.isSelected()) {
			dPrezzo=dPrezzo+PREZZO_CIPOLLA;
		}
		dPrezzo=dPrezzo*iPanini;
		ePrezzo.setText(""+dPrezzo);
	}
}

package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Stile extends Application{
	TextField cBase=new TextField();
	TextField cAltezza=new TextField();
	Label ePerimetro=new Label("perimaetro");
	Label eArea=new Label("area");
	public void start(Stage finestra) {
		Label eBase=new Label("base");
		Label eAltezza=new Label("altezza");
		
		ePerimetro.getStyleClass().add("perimetro");
		
		GridPane griglia=new GridPane();
		griglia.getStyleClass().add("griglia");
		
		griglia.add(eBase, 0, 0);
		griglia.add(cBase, 1, 0);
		griglia.add(eAltezza, 0, 1);
		griglia.add(cAltezza, 1, 1);
		griglia.add(eArea, 0, 2);
		griglia.add(ePerimetro, 1, 2);
		
		griglia.setPadding(new Insets(10,10,10,10));

		cAltezza.setOnAction(e->calcola());
		cBase.setOnAction(e->calcola());
		
		eArea.setPrefWidth(175);
		ePerimetro.setPrefWidth(175);
		
		Scene scena=new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/prove/Stile.css");
		finestra.setScene(scena);
		finestra.setTitle("Foglio di stile quadrato/rettangolo");
		finestra.show();
	}
	public void calcola(){
		if(!cAltezza.getText().equals("") && !cBase.getText().equals("")) {
			double base=Double.parseDouble(cBase.getText());
			double altezza=Double.parseDouble(cAltezza.getText());
			double area=base*altezza;
			double perimetro=(base+altezza)*2;
			eArea.setText(""+area);
			ePerimetro.setText(""+perimetro);
		}else {
			eArea.setText("inserisci un valore nelle caselle");
			ePerimetro.setText("inserisci un valore nelle caselle");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}

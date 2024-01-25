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

public class Rettangolo extends Application{
	

	Label eArea= new Label();
	Label ePerimetro= new Label();
	TextField cBase= new TextField();
	TextField cAltezza= new TextField();
	
	public void start(Stage finestra) {
			
		Label eBase= new Label();
		Label eAltezza= new Label();
		Button bCalcola=new Button();
		
		GridPane griglia=new GridPane();
		
		griglia.add(eBase, 0, 0);
		griglia.add(cBase, 1, 0);
		griglia.add(eAltezza, 0, 1);
		griglia.add(cAltezza, 1, 1);
		griglia.add(bCalcola, 0, 2, 2, 1);
		griglia.add(eArea, 0, 3);
		griglia.add(ePerimetro, 1, 3);
		
		eBase.setText("base:");
		eAltezza.setText("altezza:");
		bCalcola.setText("Calcola A. e P.");
		cBase.setPromptText("inserisci la base");
		cAltezza.setPromptText("inserisci l'altezza");
		
		
		
		bCalcola.setOnAction(e -> calcola());
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		
		griglia.setAlignment(Pos.CENTER);
		
		bCalcola.setPrefWidth(300);
		eArea.setPrefWidth(145);
		ePerimetro.setPrefWidth(145);
		eBase.setPrefWidth(145);
		eAltezza.setPrefWidth(145);
	
		eArea.setAlignment(Pos.CENTER);
		ePerimetro.setAlignment(Pos.CENTER);
		
		Scene scena=new Scene(griglia,300,150);
		finestra.setScene(scena);
		finestra.setTitle("Rettangolo");
		finestra.show();
	}
	
	public void calcola() {
		double base= Double.parseDouble(cBase.getText());
		double altezza= Double.parseDouble(cAltezza.getText());
		
		double area=base*altezza;
		double perimetro=(base+altezza)*2;
		
		eArea.setText("Area= "+area);
		ePerimetro.setText("Preimetro= "+perimetro);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

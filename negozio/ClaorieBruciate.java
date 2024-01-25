package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClaorieBruciate extends Application{
	TextField cKM=new TextField();
	Label eRisultatoCal=new Label();
	RadioButton nuoto=new RadioButton("nuoto");
	RadioButton corsa=new RadioButton("corsa");
	RadioButton bici=new RadioButton("bici");
	CheckBox cavigliere=new CheckBox("cavigliere");
	CheckBox bracciali=new CheckBox("bracciali");
	public void start(Stage finestra) {
		Label eKM=new Label("KM");
		Label eSport=new Label("Sport:");
		Label eCalorie= new Label("Calorie");
		Label eGadget= new Label("Aggiunte");
		Button bCalcola= new Button("calcola");
		GridPane griglia=new GridPane();
		
		ToggleGroup sport = new ToggleGroup();
		corsa.setToggleGroup(sport);
		nuoto.setToggleGroup(sport);
		bici.setToggleGroup(sport);
		
		griglia.add(eKM, 0,0);
		griglia.add(cKM, 1,0);
		griglia.add(eSport, 0,1);
		griglia.add(nuoto, 0, 2);
		griglia.add(corsa, 0, 3);
		griglia.add(bici, 0, 4);
		griglia.add(eGadget, 0, 5);
		griglia.add(bracciali, 0, 6);
		griglia.add(cavigliere, 0, 7);
		griglia.add(bCalcola, 1, 2, 1, 6);
		griglia.add(eCalorie, 0, 8);
		griglia.add(eRisultatoCal, 1, 8);
		
		bCalcola.setMaxHeight(500);
		bCalcola.setMaxWidth(200);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		bCalcola.setOnAction(e -> calcola());
		
		Scene scena=new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/negozio/Stile.css");
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	public void calcola() {
		double km=Double.parseDouble(cKM.getText());
		double risultato;
		if(corsa.isSelected()) {
			risultato=km*12;
		}else if(nuoto.isSelected()) {
			risultato=km*21;
		}else {
			risultato=km*7;
		}
		
		if(cavigliere.isSelected()) {
			risultato=risultato*1.35;
		}
		if(bracciali.isSelected()) {
			risultato=risultato*1.18;
		}
		
		eRisultatoCal.setText(""+risultato);
	}
	public static void main(String[] args) {
		launch(args);
	}
}

package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BellucciMicheleNumeri extends Application{
	TextField cPrimNumero=new TextField();
	TextField cSecondNumero=new TextField();
	Label eRisultato=new Label("risultato");
	public void start(Stage finestra) {
		Label ePrimNum=new Label("primo numero:");
		Label eSecondNum=new Label("secondo numero:");
		Button bCalcola=new Button("calcola");
		
		
		GridPane griglia=new GridPane();
		
		griglia.add(ePrimNum, 0, 0);
		griglia.add(cPrimNumero, 1, 0);
		griglia.add(eSecondNum, 0, 1);
		griglia.add(cSecondNumero, 1, 1);
		griglia.add(bCalcola, 0, 2);
		griglia.add(eRisultato, 1, 2);
		
		bCalcola.setOnAction(e->calcola());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	public void calcola() {
		int primoNum=Integer.parseInt(cPrimNumero.getText());
		int secondoNum=Integer.parseInt(cSecondNumero.getText());
		int numPiuGrande=0;
		System.out.println("ci sono");
		if(primoNum>secondoNum) {
			numPiuGrande=primoNum;
		}else {
			numPiuGrande=secondoNum;
		}
		int numMax=primoNum*secondoNum;
		boolean arrivato=false;
		for(int i=numPiuGrande;i<=numMax && arrivato==false ;i++) {
			if(i%primoNum==0 && i%secondoNum==0) {
				arrivato=true;
				eRisultato.setText(""+i);
			}
			System.out.println(""+i);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

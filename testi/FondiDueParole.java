package it.edu.iisgubbo.verifiche.secondaVerifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FondiDueParole extends Application{
	
	TextField cPrimaParola= new TextField();
	TextField cSecondaParola= new TextField();
	Label unioneFinale= new Label();
	
	public void start(Stage finestra){
		
		Label ePrimaParola= new Label("prima Parola");
		Label eSecondaParola= new Label("seconda Parola");
		Button bUnisci= new Button("unisci");
		
		GridPane griglia=new GridPane();

		griglia.add(ePrimaParola, 0, 0);
		griglia.add(cPrimaParola, 1, 0);
		griglia.add(eSecondaParola, 0, 1);
		griglia.add(cSecondaParola, 1, 1);
		griglia.add(bUnisci, 0, 2, 2, 1);
		griglia.add(unioneFinale, 0, 3);
		
		bUnisci.setMaxWidth(500);
		
		bUnisci.setOnAction(e->unisci());
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("fondi parole");
		finestra.show();
	}
	
	public void unisci() {
		char primaParola[]= cPrimaParola.getText().toCharArray();
		char secondaParola[]= cSecondaParola.getText().toCharArray();
		String parolaFinale="";
		String letterePassate="";
		int contaRipetizioni=0;
		char lettera;
		for(int i=0; i<primaParola.length; i++) {
			lettera=primaParola[i];
			if(letterePassate.indexOf(lettera)==-1) {
				letterePassate+=lettera;
				for(int iUno=i; iUno<primaParola.length; iUno++) {
					if(lettera==primaParola[iUno]){
						contaRipetizioni++;
					}
				}
				for(int iDue=0; iDue<secondaParola.length; iDue++) {
					if(lettera==secondaParola[iDue]){
						contaRipetizioni++;
					}
				}
				while(contaRipetizioni>0) {
					parolaFinale+=lettera;
					contaRipetizioni--;
				}
			}
		}
		for(int iDue=0; iDue<secondaParola.length; iDue++) {
			if(letterePassate.indexOf(secondaParola[iDue])==-1) {
				letterePassate+=secondaParola[iDue];
				for(int itrova=0; itrova<secondaParola.length; itrova++) {
					if(secondaParola[iDue]==secondaParola[itrova]) {
						contaRipetizioni++;
					}
				}
				while(contaRipetizioni>0) {
					parolaFinale+=secondaParola[iDue];
					contaRipetizioni--;
				}
			}
			contaRipetizioni=0;
		}
		unioneFinale.setText(parolaFinale);
	}	
	public static void main(String[] args){
		launch(args);
	}
}

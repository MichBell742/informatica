package it.edu.iisgubbio.salutaUtente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SalutaUtente extends Application{
	
	Label lMessaggio = new Label();
	Label lInsNome = new Label();
	TextField tNome = new TextField();
	Button pEseguiSaluto = new Button();
	int ripMes=0;
	
	GridPane griglia = new GridPane();
	
	public void start(Stage finestra) {
		
		lInsNome.setText("Nome:");
		lMessaggio.setText("sono impazziente");
		tNome.setPromptText("inserisci il tuo nome...");
		pEseguiSaluto.setText("Premi qui");
		
		Scene scena = new Scene(griglia, 300, 250);
		
		griglia.add(lInsNome, 0, 0);
		griglia.add(lMessaggio, 1, 2);
		griglia.add(tNome, 1, 0);
		griglia.add(pEseguiSaluto, 1, 1);
		
		pEseguiSaluto.setOnAction(e -> Esegui());

		finestra.setTitle("Hello World!");
		finestra.setScene(scena);
		finestra.show();
	}
	
	public void Esegui() {
		String utente;
		utente=tNome.getText();
		if (ripMes==0) {
			lMessaggio.setText("Signor " + utente + " Le auguro buona giornata!");
			ripMes=1;
		}else if(ripMes==1) {
			lMessaggio.setText("Signor " + utente + " Ancora non se ne è andato?");
			ripMes=2;
		}else if(ripMes==2) {
			lMessaggio.setText("Signor " + utente + " Sono poco paziente, vattene.");
			ripMes=3;
		}else if(ripMes==3) {
			System. exit(0); 
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

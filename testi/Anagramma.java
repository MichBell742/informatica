package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Anagramma extends Application{
	TextField cParolaUno=new TextField();
	TextField cParolaDue=new TextField();
	Label risultato= new Label();
	
	public void start(Stage finestra){
		Label eParolaUno=new Label("parolaUno");
		Label eParolaDue=new Label("parolaDue");
		Label Anafora=new Label("Anafora?");
		
		Button analizza=new Button("analizza");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eParolaUno, 0, 0);
		griglia.add(cParolaUno, 1, 0);
		griglia.add(eParolaDue, 0, 1);
		griglia.add(cParolaDue, 1, 1);
		griglia.add(analizza, 0, 2);
		griglia.add(Anafora, 0, 3);
		griglia.add(risultato, 1, 3);
		
		analizza.setOnAction(e->controlla());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Anagramma");
		finestra.show();
	}
	
	public void controlla() {
		char[] parolaUno=cParolaUno.getText().toCharArray();
		char[] parolaDue=cParolaDue.getText().toCharArray();
		String posizioni="";
		boolean presente=true;
		
		for(int iUno=0; iUno<parolaUno.length && presente; iUno++) {
			if(presente) {
				presente=false;
			}
			for(int iDue=0; iDue<parolaUno.length && !presente; iDue++) {
				if(posizioni.indexOf(""+iDue)==-1) {
					System.out.println(parolaUno[iUno] +" "+ iUno + " | " +parolaDue[iDue]+" " + iDue);
					if(parolaUno[iUno]==parolaDue[iDue]) {
						presente=true;
						posizioni=posizioni+iDue;
					}
				}
			}
			System.out.println(presente);
		}
		System.out.println(presente);
		if(presente==false) {
			risultato.setText("No");
		}else {
			risultato.setText("Si");
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

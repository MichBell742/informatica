package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Indovina extends Application{
	
	TextField cNumero= new TextField();
	Label eIndizio= new Label();
	Button bUscire=new Button("USCIRE?");
	
	int numeroCasuale=(int)(Math.random()*100)+1;
	
	
	public void start(Stage finestra) {
		
		System.out.println(numeroCasuale);
		Label eNumero=new Label("Numero:");
		Button bProva=new Button("Prova");
		Button bRicomincia=new Button("Ricomincia");
		bProva.setOnAction(e->controlla());
		bRicomincia.setOnAction(e->ricomincia());
		bUscire.setOnAction(e->Esci());
		
		bUscire.setDisable(true);
		
		GridPane griglia=new GridPane();
		
		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(bProva, 0, 1, 2, 1);
		griglia.add(bRicomincia, 0, 2, 2, 1);
		griglia.add(bUscire, 0, 3, 2, 1);
		griglia.add(eIndizio, 0, 4, 2, 1);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		bProva.setMaxWidth(300);
		bRicomincia.setMaxWidth(300);
		bUscire.setMaxWidth(300);
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("indovina");
		finestra.show();
	}
	
	public void controlla() {
		int numero=Integer.parseInt(cNumero.getText());
		cNumero.setText("");
		if(numeroCasuale>numero) {
			eIndizio.setText("troppo basso");
		}else if(numeroCasuale<numero) {
			eIndizio.setText("troppo alto");
		}else {
			eIndizio.setText("giusto uil numero era "+numeroCasuale);
			uscire();
		}
	}
	public void Esci() {
		System.exit(0);
	}
	public void uscire() {
		bUscire.setDisable(false);
	}
	public void ricomincia() {
		bUscire.setDisable(true);
		numeroCasuale=(int)(Math.random()*100)+1;
		System.out.println(numeroCasuale);
		eIndizio.setText("il numero è satato modificato");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

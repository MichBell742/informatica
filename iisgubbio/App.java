package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{
	
	TextField tPersona= new TextField();
	TextField tMonete= new TextField();
	TextField tMotivazioe= new TextField();
	
	Label eMoneteAttuali= new Label("x");

    RadioButton rbRimuovi = new RadioButton("rimuovi");
    RadioButton rbAggiungi = new RadioButton("aggiungi");
    RadioButton rbCerca = new RadioButton("cerca");
	
    ListView<String> riassumo= new ListView<String>();
    
	public void start(Stage finestra) {
		GridPane griglia= new GridPane();
		
		griglia.setPadding(new Insets(10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		tPersona.setPromptText("nome");
		tMonete.setPromptText("monete");
		tMotivazioe.setPromptText("motivazione");
		
		Label eMonete= new Label("monete attuali:");
		
		Button bSalva= new Button("salva");
		
		ToggleGroup azione= new ToggleGroup();
		rbRimuovi.setToggleGroup(azione);
		rbAggiungi.setToggleGroup(azione);
		rbCerca.setToggleGroup(azione);
		
		rbCerca.setSelected(true);
		
		griglia.add(tPersona, 0, 0);
		griglia.add(tMonete, 1, 0);
		griglia.add(eMonete, 0, 1);
		griglia.add(eMoneteAttuali, 0, 2);
		griglia.add(rbRimuovi, 1, 1);
		griglia.add(rbAggiungi, 1, 2);
		griglia.add(rbCerca, 1, 3);
		griglia.add(tMotivazioe, 0, 3, 1, 2);
		griglia.add(bSalva, 1, 4);
		griglia.add(riassumo, 0, 5, 2, 1);
		riassumo.setMaxHeight(200);
		tMotivazioe.setMaxHeight(100);
		
		bSalva.setOnAction(this::salva);
		
		Scene scene= new Scene(griglia);
		finestra.setScene(scene);
		finestra.setTitle("traccia monete");
		finestra.show();
	}
	
	public void salva(ActionEvent evento) {
		String nome="";
		int monete =0;
		String motivazione="";
		riassumo.getItems().clear();
		try{
			nome = tPersona.getText();
			monete = Integer.parseInt(tMonete.getText());
			motivazione = tMotivazioe.getText(); 
		}catch(NumberFormatException e){
			System.out.println("errore caselle vuote");
		}
		try(
				FileReader file= new FileReader("/home/bellucci/Documenti/Workspace/School/src/it/edu/iisgubbio/ripasso/dati.csv");
				BufferedReader lettore= new BufferedReader(file);
				){
			String riga="";
			String[] valori=null;
			
			if(rbRimuovi.isSelected()) {
				scriviValore(nome, true, monete,motivazione);
			}else if(rbAggiungi.isSelected()){
				scriviValore(nome, false, monete,motivazione);
			}
			int valoreAttuale=0;
			while((riga=lettore.readLine())!=null) {
				valori=riga.split(",");
				if(nome.toLowerCase().equals(valori[0])) {
					valoreAttuale+=Integer.parseInt(valori[1]);
					try {
						riassumo.getItems().add(valori[2]+", comporta "+valori[1]);
					} catch( ArrayIndexOutOfBoundsException e) {
						riassumo.getItems().add("---");
					}
				}
			}
			eMoneteAttuali.setText(""+valoreAttuale);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void scriviValore(String nome, boolean rimuovi, int valore, String motivazione) {
		try(
				FileWriter file = new FileWriter("/home/bellucci/Documenti/Workspace/School/src/it/edu/iisgubbio/ripasso/dati.csv",true);
				){
			if(rimuovi) {
				file.write(nome.toLowerCase()+",-"+valore+","+motivazione+"\n");
			}else {
				file.write(nome.toLowerCase()+","+valore+","+motivazione+"\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

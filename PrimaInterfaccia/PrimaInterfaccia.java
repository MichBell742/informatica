package it.edu.iisgubbio.PrimaInterfaccia;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrimaInterfaccia extends Application{
	
	TextField tUnisciSx = new TextField();
	TextField tUnisciDx = new TextField();
	
	Button pCopiaSx= new Button();
	Button pCopiaDx= new Button();
	Button pUnisci= new Button();
	Button pPulisci= new Button();
	
	Label eCopiaSx= new Label();
	Label eCopiaDx= new Label();
	Label eUnisci= new Label();
	
	GridPane griglia=new GridPane();
	
	public void start(Stage finestra){
		
		pCopiaSx.setText("copia");
		pCopiaDx.setText("copia");
		pUnisci.setText("unisci");
		pPulisci.setText("pulisci");
		
		tUnisciSx.setPromptText("Scrivi una parola");
		tUnisciDx.setPromptText("Scrivi una parola");
		
		eCopiaSx.setText("");
		eCopiaDx.setText("");
		eUnisci.setText("");
		
		griglia.add(tUnisciSx, 0, 0);
		griglia.add(pUnisci, 1, 0);
		griglia.add(tUnisciDx, 2, 0);
		
		griglia.add(pCopiaSx, 0, 1);
		griglia.add(eUnisci, 1, 1);
		griglia.add(pCopiaDx, 2, 1);
		
		griglia.add(eCopiaSx, 0, 2);
		griglia.add(pPulisci, 1, 2);
		griglia.add(eCopiaDx, 2, 2);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(20);
		
		pCopiaDx.setPrefWidth(200);
		pCopiaSx.setPrefWidth(200);
		pPulisci.setPrefWidth(200);
		pUnisci.setPrefWidth(200);
		
		ColumnConstraints vincoloPrimaColonna= new ColumnConstraints();
		vincoloPrimaColonna.setHalignment(HPos.CENTER);
		griglia.getColumnConstraints().addAll(vincoloPrimaColonna);

		
		
		pCopiaSx.setOnAction( e -> copiaSx());
		pCopiaDx.setOnAction( e -> copiaDx());
		pUnisci.setOnAction( e -> unisci());
		pPulisci.setOnAction( e -> pulisci());
		
		Scene scena=new Scene(griglia);
		
		finestra.setScene(scena);
		finestra.setTitle("Prima Interfaccia");
		finestra.show();
		
	}
	
	public void copiaSx() {
		String valore=tUnisciSx.getText();
		eCopiaSx.setText(valore);
	}
	
	public void copiaDx() {
		String valore=tUnisciDx.getText();
		eCopiaDx.setText(valore);
	}
	
	public void unisci() {
		String valore1=tUnisciSx.getText();
		String valore2=tUnisciDx.getText();

		eUnisci.setText(valore1+valore2);
	}
	
	public void pulisci() {
		tUnisciDx.setText("");
		tUnisciSx.setText("");
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

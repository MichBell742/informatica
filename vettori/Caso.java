package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Caso extends Application{
	Label eVettore= new Label("");
	Label eNumPari= new Label("");
	Label eSomma= new Label("");
	Label eSommaMultipli= new Label("");
	Label eMinimo= new Label("");
	TextField tNumElementi=new TextField();
	TextField tNumMin=new TextField();
	TextField tNumMax=new TextField();
	
	int vettoreNumeri[];
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label eElementi= new Label("Elementi");
		Label eNumeroMinimo= new Label("Min");
		Label eNumeroMassimo= new Label("Max");
		Button bGenera= new Button("genera");
		Button bStampa= new Button("stampa");
		Button bPari= new Button("pari");
		Button bSomma= new Button("somma");
		Button b2e3= new Button("2e3");
		Button minimo= new Button("trova minimo");
		
		griglia.add(eElementi,0,0);
		griglia.add(eNumeroMinimo,0,1);
		griglia.add(eNumeroMassimo,0,2);
		griglia.add(tNumElementi,1,0);
		griglia.add(tNumMin,1,1);
		griglia.add(tNumMax,1,2);
		griglia.add(bGenera,0,3);
		griglia.add(bStampa,1,3);
		griglia.add(eVettore,0,4,2,1);
		griglia.add(bPari,0,5);
		griglia.add(eNumPari,1,5);
		griglia.add(bSomma,0,6);
		griglia.add(eSomma,1,6);
		griglia.add(b2e3,0,7);
		griglia.add(eSommaMultipli,1,7);
		griglia.add(minimo,0,8);
		griglia.add(eMinimo,1,8);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		bGenera.setOnAction(e->generaVettore());
		bStampa.setOnAction(e->scriviVettore());
		bPari.setOnAction(e->contaPari());
		bSomma.setOnAction(e->faiSomma());
		b2e3.setOnAction(e->faiSomma2e3());
		minimo.setOnAction(e->trovaMinimo());
		
		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("caso");
		finestra.show();
	}
	
	public void generaVettore(){
		int quantitaNumeri=Integer.parseInt(tNumElementi.getText());
		int valMin=Integer.parseInt(tNumMin.getText());
		int valMax=Integer.parseInt(tNumMax.getText());
		vettoreNumeri=new int[quantitaNumeri];
		for(int i=0; i<quantitaNumeri; i++){
			vettoreNumeri[i]=(int)(Math.random()*(valMax-valMin+1))+valMin;
		}
	}
	public void trovaMinimo() {
		int piuPiccolo=Integer.parseInt(tNumMax.getText());
		int controlla=0;
		for(int i=0; i<vettoreNumeri.length; i++){
			controlla=vettoreNumeri[i];
			if(piuPiccolo>controlla) {
				piuPiccolo=controlla;
			}
		}
		eMinimo.setText(""+piuPiccolo);
	}
	public void scriviVettore() {
		String vettore = "";
		for(int i=0; i<vettoreNumeri.length; i++) {
			if(vettore.equals("")) {
				vettore += ""+vettoreNumeri[i];
			}else {
				vettore += ", "+vettoreNumeri[i];
			}	
		}
		eVettore.setText(vettore);
	}
	public void contaPari() {
		int contaPari=0;
		for(int i=0; i<vettoreNumeri.length; i++) {
			if(vettoreNumeri[i] % 2==0) {
				contaPari++;
			}
		}
		eNumPari.setText(""+contaPari);
	}
	public void faiSomma() {
		int somma=0;
		for(int i=0; i<vettoreNumeri.length; i++) {
			somma+=vettoreNumeri[i];
		}
		eSomma.setText(""+somma);
	}
	public void faiSomma2e3() {
		int SommaMultipli=0;
		for(int i=0; i<vettoreNumeri.length; i++) {
			if(vettoreNumeri[i] % 2==0 && vettoreNumeri[i] % 3==0) {
				SommaMultipli+=vettoreNumeri[i];
			}
		}
		eSommaMultipli.setText(""+SommaMultipli);
	}
	public static void main(String[] args) {
		launch(args);
	}
}

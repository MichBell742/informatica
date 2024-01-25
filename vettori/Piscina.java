package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Piscina extends Application {
		Label eNumero=new Label("Numero dei tempi");
		TextField tNumero = new TextField();
	   Label eTempo=new Label("Inserisci i tempi");
	   TextField tTempo = new TextField();
	   Label eValoreMassimo=new Label("inserisci il valore massimo");
	   TextField tCoach = new TextField();
	   Label eRisultati = new Label();
	   Button contPess=new Button("controlla i peggiori");
	   Button bElenca=new Button("Elenca");
	   Label eElenca=new Label("");
	   int tempi[];
	   int pos;

	   @Override
	   public void start(Stage primaryStage) {
		   GridPane griglia= new GridPane();

		   griglia.add(eNumero, 0, 0);
		   griglia.add(tNumero, 0, 1);
		   griglia.add(eTempo, 0, 2);
		   griglia.add(tTempo, 0, 3);
		   griglia.add(eValoreMassimo, 0, 4);
		   griglia.add(tCoach, 0, 5);
		   griglia.add(eRisultati, 0, 7);
		   griglia.add(contPess, 0, 6);
		   griglia.add(bElenca, 0, 8);
		   griglia.add(eElenca, 0, 9);
		   
		   tNumero.setOnAction(e->alloca());
		   tTempo.setOnAction(e->inserisciTempo());
		   contPess.setOnAction(e->contaPessimi());
		   bElenca.setOnAction(e->elenca());
		   
		   griglia.setPadding(new Insets(10, 10, 10, 10 ));
		   griglia.setHgap(10);
		   griglia.setVgap(10);
		   
		   Scene scena= new Scene(griglia);
		   primaryStage.setScene(scena);
		   primaryStage.setTitle("Piscina");
		   primaryStage.show();;
	   }

	   public void alloca() {
	      tempi = new int[Integer.parseInt(tNumero.getText())];
	      pos = 0;
	   }

	   public void inserisciTempo() {
	      if(pos < tempi.length) {
	         tempi[pos++]=Integer.parseInt(tTempo.getText());
	         tTempo.setText("");
	      }else {
	    	  eRisultati.setText("hai raggiunto il numero dei tempi");
	      }
	   }

	   public void contaPessimi() {
	      int indice, contatore;
	      int coach = Integer.parseInt(tCoach.getText());
	      for(contatore = indice = 0; indice < tempi.length; indice++) {
	         if(tempi[indice] > coach) {
	            contatore++;
	         }
	      }
	      eRisultati.setText("" + contatore);
	   }
	   
	   public void elenca() {
		   String str= "";
		   for(int i=0; i<tempi.length; i++) {
			   if(i==0) {
				   str=""+tempi[i];
			   }else {
				   str=str+", "+tempi[i]; 
			   }
		   }
		   eElenca.setText(str);
	   }
	   public static void main(String[] args) {
		   launch(args);
	   }
	}

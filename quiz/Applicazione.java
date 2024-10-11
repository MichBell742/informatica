package it.edu.iisgubbio.quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.edu.iisgubbio.file.Comune;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Applicazione extends Application{
	Label lNDomanda= new Label("0");
	Label lNDomandaGiusta= new Label("0");
	Label lTestoDomanda= new Label("???????????"); 
	Label lTestoRisposta= new Label("--------------"); 

	String destinazione="/Users/bellucci/Desktop/test.csv";
	ArrayList<Domanda> contenutoFile=new ArrayList<Domanda>();

	RadioButton rbRisp1= new RadioButton("risp1");
	RadioButton rbRisp2= new RadioButton("risp2");
	RadioButton rbRisp3= new RadioButton("risp2");

	int nDomandaAttuale=0;
	ToggleGroup gruppo= new ToggleGroup();
	
	@Override
	public void start(Stage finestra){
		Label lDomanda= new Label("domanda n. "); 
		Button bAvanti= new Button("avanti");
		Button bControlla= new Button("controlla");



		rbRisp1.setToggleGroup(gruppo);
		rbRisp2.setToggleGroup(gruppo);
		rbRisp3.setToggleGroup(gruppo);

		GridPane griglia= new GridPane();
		griglia.add(lDomanda, 0, 0);
		griglia.add(lNDomanda, 1, 0);
		griglia.add(lNDomandaGiusta, 2, 0);
		griglia.add(bAvanti, 3, 0);
		griglia.add(lTestoDomanda, 0, 1, 4, 1);
		griglia.add(rbRisp1, 0, 2);
		griglia.add(rbRisp2, 0, 3);
		griglia.add(rbRisp3, 0, 4);
		griglia.add(bControlla, 0, 5);
		griglia.add(lTestoRisposta, 1, 5, 3, 1);

		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);

		try(
				FileReader file= new FileReader(destinazione);
				BufferedReader lettore= new BufferedReader(file);
				){
			String riga="";
			while((riga=lettore.readLine())!=null) {
				contenutoFile.add(new Domanda(riga));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		inserisciDomanda(nDomandaAttuale);
		
		bControlla.setOnAction(e->controlla());

		Scene scena= new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("quiz");
		finestra.show();
	}

	public void inserisciDomanda(int indice) {
		lTestoDomanda.setText(contenutoFile.get(indice).getDomanda());

		lNDomanda.setText((nDomandaAttuale+1)+"");
		
		String[] risposte=contenutoFile.get(indice).getRisposte();
		rbRisp1.setText(risposte[0]);
		rbRisp2.setText(risposte[1]);
		rbRisp3.setText(risposte[2]);
	}

	public void controlla(){
		System.out.println(gruppo.getSelectedToggle());
		
		String risposta;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rombo extends Application{
	
	TextField cDiagonaleMaggiore = new TextField();
	TextField cDiagonaleMinore = new TextField();
	Label eAria= new Label();
	Label ePerimetro=new Label();
	
	
	public void start(Stage finestra) {
		
		Label eDiagonaleM= new Label("Diagonale maggiore");
		Label eDiagonalem= new Label("Diagonale minore");
		Button bCalcola= new Button("Calcola A.");
		
		cDiagonaleMinore.setPromptText("Scrivi il Diagonale minore");
		cDiagonaleMaggiore.setPromptText("Scrivi il Diagonale maggiore");
		
		bCalcola.setOnAction(e -> calcola());
		
		GridPane griglia=new GridPane();
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		bCalcola.setMaxWidth(300);
		
		griglia.add(eDiagonaleM,0 ,0);
		griglia.add(cDiagonaleMaggiore,1 ,0);
		griglia.add(eDiagonalem,0 ,1);
		griglia.add(cDiagonaleMinore,1 ,1);
		griglia.add(bCalcola, 0, 2, 2, 1);
		griglia.add(eAria, 0 ,3);
		griglia.add(ePerimetro, 1 ,3);
		
		Scene scena=new Scene(griglia);
		
		finestra.setScene(scena);
		finestra.setTitle("Rombo");
		finestra.show();
	}
	
	public void calcola() {
		String dM=cDiagonaleMaggiore.getText();
		String dm=cDiagonaleMinore.getText();
		
		double diagonlaeMaggiore=Double.parseDouble(dM);
		double diagonaleMinore=Double.parseDouble(dm);
		System.out.println(diagonlaeMaggiore); //si stampa nella console il valore definito
		System.out.println(diagonaleMinore);
		double dArea=(diagonlaeMaggiore*diagonaleMinore)/2;
		
		
		eAria.setText(""+dArea);
		
		double catetoM=diagonlaeMaggiore/2;
		double catetom=diagonaleMinore/2;
		
		double dPerimetro=Math.sqrt(catetoM*catetoM+catetom*catetom)*4; //deve essere sempre un double
		ePerimetro.setText(""+dPerimetro);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

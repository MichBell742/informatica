package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//scaleno, isoscele, equilatero
public class Triangoli extends Application{
	
	TextField cLato1= new TextField();
	TextField cLato2= new TextField();
	TextField cLato3= new TextField();
	Label eTipoTriangolo= new Label();
	
	public void start(Stage finestra) {
		
		Button bTrova= new Button("trova tipo");
		
		GridPane griglia = new GridPane();
		
		griglia.add(cLato1, 0, 0);
		griglia.add(cLato2, 1, 0);
		griglia.add(cLato3, 2, 0);
		griglia.add(bTrova, 0, 1,3,1);
		griglia.add(eTipoTriangolo, 0, 2, 3, 1);
		
		bTrova.setMaxWidth(600);
		eTipoTriangolo.setMaxWidth(600);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		bTrova.setOnAction(e -> trovaTriangolo());
		
		Scene scena=new Scene(griglia);
		
		finestra.setScene(scena);
		finestra.setTitle("Triangoli");
		finestra.show();
	}
	
	public void trovaTriangolo() {
		double lato1=Double.parseDouble(cLato1.getText());
		double lato2=Double.parseDouble(cLato2.getText());
		double lato3=Double.parseDouble(cLato3.getText());
		
		double quadratoLato1=lato1*lato1;
		double quadratoLato2=lato2*lato2;
		double quadratoLato3=lato3*lato3;
		
		
		if(lato1+lato2>lato3 && lato3+lato2>lato1 && lato1+lato3>lato2) {
			if(quadratoLato1>quadratoLato2 && quadratoLato1>quadratoLato3) {
				if(quadratoLato1==quadratoLato2+quadratoLato3) {
					eTipoTriangolo.setText("triangolo rettangolo");
				}
			}else if(quadratoLato2>quadratoLato1 && quadratoLato2>quadratoLato3) {
				if(quadratoLato2==quadratoLato1+quadratoLato3) {
					eTipoTriangolo.setText("triangolo rettangolo");
				}
			}else if(quadratoLato3>quadratoLato1 && quadratoLato3>quadratoLato2) {
				if(quadratoLato3==quadratoLato2+quadratoLato1) {
					eTipoTriangolo.setText("triangolo rettangolo");
				}
			}else if(lato1==lato2 && lato1==lato3) {
				
				eTipoTriangolo.setText("triangolo equilatero");
				
			} else if(lato1==lato2 && lato2!=lato3 || lato1==lato3 && lato3!=lato2 || lato2==lato3 && lato3!=lato1){
				
				eTipoTriangolo.setText("triangolo isoscele");
				
			} else if(lato1!=lato2 && lato2!=lato3 && lato1!=lato3){
				
				eTipoTriangolo.setText("triangolo scaleno");
				
			} else {
				
				eTipoTriangolo.setText("e cosa è successo?");
				
			}
			
		}else {
			
			eTipoTriangolo.setText("Il triangolo è impossibile da risolvere");
			
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

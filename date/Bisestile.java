package it.edu.iisgubbio.date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Bisestile extends Application{
	TextField cAnno = new TextField();
	Label eBisestile= new Label();
	public void start(Stage finestra) {
		Label eAnno=new Label("Anno");
		Button bBisestile = new Button("bisestile?");
		
		GridPane griglia = new GridPane();
		
		bBisestile.setOnAction(e->bisestile());
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		
		griglia.add(eAnno,0,0);
		griglia.add(cAnno,1,0);
		griglia.add(bBisestile,0,1);
		griglia.add(eBisestile,1,1);
		
		Scene scena=new Scene(griglia);
		
		finestra.setScene(scena);
		finestra.setTitle("Bisestile?");
		finestra.show();
	}
	public void bisestile() {
		int anno= Integer.parseInt(cAnno.getText());
		if(anno%4==0 && anno%100==0 && anno%400==0) {
				eBisestile.setText("--Si");
		}else {
			eBisestile.setText("No");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

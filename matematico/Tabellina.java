package it.edu.iisgubbio.matematico;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tabellina extends Application{
	
	TextField cNum= new TextField();
	Label eTabellina= new Label();
	
	public void start(Stage finestra) {
		Label eNum= new Label("num");
		Button bTabellina= new Button("Tabellina");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eNum, 0, 0);
		griglia.add(cNum, 1, 0);
		griglia.add(bTabellina, 0, 1, 2, 1);
		griglia.add(eTabellina, 0, 2, 2, 1);
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		bTabellina.setMaxWidth(300);
		eTabellina.setMaxWidth(300);
		eNum.setPrefWidth(50);
		
		bTabellina.setOnAction(e -> tabellina());
		
		Scene scena=new Scene(griglia);		
		scena.getStylesheets().add("it/edu/iisgubbio/matematico/StileTabelline.css");
		finestra.setScene(scena);
		finestra.setTitle("Tabellina");
		finestra.show();
	}
	
	public void tabellina() {
		int num = Integer.parseInt(cNum.getText());
		String sTabellina="0";
		for(int n=1; n<=10; n++) {
			int val = num*n;
			sTabellina+=", "+val;
		}
		eTabellina.setText(sTabellina);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

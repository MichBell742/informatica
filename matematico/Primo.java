package it.edu.iisgubbio.matematico;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Primo extends Application{
	TextField cNumero= new TextField();
	Label eDivisori= new Label();
	public void start(Stage finestra) {
		Label eNum=new Label("numero");
		Button bTrovaDivisori = new Button("divisori");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eNum, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(bTrovaDivisori, 0, 1, 2, 1);
		griglia.add(eDivisori, 0, 2, 2, 1);
		
		bTrovaDivisori.setOnAction(e->divisori());
		
		Scene scena=new Scene(griglia);
		
		finestra.setScene(scena);
		finestra.setTitle("Divisori");
		finestra.show();
	}
	
	public void divisori() {
		int num= Integer.parseInt(cNumero.getText());
		int conta=0;
		for(int n=1; n<=num; n++) {
			if(num%n==0) {
				conta=conta+1;
			}
		}
		if(conta==2) {
			eDivisori.setText("è primo");
		}else {
			eDivisori.setText("non è primo");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


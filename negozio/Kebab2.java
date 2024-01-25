package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Kebab2 extends Application{
	ComboBox<String> carne= new ComboBox<>();
	ComboBox<String> contorno= new ComboBox<>();
	ComboBox<String> salse= new ComboBox<>();
    Label eTotale=new Label();
    
	public void start(Stage finestra) {
		
		Label eCarne=new Label("carne");
		Label eContorno=new Label("contorno");
		Label eSalse=new Label("salse");

		Label ePrezCarne=new Label("");
		Label ePrezContorno=new Label("");
		Label ePrezSalse=new Label("");
		
        Button bTot=new Button("totale");
		
        carne.getItems().add("pollo");
        carne.getItems().add("maiale");
        carne.getItems().add("vitello");
        carne.getItems().add("tofu");
        
        contorno.getItems().add("insalata");
        contorno.getItems().add("cipolla");
        contorno.getItems().add("pomodoro");
        contorno.getItems().add("carota");
        
        salse.getItems().add("mayonese");
        salse.getItems().add("piccante");
        salse.getItems().add("yougurt");
        salse.getItems().add("tzatziki");
        
        carne.getSelectionModel().select(0);
        contorno.getSelectionModel().select(0);
        salse.getSelectionModel().select(0);
        
        carne.setOnAction(e->ePrezCarne.setText(""+setPrezCarne()));
        contorno.setOnAction(e->ePrezContorno.setText(""+setPrezContorno()));
        salse.setOnAction(e->ePrezSalse.setText(""+setPrezSalse()));
        
		GridPane griglia=new GridPane();
        
		griglia.add(eCarne, 0, 0);
		griglia.add(carne, 0, 1);
		griglia.add(ePrezCarne, 1, 1);
		griglia.add(eContorno, 0, 2);
		griglia.add(contorno, 0, 3);
		griglia.add(ePrezContorno, 1, 3);
		griglia.add(eSalse, 0, 4);
		griglia.add(salse, 0, 5);
		griglia.add(ePrezSalse, 1, 5);
		griglia.add(bTot, 0, 6);
		griglia.add(eTotale, 0, 7);
		
		bTot.setOnAction(e->calcola());
		
		Scene scena=new Scene(griglia);
		//scena.getStylesheets().add(STYLESHEET_CASPIAN);
		finestra.setScene(scena);
		finestra.setTitle("Kebab2");

		finestra.show();
	}
	public double setPrezCarne(){
		String stringaCarne=carne.getValue();
		double prez=0;
		switch(stringaCarne) {
		case "pollo":
			prez+=3;
			break;
		case "maiale":
			prez+=2.5;
			break;			
		case "vitello":
			prez+=4;
			break;			
		default:
			prez+=3;
		}
		return(prez);
	}
	
	public double setPrezContorno(){
		String stringaContorno=contorno.getValue();
		double totale=0;
		switch(stringaContorno) {
		case "insalata":
			totale+=0.5;
			break;
		case "cipolla":
			totale+=0.5;
			break;			
		case "pomodoro":
			totale+=1;
			break;			
		default:
			totale+=1;
		}
		return(totale);
	}
	
	public double setPrezSalse(){
		String stringaSalse=salse.getValue();
		double totale=0;
		switch(stringaSalse) {
		case "mayonese":
			totale+=0.5;
			break;
		case "piccante":
			totale+=1;
			break;			
		case "yougurt":
			totale+=0.5;
			break;			
		default:
			totale+=0.5;
		}
		return(totale);
	}
	public void calcola() {
		double totale=1;
		totale=totale+setPrezCarne()+setPrezContorno()+setPrezSalse();
		eTotale.setText(""+totale);
	}
	public static void main(String[] args) {
		launch(args);
	}
}

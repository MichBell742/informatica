package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class trovaNelFile extends Application{
	TextField tParola=new TextField();
	Window fileChoser;
	ListView<String> lista=new ListView<String>();
	public void start(Stage finestra) {
		Label eTestoTrova= new Label("teasto da trovare");
		Button bCerca= new Button("Cerca");
		GridPane griglia= new GridPane();
		
		fileChoser=finestra;
		
		griglia.add(eTestoTrova,0,0);
		griglia.add(tParola,1,0);
		griglia.add(bCerca, 0, 1, 2, 1);
		griglia.add(lista, 0, 2, 2, 1);
		bCerca.setMaxWidth(400);
		lista.setPrefWidth(400);
		lista.setMaxHeight(150);
		
		Scene scena= new Scene(griglia);
		
		bCerca.setOnAction(e->cerca());
		
		
		finestra.setScene(scena);
		finestra.setTitle("cerca nel file");
		finestra.show();
	}
	public void cerca() {
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("seleziona cartella");

		lista.getItems().clear();
		File defaultDirectory = new File(System.getProperty("user.home"));
		chooser.setInitialDirectory(defaultDirectory);

		File selectedDirectory = chooser.showDialog(fileChoser);
		String parola= tParola.getText();
		String percorso= ""+selectedDirectory;
		System.out.println(percorso);
		File directory = new File(percorso);
        File[] filesList = directory.listFiles();
        //scorre tutto il vettore fileList
        for(File file : filesList) {
        	try(
        			FileReader fileLetto= new FileReader(file);
        			BufferedReader lettore= new BufferedReader(fileLetto);
        			){
        		String riga="";
        		while((riga=lettore.readLine())!=null) {
        			if(riga.indexOf("\\")!=-1) {
        				if(riga.indexOf(parola)!=-1) {
        					lista.getItems().add(""+file);
	        			}
        			}
        		}
        	} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	public static void main(String[] args){
		launch(args);
	}
}

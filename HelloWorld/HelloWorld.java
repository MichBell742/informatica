package it.edu.iisgubbio.HelloWorld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * La mia prima classe
 */
public class HelloWorld extends Application {

  Button pSaluto = new Button(); 
  int stato=0;

  public void start(Stage finestra) {
    pSaluto.setText("Saluta!");
    pSaluto.setOnAction(e -> esegui());

    BorderPane principale = new BorderPane();
    principale.setCenter(pSaluto);

    Scene scena = new Scene(principale, 300, 250);

    finestra.setTitle("Hello World!");
    finestra.setScene(scena);
    finestra.show();
  }

  private void esegui(){
	 if(stato==0) {
    	pSaluto.setText("Ciao Mondo!");
    	stato=1;
	 }else if(stato==1) {
	    pSaluto.setText("Saluta!");
	    stato=0;
	 }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

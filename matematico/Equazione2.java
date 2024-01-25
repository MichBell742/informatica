package it.edu.iisgubbio.matematico;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Equazione2 extends Application{
	
	TextField cAXSeconda=new TextField();
	TextField cBXSeconda=new TextField();
	TextField cCXSeconda=new TextField();
	
	Label eRisultato= new Label();
	
	public void start(Stage finestra) {
		
		Label eIncognitaA= new Label("X2+");
		Label eIncognitaB= new Label("X+");
		Label eIncognitaC= new Label("=0");

		Button bCalcolaSoluzione = new Button("Calcola soluzione");
		
		GridPane griglia=new GridPane();

		Image iX=new Image(getClass().getResourceAsStream("Immagine.png"));
		ImageView visualImage=new ImageView(iX);
		
		griglia.add(cAXSeconda, 0, 0);		
		griglia.add(eIncognitaA, 1, 0);		
		griglia.add(cBXSeconda, 2, 0);		
		griglia.add(eIncognitaB, 3, 0);		
		griglia.add(cCXSeconda, 4, 0);	
		griglia.add(eIncognitaC, 5, 0);
		griglia.add(bCalcolaSoluzione, 0, 1, 6, 1);
		griglia.add(eRisultato, 0, 2, 6, 1);
		griglia.add(visualImage, 0, 3);
		
		bCalcolaSoluzione.setMaxWidth(600);
		
		bCalcolaSoluzione.setOnAction(e -> calcolaEquzione());
		
		griglia.setPadding(new Insets(10,10,10,10));
		griglia.setHgap(10);
		griglia.setVgap(10);

		Scene scena=new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Equazione secondo grado");
		finestra.show();
	}
	public void calcolaEquzione() {
		double a=Double.parseDouble(cAXSeconda.getText());
		double b=Double.parseDouble(cBXSeconda.getText());
		double c=Double.parseDouble(cCXSeconda.getText());
		
		double dDelta=(b*b)-4*a*c;
		
		System.out.println(dDelta);
		
		double dRisultato=0;
		double dRisultato2=0;
		if(a==0) {//è di primo grado
			c=c*-1;
			if(b*-1>=0) {
				//la b è negativa 
				c=-c;
				b=-b;
				dRisultato=c/b;
			}else {
				//la b è positiva
				dRisultato=c/b;
			}
			eRisultato.setText("l'equzione è di primo grado X="+dRisultato);
		}else if(c==0 && b==0){
			eRisultato.setText("l'equzione è monomia il risultato è sempre uguale a zero X=0");
		}else if(b==0) {
			c=-c;
			dRisultato=c/a;
			dRisultato=Math.sqrt(dRisultato);
			eRisultato.setText("l'equzione è pura X1="+dRisultato+" X2=-"+dRisultato);
		}else if(c==0) {
			b=-b;
			dRisultato=b/a;
			eRisultato.setText("l'equzione è spuria una x è sempre ugualea 0, X1=0 X2="+dRisultato);
		}else {
			if(dDelta<0) {
				eRisultato.setText("l'equzione è impossibile");
			}else if(dDelta==0) {
				dRisultato=(-b+Math.sqrt(dDelta))/(2*a);
				eRisultato.setText("l'equazione è indeterminata X1="+dRisultato+"  X2=-"+dRisultato);
			}else if(dDelta>0) {
				dRisultato=(-b+Math.sqrt(dDelta))/(2*a);
				dRisultato2=(-b-Math.sqrt(dDelta))/(2*a);
				eRisultato.setText("l'equazione torna X1="+dRisultato+"  X2="+dRisultato2);
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}

package it.edu.iisgubbio.giochi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
/*TODO: aggiungere un controllo sui punti.
nelle impostazioni inserire il limite di punti che si 
vogliono fare, verra fatto il controllo dei punti
e quando arrivano al limite impostato la partità
si fermerà
*/
public class PingPong extends Application{
	final int LARGHEZZA_SCHERMO=500;
	final int ALTEZZA_SCHERMO=400;
	final int LIMITE_LATO_ALTO=80;
	final int LARGHEZZA_RACCHETTA=18;
	final int ALTEZZA_RACCHETTA=100;
	final int DISTANZA_DALLA_Y=10;
	final int LARGHEZZA_BOTTONE_MENU= 200;
	final int REGOLA_POSIZIONE_Y=50; //regola la posizione nell'asse delle y dei bottoni nel menu
	//posizione pallina
	int posX;
	int posY;
	boolean orizzontale=true;
	boolean verticale=true;
	int valSX=0;//punteggio Sinistra
	int valDX=0;//punteggio Destra
	int spostamento=5;
	
	int statoAttuale=1;//1=nella home; 2=il gioco inizia; 3=impostazioni
	boolean statoSettings=false;
	boolean booleanCountDown=false;//indica se il countdown deve comparire
	boolean start=true;//indica se il gioco è stato iniziato o no
	boolean delay=false;//indica quando serve un secopndo di pausa nel gioco
	Image imageMenu = new Image(getClass().getResourceAsStream("menu_icon_150667.png"));
    ImageView menuVisualizza = new ImageView(imageMenu);
	
	Label punteggio=new Label(valSX+"-"+valDX);
	Circle cerchio=new Circle(10);
	Rectangle rettangoloSx = new Rectangle(LARGHEZZA_RACCHETTA,ALTEZZA_RACCHETTA);
	Rectangle rettangoloDx = new Rectangle(LARGHEZZA_RACCHETTA,ALTEZZA_RACCHETTA);
	Button cambiaStato=new Button("Start");
	Button settings=new Button("Impostazioni");
	Button menu=new Button("",menuVisualizza);
	Rectangle sfondoCountDown=new Rectangle(60,60);
	Label countDown=new Label("");
	Label scrittaPunto=new Label("PUNTO!");
	Circle centroCampo=new Circle(35);
	Line lineYCentro = new Line(LARGHEZZA_SCHERMO/2, LIMITE_LATO_ALTO-10, LARGHEZZA_SCHERMO/2, ALTEZZA_SCHERMO+10);
	Line lineYSinistra = new Line(0, LIMITE_LATO_ALTO-10, 0, ALTEZZA_SCHERMO+10);
	Line lineYDestra = new Line(LARGHEZZA_SCHERMO, LIMITE_LATO_ALTO-10, LARGHEZZA_SCHERMO, ALTEZZA_SCHERMO+10);
	Label eVelocitaPallina= new Label("Velocità pallina");
    Slider velocitaPallina = new Slider(5,15,10);
	Label titolo=new Label("PingPong"); 
	Label comunicazioni=new Label("Benvenuto in PingPong, \n gioca in compagnia o in solitario,\n passando il tuo tempo con noi.");
	Label eVelocitaRacchette= new Label("Velocità racchette");
    Slider velocitaRacchette = new Slider(1,15,5);
	Line lineXLimiteAlto = new Line(0, LIMITE_LATO_ALTO-10, LARGHEZZA_SCHERMO, LIMITE_LATO_ALTO-10);
	Line lineXLimiteBasso = new Line(0, ALTEZZA_SCHERMO+10, LARGHEZZA_SCHERMO, ALTEZZA_SCHERMO+10);
	Button restart=new Button("Restart");
	Button salva= new Button("salva");
	int rotation=0;//serve per indicare la rotazione dello sfondo del countdown
	int val=4;//valore che viene scritto nel countdown
	
	double valoreRandom1;//indica l'angolazione casuale della pallina per lasse delle X
	double valoreRandom2;//indica l'angolazione casuale della pallina per lasse delle Y
	
	Pane pingPong=new Pane();//lo dichiariamo fuori perche lo richimamiamo nei metodi dove cambiamo interfaccia
	
	Timeline timelineCountDown = new Timeline(new KeyFrame(
		Duration.millis(1000),
		x -> countdown()));
	
	Timeline iniziaGioco = new Timeline();
	
	public void start(Stage finestra) {
		GridPane griglia=new GridPane();
		griglia.setAlignment(Pos.CENTER);
		griglia.add(pingPong, 0, 0);
		
		pingPong.setPrefSize(LARGHEZZA_SCHERMO, ALTEZZA_SCHERMO);
		
		cerchio.setFill(Color.GREY);
		
		cambiaInterfaccia();
		
		iniziaGioco.getKeyFrames().add(new KeyFrame(
				Duration.millis(10),
				x -> spostaPallina()));
		
		cambiaStato.setOnAction(s->stato());
		menu.setOnAction(s->stato());
		restart.setOnAction(r->restart());	
		settings.setOnAction(s->cambiaSettings());
		salva.setOnAction(e->aggiornaValori());
		
		sfondoCountDown.setId("sfondoCountDown");
		countDown.setId("countDownLabel");
		scrittaPunto.setId("scrittaPunto");
		punteggio.setId("punteggio");
		menu.setId("menuButton");
		centroCampo.setId("centroCampo");
		menuVisualizza.setFitWidth(40);
		menuVisualizza.setFitHeight(40);
		titolo.setId("titolo");
		comunicazioni.setId("comunicazioni");
		velocitaRacchette.setShowTickMarks(true);
		velocitaRacchette.setShowTickLabels(true);
		velocitaPallina.setShowTickMarks(true);
		velocitaPallina.setShowTickLabels(true);
		velocitaRacchette.setSnapToTicks(true);
        velocitaPallina.setSnapToTicks(true);
        velocitaRacchette.setMinorTickCount(0);
        velocitaPallina.setMinorTickCount(0);
        velocitaRacchette.setMajorTickUnit(2);
        velocitaPallina.setMajorTickUnit(1);
		
        centroCampo.setCenterX(LARGHEZZA_SCHERMO/2);
        centroCampo.setCenterY((ALTEZZA_SCHERMO+80)/2);
		titolo.setLayoutX((LARGHEZZA_SCHERMO-125)/2);
		titolo.setLayoutY(40);
		comunicazioni.setLayoutX((LARGHEZZA_SCHERMO-300)/2);
		comunicazioni.setLayoutY(90);
		cambiaStato.setLayoutX((LARGHEZZA_SCHERMO-LARGHEZZA_BOTTONE_MENU)/2);
		cambiaStato.setLayoutY((ALTEZZA_SCHERMO-REGOLA_POSIZIONE_Y)/2);
		settings.setLayoutX((LARGHEZZA_SCHERMO-LARGHEZZA_BOTTONE_MENU)/2);
		settings.setLayoutY((ALTEZZA_SCHERMO+100-REGOLA_POSIZIONE_Y)/2);
		
		Scene scena=new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/giochi/StylePingPong.css");
		scena.setOnKeyPressed(e -> pigiato(e));
		finestra.setScene(scena);
		finestra.setTitle("PingPong");
		finestra.show();
	}
	public void stato() {
		if(statoAttuale==2 || statoAttuale==3 && statoSettings==false) {
			//ci troviamo nel gioco
			statoAttuale=1; //spostiamo il valore a 1 andiamo nel menu
		}else if(statoAttuale==1 && statoSettings==false) {
			//ci troviamo nel menù
			statoAttuale=2; //spostiamo il valore a 2 iniziamo il gioco
		}else if(statoAttuale==1 && statoSettings==true) {
			//ci troviamo nel menu
			statoAttuale=3; //spostiamo il valore a 3 e andiamo nelle impostazioni
		}
		cambiaInterfaccia();
	}
	public void cambiaSettings() {
		statoSettings=!statoSettings;
		stato();
	}
	public void restart() {
		valSX=0;
		valDX=0;
		statoAttuale=2;
		pingPong.getChildren().clear();
		cambiaInterfaccia();
	}
	public void aggiornaValori(){
		int vRacc=(int)(velocitaRacchette.getValue());
		spostamento=vRacc;
		
		int vPall=(int)(velocitaPallina.getValue());
		int valore=0;
		/*
		 * con valore massimo che sia 15
		 * valore=10-vPall;
		 * valore=valore*2+vPall;
		*/
		valore=20-vPall;
		iniziaGioco.stop();
		iniziaGioco.getKeyFrames().clear();
		iniziaGioco.getKeyFrames().add(new KeyFrame(
				Duration.millis(valore),
				x -> spostaPallina()));
	}
	public void cambiaInterfaccia() {
		aggiornaValori();
		if(statoAttuale==2) {
			start=false;
			pingPong.getChildren().clear();
			
			pingPong.getChildren().add(lineXLimiteAlto);
			pingPong.getChildren().add(lineXLimiteBasso);	
			pingPong.getChildren().add(lineYCentro);	
			pingPong.getChildren().add(lineYSinistra);	
			pingPong.getChildren().add(lineYDestra);	
			pingPong.getChildren().add(centroCampo);
			pingPong.getChildren().add(cerchio);
			pingPong.getChildren().add(punteggio);
			pingPong.getChildren().add(rettangoloSx);
			pingPong.getChildren().add(rettangoloDx);
			pingPong.getChildren().add(sfondoCountDown);
			pingPong.getChildren().add(countDown);
			pingPong.getChildren().add(scrittaPunto);
			pingPong.getChildren().add(menu);		
			punteggio.setText(valSX+"-"+valDX);

			sfondoCountDown.setVisible(true);
			countDown.setVisible(true);
	
			posX=LARGHEZZA_SCHERMO/2;
			posY=(ALTEZZA_SCHERMO+80)/2;
			cerchio.setCenterX(posX);
			cerchio.setCenterY(posY);
			
			menu.setLayoutX(10);
			menu.setLayoutY(7.5);
			
			scrittaPunto.setVisible(false);
			scrittaPunto.setLayoutX((LARGHEZZA_SCHERMO-200)/2);
			scrittaPunto.setLayoutY((ALTEZZA_SCHERMO+9.5)/2);
			countDown.setLayoutX((LARGHEZZA_SCHERMO-15)/2);
			countDown.setLayoutY((ALTEZZA_SCHERMO+40)/2);
			sfondoCountDown.setX((LARGHEZZA_SCHERMO-60)/2);
			sfondoCountDown.setY((ALTEZZA_SCHERMO+20)/2);

			punteggio.setLayoutX((LARGHEZZA_SCHERMO-40)/2);
			punteggio.setLayoutY(10);

			rettangoloSx.setX(DISTANZA_DALLA_Y);
			rettangoloDx.setX(LARGHEZZA_SCHERMO-LARGHEZZA_RACCHETTA-DISTANZA_DALLA_Y);
			rettangoloSx.setY((ALTEZZA_SCHERMO-ALTEZZA_RACCHETTA+LIMITE_LATO_ALTO)/2);
			rettangoloDx.setY((ALTEZZA_SCHERMO-ALTEZZA_RACCHETTA+LIMITE_LATO_ALTO)/2);
			booleanCountDown=true;
			timeline();
		}else if(statoAttuale==1){
			pingPong.getChildren().clear();
			if(start) {
				pingPong.getChildren().add(titolo);
				pingPong.getChildren().add(comunicazioni);
				pingPong.getChildren().add(cambiaStato);
				pingPong.getChildren().add(settings);
			}else {
				countDown.setText("");
				rotation=0;
				sfondoCountDown.setRotate(rotation);
				val=4;
				delay=false;
				sfondoCountDown.setVisible(false);
				countDown.setVisible(false);
				
				titolo.setLayoutX((LARGHEZZA_SCHERMO-125)/2);
				titolo.setLayoutY(40);
				comunicazioni.setLayoutX((LARGHEZZA_SCHERMO-300)/2);
				comunicazioni.setLayoutY(90);
				cambiaStato.setLayoutX((LARGHEZZA_SCHERMO-LARGHEZZA_BOTTONE_MENU)/2);
				cambiaStato.setLayoutY((ALTEZZA_SCHERMO-REGOLA_POSIZIONE_Y)/2);
				restart.setLayoutX((LARGHEZZA_SCHERMO-LARGHEZZA_BOTTONE_MENU)/2);
				restart.setLayoutY((ALTEZZA_SCHERMO+100-REGOLA_POSIZIONE_Y)/2);
				settings.setLayoutX((LARGHEZZA_SCHERMO-LARGHEZZA_BOTTONE_MENU)/2);
				settings.setLayoutY((ALTEZZA_SCHERMO+200-REGOLA_POSIZIONE_Y)/2);
				
				comunicazioni.setText("Scegli cosa fare, \n puoi cambiare le impostazioni, \n continuare il gioco o resettare la partita");
				
				pingPong.getChildren().add(titolo);
				pingPong.getChildren().add(comunicazioni);
				pingPong.getChildren().add(cambiaStato);
				pingPong.getChildren().add(settings);
				pingPong.getChildren().add(restart);
				cambiaStato.setText("Continua");
				timelineCountDown.stop();
				iniziaGioco.stop();
			}
		}else if(statoAttuale==3) {
			//costruiamo l'interfaccia delle impostazioni
			statoSettings=false;
			pingPong.getChildren().clear();	

			comunicazioni.setText("Qui puoi cambiare i settaggi del gioco \n come la velocità della pallina");
			
			titolo.setLayoutX((LARGHEZZA_SCHERMO-125)/2);
			titolo.setLayoutY(40);
			comunicazioni.setLayoutX((LARGHEZZA_SCHERMO-300)/2);
			comunicazioni.setLayoutY(90);
			eVelocitaPallina.setLayoutX((LARGHEZZA_SCHERMO-200)/2);
			eVelocitaPallina.setLayoutY(150);
			eVelocitaRacchette.setLayoutX((LARGHEZZA_SCHERMO-200)/2);
			eVelocitaRacchette.setLayoutY(220);
			velocitaPallina.setLayoutX((LARGHEZZA_SCHERMO-200)/2);
			velocitaPallina.setLayoutY(170);
			velocitaRacchette.setLayoutX((LARGHEZZA_SCHERMO-200)/2);
			velocitaRacchette.setLayoutY(240);
			menu.setLayoutX(10);
			menu.setLayoutY(10);
			salva.setLayoutX((LARGHEZZA_SCHERMO-200)/2);
			salva.setLayoutY(290);

			pingPong.getChildren().add(titolo);
			pingPong.getChildren().add(comunicazioni);
			pingPong.getChildren().add(eVelocitaPallina);
			pingPong.getChildren().add(eVelocitaRacchette);
			pingPong.getChildren().add(velocitaPallina);
			pingPong.getChildren().add(velocitaRacchette);
			pingPong.getChildren().add(menu);
			pingPong.getChildren().add(salva);
			}
	}
	public void timeline() {
		if(booleanCountDown) {
			//attiva la timeline del cowntdown
			timelineCountDown.setCycleCount(4); 
			timelineCountDown.play();
			countdown();
		}else if(delay){
			iniziaGioco.stop();			
			timelineCountDown.setCycleCount(1); 
			scrittaPunto.setVisible(true);
			timelineCountDown.play();
		}else {
			//una volta finito il cowntdown inizia a muoversi la pallina
			val=4;//resettiamo il numero del countdown cosichhe al riavvio del metodo non si sommi
			iniziaGioco.setCycleCount(Timeline.INDEFINITE); 
			iniziaGioco.play();
		}
	}
	public void countdown() {
		if(delay) {
			scrittaPunto.setVisible(false);
			delay=false;
			timeline();
		}else {
			val--;
			countDown.setText(""+val);
			rotation+=45;
			sfondoCountDown.setRotate(rotation);
			if(val==0) {
				sfondoCountDown.setVisible(false);
				countDown.setVisible(false);
				booleanCountDown=false;
				countDown.setText("");
				timeline();
			}
		}
	}	
	public void spostaPallina() {
		
		Bounds bSX = rettangoloSx.getBoundsInParent();
	    Bounds bDX = rettangoloDx.getBoundsInParent();
	    Bounds pallina = cerchio.getBoundsInParent();
	    //rimbalza sulle racchette
		if(pallina.intersects(bSX)) {
			orizzontale=true;
	    }else if(pallina.intersects(bDX)) {
			orizzontale=false;
	    }
		//rimbalza sui limiti
		if(posX>=LARGHEZZA_SCHERMO) {
			orizzontale=false;
			valSX+=1;
			punteggio.setText(valSX+"-"+valDX);
			posX=LARGHEZZA_SCHERMO/2;
			posY=(ALTEZZA_SCHERMO+80)/2;
			delay=true;
			timeline();
		}
		if(posX<=0) {
			orizzontale=true;
			valDX+=1;
			punteggio.setText(valSX+"-"+valDX);
			posX=LARGHEZZA_SCHERMO/2;
			posY=(ALTEZZA_SCHERMO+80)/2;
			delay=true;
			timeline();
		}
		//cambia ad ogni rimbalzo
		if(orizzontale) {
			posX+=1;
		}else {
			posX-=1;
		}
		//rimbalza sui limiti
		if(posY>=ALTEZZA_SCHERMO) {
			verticale=false;
		}
		if(posY<=LIMITE_LATO_ALTO) {
			verticale=true;
		}
		//cambia ad ogni rimbalzo
		if(verticale) {
			posY+=1;
		}else {
			posY-=1;
		}
		cerchio.setCenterX(posX);
		cerchio.setCenterY(posY);
	}
	public void pigiato(KeyEvent valore) {
		if(valore.getText().equals("W") || valore.getText().equals("w")) {
			if(rettangoloSx.getY()>=LIMITE_LATO_ALTO) {
				rettangoloSx.setY(rettangoloSx.getY()-spostamento);
			}
		}
		if(valore.getText().equals("Z") || valore.getText().equals("z")) {
			if(rettangoloSx.getY()<=300) {
				rettangoloSx.setY(rettangoloSx.getY()+spostamento);
			}
		}
		if(valore.getText().equals("I") || valore.getText().equals("i")) {
			if(rettangoloDx.getY()>=LIMITE_LATO_ALTO) {
				rettangoloDx.setY(rettangoloDx.getY()-spostamento);
			}
		}
		if(valore.getText().equals("M") || valore.getText().equals("m")) {
			if(rettangoloDx.getY()<=300) {
				rettangoloDx.setY(rettangoloDx.getY()+spostamento);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
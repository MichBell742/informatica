package it.edu.iisgubbio.quiz;

public class Domanda {
	private String domanda;
	private String[] risposte;
	private String rispostaGiusta;
	
	public Domanda(String rigaFile) {
		String[] elementi=rigaFile.split(",");
		this.domanda= elementi[0];
		risposte=new String[3]; 
		risposte[0]=elementi[1];
		risposte[1]=elementi[2];
		risposte[2]=elementi[3];
		rispostaGiusta=elementi[4];
	}
	
	public String getDomanda() {
		return domanda;
	}
	
	public String[] getRisposte() {
		return risposte;
	}
	
	public String getRispostaGiusta() {
		return rispostaGiusta;
	}
}

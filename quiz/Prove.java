package it.edu.iisgubbio.quiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Prove {
	public static void main(String[] args) {
		String destinazione="/Users/bellucci/Desktop/test.csv";
		try(
				FileReader file= new FileReader(destinazione);
				BufferedReader lettore= new BufferedReader(file);
				){
			Domanda domanda= new Domanda(lettore.readLine());
			System.out.println(domanda.getDomanda());
			System.out.println(domanda.getRisposte());
			System.out.println(domanda.getRispostaGiusta());
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

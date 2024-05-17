package org.generation.italy;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		HashSet<Integer> schedaGiocatore = new HashSet<Integer>();
		HashSet<Integer> numBingo = new HashSet<Integer>();
		int num, numEstratto, numTrovati = 0;
		boolean bingo = false;
		boolean cinquina = false;
		String risposta;
		
		// Generazione scheda giocatore
		while (schedaGiocatore.size() < 15 ) {
			num = r.nextInt(90) + 1;
			schedaGiocatore.add(num);
		}
			// Messaggio di benvenuto e mostra scheda del giocatore
			System.out.println("Benvenuto al Bingo!");
			System.out.println("La tua scheda: ");
			System.out.println(schedaGiocatore);
			
			do {
			// Inizio gioco
			do {
				System.out.println("Premi invio per estrarre un numero");
				sc.nextLine();
				// Inizio ciclo estrazione numero
				do {
				numEstratto = r.nextInt(90) + 1;
				} while (numBingo.contains(numEstratto));
				numBingo.add(numEstratto);
				System.out.println("Il numero estratto è " + numEstratto);
				
				// Verifica se il numero estratto è presente nella scheda del giocatore
				if (schedaGiocatore.contains(numEstratto)) {
					numTrovati++;
				}
				
				// Verifica cinquina
				if (numTrovati == 5) {
					cinquina = true;
					System.out.println("Hai fatto cinquina!");
				}
				// Verifica bingo
				if (numTrovati == 15) {
					bingo = true;
					System.out.println("Hai fatto bingo!");
				}
				// Stampa nuova scheda giocatore
				System.out.println("Hai trovato: " + numTrovati + " numeri");
				System.out.println("La tua scheda: ");
				System.out.println(schedaGiocatore);
				
			} while (!bingo);
			
			System.out.println("Vuoi giocare ancora?");
			risposta = sc.nextLine();
			
			} while (risposta.equalsIgnoreCase("s"));
	}

}

package fpdualeveris;

import java.util.InputMismatchException;
import java.util.Scanner;

import operators.Pinball;

/**
 * Formaci�n Java
 * 
 * @author fprietoa
 *
 */
public class FPDual {

	/**
	 * M�todo Principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Bienvenido al Pinball!");

		operatorsChallenge();

	}

	/**
	 * M�todo operatorsChallenge()
	 */
	private static void operatorsChallenge() {

		boolean end = false;
		int coins = 0;
		Scanner scanner = new Scanner(System.in);
				
		// Bucle hasta que introduce un valor correcto.
		while (end == false) {

			// Insertar fichas
			System.out.println("\nCada ficha equivale a 5 bolas." + "\n�Cuantas fichas quieres insertar?");
			
			
			// Capturador de errores
			try {
				coins = scanner.nextInt();
				end = true;
			} catch (InputMismatchException e) {
				System.out.println("Valor introducido no v�lido, vuelve a intentarlo: " + e);
			}
		}
				
		Pinball game = new Pinball(coins);

		// Bucle por cada ficha metida
		for (int i = 0; i < coins; i++) {

			System.out.println("\n------------------");
			System.out.println("Partida n�mero " + (i + 1));
			System.out.println("------------------\n");
			// Instancia del juego
			game.launchBall();
		}
		
		scanner.close();

	}

}

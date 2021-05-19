package operators;

/**
 * Formaci�n Java
 * 
 * @author fprietoa
 *
 */
public class Pinball {

	/** Atributo puntuaci�n */
	private int point = 0;

	StringBuilder str = new StringBuilder();

	/**
	 * Constructor
	 * 
	 * @param point
	 */
	public Pinball(int point) {
		this.point = point;
	}

	/**
	 * M�todo lanzar bola.
	 */
	public void launchBall() {

		// Variables
		boolean stop = false;
		
		// bucle por el n�mero de tiradas
		for (int i = 0; i < 5 && !stop; i++) {

			System.out.println("Bola n�mero: " + (i + 1));

			// Generar un n�mero aleatorio entre 0 y 100
			extracted();

			// Tiempo de espera entre tiradas.
			try {
				Thread.sleep(600);
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}

			// Final del juego.
			stop = endGame(stop, i);
		}

	}

	/**
	 * M�todo para extraer un n�mero aleatorio
	 */
	public void extracted() {
		boolean bonus;
		int random;
		random = numRandom(1, 100);
		bonus = (random > 0 && random < 80) ? true : false;
		if (bonus) {
			bonusPoint();
		} else {
			punishPoint();
		}
	}

	/**
	 * M�todo que termina el juego.
	 * 
	 * @param stop
	 * @param i
	 * @return
	 */	
	public boolean endGame(boolean stop, int i) {
		if (getPoint() > 500) {
			stop = true;
			System.out.println("\nEnhorabuena has ganado!");
			winnerGift();

		} else if (getPoint() < 0 || (i == 4 && (getPoint() < 500))) {
			stop = true;
			System.out.println("\nHas perdido, hasta la pr�xima!");
		}
		return stop;
	}

	/**
	 * Getter
	 * 
	 * @return
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * M�todo para actualizar la puntuaci�n.
	 * 
	 * @param point
	 */
	public void updatePoint(int point) {
		this.point += point;
	}

	/**
	 * M�todo para generar un n�mero Random
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public int numRandom(int min, int max) {
		return (int) (Math.random() * max + min);
	}

	/**
	 * M�todo para aumenta los puntos
	 */
	public void bonusPoint() {

		updatePoint(numRandom(25, 300));
		System.out.println("Tu puntuaci�n aumenta a: " + getPoint());

	}

	/**
	 * M�todo para disminuir los puntos
	 */
	public void punishPoint() {

		updatePoint(numRandom(-25, -100));
		System.out.println("Tu puntuaci�n disminuye a: " + getPoint());

	}

	public void winnerGift() {
		switch (getPoint()) {
		case 500:
			System.out.println("\nHas ganado unos cascos!");
			break;
		case 550:
			System.out.println("\nHas ganado un m�vil!");
			break;
		case 600:
			System.out.println("\nHas ganado un patinete!");
			break;
		case 650:
			System.out.println("\nHas ganado un reloj!");
			break;
		case 700:
			System.out.println("\nHas ganado un ordenador!");
			break;
		case 750:
			System.out.println("\nHas ganado una television!");
			break;
		default:
			System.out.println("\nHas ganado un peluche!");
			break;
		}
	}

}

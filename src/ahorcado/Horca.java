package ahorcado;

public class Horca {
	protected static final int MAX_FALLOS = 6;
	/**
	 * Es el número de fallos que lleva el usuario, vamos a permitir 6 fallos
	 */
	private int fallos;

	public Horca() {
		setFallos(0);
	}

	/** Indica la cantidad de fallos **/
	public void dibujar() {
		System.out.println("\nFallos: " + getFallos() + "/6 \n");
	}

	/**
	 * Incrementa el contador de fallos
	 */
	public void incrementarFallo() {
		setFallos(getFallos() + 1);
	}

	/**
	 * 
	 * 
	 * @return Comprueba si hemos perdido la partida
	 */
	public boolean comprobarSiPerdido() {
		return (getFallos() == MAX_FALLOS);
	}

	/**
	 * @return Devuelve los fallos
	 **/
	public int getFallos() {
		return fallos;
	}

	/**
	 * 
	 * @param fallos
	 *            Constructor que ajusta los fallos desde otra clase
	 */
	public void setFallos(int fallos) {
		this.fallos = fallos;
	}
};

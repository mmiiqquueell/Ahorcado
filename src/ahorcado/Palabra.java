package ahorcado;

public class Palabra {

	private static final int NUM_LETRAS_ABECEDARIO = 27;
	private String palabraOculta;
	/**
	 * Son las letras que el jugador ha acertado
	 */
	private char[] letrasDescubiertas = new char[NUM_LETRAS_ABECEDARIO];
	/**
	 * Son las letras que el jugador ha dicho pero no estaban en la palabra
	 */
	private char[] letrasFallidas = new char[NUM_LETRAS_ABECEDARIO];

	/**
	 * 
	 * Devuelve una palabra aleatoria.
	 */
	public void elegirPalabra() {
		String[] palabras = { "coches", "animales", "alumnos", "profesores", "juegos", "pato", "taladro", "mago",
				"colores", "ordenador", "caseta", "asignatura" };
		String elegida = palabras[(int) (Math.round(Math.random() * (palabras.length - 1)))];
		palabraOculta = elegida;
	}

	/**
	 * 
	 * @param letra
	 *            Comprueba la letran introducida por el usuario
	 * @return Develve si la letra existe o no
	 */
	public boolean comprobarLetraUsada(char letra) {
		for (int i = 0; i < letrasDescubiertas.length; i++) {
			if (letra == letrasDescubiertas[i]) {
				return true;
			}
		}
		for (int i = 0; i < letrasFallidas.length; i++) {
			if (letra == letrasFallidas[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprueba si letra está en la palabra oculta
	 * 
	 * @param letra
	 *            Es la letra a comprobar si está en la palabra a adivinar
	 * @return Devuelve verdadero si la letra está al menos una vez en la
	 *         palabra y falso en caso contrario
	 */
	public boolean comprobarLetra(char letra) {

		if (palabraOculta.indexOf(letra) == -1) {
			insertarLetra(letra, letrasFallidas);
			return false;
		} else {
			insertarLetra(letra, letrasDescubiertas);
			return true;
		}

	}

	/**
	 * 
	 * @param letra
	 *            Letra insertada por el usuario
	 * @param destino
	 *            Guarda la letra insertada por el usuario
	 */
	private void insertarLetra(char letra, char[] destino) {
		for (int i = 0; i < destino.length; i++) {
			if (destino[i] == '\u0000') {
				destino[i] = letra;
				break;
			}
		}
	}

	/**
	 * Mostramos el estado de la palabra, las letras acertadas y las letras
	 * fallidas
	 */
	public void mostrarResultados() {

		char[] descompuesta = palabraOculta.toCharArray();
		System.out.println("\nProgreso:");
		for (int i = 0; i < descompuesta.length; i++) {
			boolean estaEnDescubiertas = false;
			for (int j = 0; j < letrasDescubiertas.length; j++) {
				if (descompuesta[i] == letrasDescubiertas[j]) {
					estaEnDescubiertas = true;
					break;
				}
			}
			if (estaEnDescubiertas) {
				System.out.print(descompuesta[i]);
			} else {
				System.out.print("_");
			}
		}

		System.out.println("\n\nAciertos: ");
		for (int i = 0; i < letrasDescubiertas.length; i++) {
			if (letrasDescubiertas[i] != '\u0000') {
				System.out.print(letrasDescubiertas[i] + " - ");
			}
		}
		System.out.println("\n\nFallos: ");
		for (int i = 0; i < letrasFallidas.length; i++) {
			if (letrasFallidas[i] != '\u0000') {
				System.out.print(letrasFallidas[i] + " - ");
			}
		}
	}

	/**
	 * Comprueba si hemos acertado todas las letras
	 * 
	 * @return Devuelve si hemos ganando o perdido
	 */
	public boolean comprobarSiGanado() {
		boolean estanTodas = true;
		char[] descompuesta = palabraOculta.toCharArray();
		for (int i = 0; i < descompuesta.length; i++) {
			boolean estaEnDescubiertas = false;
			for (int j = 0; j < letrasDescubiertas.length; j++) {
				if (descompuesta[i] == letrasDescubiertas[j]) {
					estaEnDescubiertas = true;
					break;
				}
			}
			if (!estaEnDescubiertas) {
				estanTodas = false;
				break;
			}
		}
		return estanTodas;
	}

	/**
	 * 
	 * 
	 * @param palabra
	 *            Comprueba si la palabra propuesta por el jugador coincide con
	 *            la palabra oculta (quiero resolver)
	 * @return Adivinada es verdadero si la palabra coincide con la que
	 *         buscábamos
	 */
	public boolean comprobarPalabra(String palabra) {
		return palabraOculta.equals(palabra);
	}
}

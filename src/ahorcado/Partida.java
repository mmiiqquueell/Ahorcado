package ahorcado;

import java.util.Scanner;

public class Partida {

	private static Scanner entrada = new Scanner(System.in);
	private static boolean noAcabado = true;
	public static Horca horca;

	public static Palabra palabra;

	/**
	 * 
	 * @param args
	 *            Parámetro sin uso Método MAIN Master Principal, inicio de
	 *            ejecución de programa.
	 */
	public static void main(String[] args) {
		horca = new Horca();
		palabra = new Palabra();
		palabra.elegirPalabra();
		while (!comprobarFinal() && noAcabado) {
			switch (menuPrincipal()) {
			case 1:
				palabra.comprobarLetra(pedirLetra());
				mostrarProgreso();
				break;
			case 2:
				if (resolver()) {
					System.out.println("Has ganado");
				} else {
					System.out.println("Has perdido");
					noAcabado = false;
				}
				break;
			case 3:
				System.exit(0);
			default:
				continue;
			}

		}

	}

	/**
	 * Menu de seleccion
	 * 
	 * @return
	 */
	public static int menuPrincipal() {
		System.out.println("Pulse 1 para introducir letra\nPulse 2 para resolver palabra:\nPulse 3 para salir\n");
		return entrada.nextInt();
	}

	/**
	 * Muestra el estado actual de la horca.
	 */
	public static void mostrarProgreso() {
		horca.dibujar();
		palabra.mostrarResultados();
	}

	/**
	 * @return Solicita una letra al usuario
	 */
	public static char pedirLetra() {

		System.out.println("Introduzca un caracter: ");
		char letra = entrada.nextLine().charAt(0);
		return letra;
	}

	/**
	 * 
	 * @return
	 * 
	 * 		Devuelve si la palabra introducida es correcta o no.
	 */
	public static boolean resolver() {
		System.out.println("Introduzca la palabra: ");
		return palabra.comprobarPalabra(entrada.nextLine());
	}

	/**
	 * @return
	 * 
	 * 		Comprueba si hemos ganado o perdido.
	 */
	public static boolean comprobarFinal() {
		return horca.comprobarSiPerdido() || palabra.comprobarSiGanado();

	}
};

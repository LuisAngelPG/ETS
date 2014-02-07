package proyecto;

import java.util.Scanner;

public class Laberinto {
	
	Scanner teclado = new Scanner(System.in);
	public	Personaje P1;
	public	Personaje P2;
	
	boolean bucle;
	boolean parte1;
	boolean parte2;
		
	String eleccion;
	String respuesta; 
	
	int contador; 
	int dirr = 1;
	
	public Laberinto(Personaje P1, Personaje P2){
		this.P1 = P1;	
		this.P2 = P2;
				
	}
	
	public void laberinto1() {
		System.out.println ("Sales de la celda y llegas a lo que parece el principio de un laberinto."
				+ "\nNo tienes m�s remedio que seguir e intentar salir. ");
		do {
			System.out.println("Llegas a un cruce con tres desvios. \n�Por donde vas?"
					+ "\n1) Recto"
					+ "\n2) Izquierda"
					+ "\n3) Derecha");
			eleccion = teclado.nextLine();
			if (eleccion.equals("inventario"))
				P1.inventario();
			System.out.println("vas hacia ah� y...");
			contador = contador + 1;
		} while (contador < 3);
		contador = 0;
		System.out.println("Acabas perdiendote, parece que te quedaras aqu� dando vultas bastante tiempo...");
		System.out.println("�"+P1.nombre+" est� perdido!");
		P1.perdido = true;
		
		Celda c = new Celda (P1, P2);
		c.celda2();
	
	}
	
	public void laberinto2() {
		System.out.println("Cruzas la puerta y te adentras en el laberinto.\nApenas miras un poco a tu alrededor encuentras a "+P1.nombre+",\n tras una breve charla decidis seguir juntos.\n�Ser�is capaces de salir?");
			do {
				System.out.println("Lleg�is a un cruce con tres desvios. \n�Por donde v�is?"
						+ "\n1) Recto"
						+ "\n2) Izquierda"
						+ "\n3) Derecha"
						+ "\n4) Ir a la celda");
				eleccion = teclado.nextLine();
				if (eleccion.equals("inventario"))
					P1.inventario();
				System.out.println("v�is hacia ah� y...");
				switch (eleccion) {
				case "2":
					switch (dirr) {
					case 1:
						dirr = dirr + 1;
						break;
					case 4:
						dirr = dirr + 1;
						break;
					case 2:
						dirr = 1;
						contador = contador + 1;
						break;
					case 3:
						dirr = 1;
						contador = contador + 1;
						break;
					}
					break;
				case "1":
					switch (dirr) {
					case 2:
						dirr = dirr + 1;
						break;
					case 1:
						dirr = 1;
						contador = contador + 1;
						break;
					case 3:
						dirr = 1;
						contador = contador + 1;
						break;
					case 4:
						dirr = 1;
						contador = contador + 1;
						break;
					}
					break;
				case "3":
					switch (dirr) {
					case 3:
						dirr = dirr + 1;
						break;
					case 1:
						dirr = 1;
						contador = contador + 1;
						break;
					case 2:
						dirr = 1;
						contador = contador + 1;
						break;
					case 4:
						dirr = 1;
						contador = contador + 1;
						break;
					}
					break;
				case "4":
					dirr = 1;
					contador = 0;
					Celda celda = new Celda (P1, P2);
					celda.celda1_2();
					break;
				}
			} while (contador < 3 || dirr < 5);
			
			if (contador > 3) {
			contador = 0;
			System.out.println(" acab�is perdidos, parece que os quedar�is aqu� dando vultas bastante tiempo...");
			System.out.println("�"+P2.nombre+" est� perdido!");
			System.out.println("�"+P1.nombre+" est� perdido!");
			P1.perdido = true;
			P2.perdido = true;
			Final final1 = new Final(P1, P2);
			final1.comprobar_final();
			}
			
			if (dirr > 5) {
				dirr = 1;
				System.out.println("Acab�is llegando a unas escaleras, en la cima de las escaleras hay una puerta."
						+ "\nLa puerta no tiene ning�n pomo y es totalmente lisa a excepci�n de un hueco en el centro.");
				do {
					bucle = true;
					System.out.println("�Qu� hac�is?"
							+ "\n1) Intentar abrir la puerta empujandola."
							+ "\n2) Inspeccionar el hueco.");
					if (P1.ObjGlifo == true) {
						System.out.println("3) Insertar la piedra con el glifo en la puerta.");		
					}
					eleccion = teclado.nextLine();
					if (eleccion.equals("inventario"))
						P1.inventario();
					switch (eleccion) {
					case "1":
						System.out.println("Intent�is abrir la puerta empujando ambos a la vez, pero no se mueve tan si quiera un mil�metro.");
						break;
					case "2":
						System.out.println("El hueco tiene una forma perfectamente circular.");
						break;
					case "3":
						System.out.println("El glifo encaja perfectamente en el hueco de la puerta. \nDe repente sale una l�nea brillante que cruza la puerta verticalmente y poco a poco la puerta empezo a abrirse..."
								+ "\nContinuar�...");
						break;
					}
				} while (bucle == true);
			}
	}
}
package proyecto;

import java.util.Scanner;

public class Celda {
	
	boolean bucle;
	boolean bucle2;
	boolean simbsubir = false;
	boolean simbbajar = false;
	boolean dibujocelda = false;
	
	String piedra;
	String eleccion;
	String respuesta; 
	
	Scanner teclado = new Scanner(System.in);

	public Personaje P1;
	public Personaje P2;
	
	public Celda(Personaje P1, Personaje P2){
		this.P1 = P1;	
		this.P2 = P2;
	}
	
	
	
	public void celda1 () {
		bucle = true;
		System.out.println (P1.nombre+" despierta en una fria y oscura habitaci�n de piedra, no tiene ningun recuerdo de como ha podido llegar hasta aqu�. \n"
				+ "La habitaci�n no tienen ning�n tipo de ventana, tampoco ning�n tipo de mueble. \n"
				+ "La �nica luz que hay proviene de unas extra�as palabras en el suelo con un resplandor azul");
		do {
			System.out.println ("�Qu� haces? \nElecciones:\n1) Buscar por la habitaci�n.\n2) Acercarse a las palabras del suelo.");		
			eleccion = teclado.nextLine();
			if (eleccion.equals("inventario"))
				P1.inventario();
			switch (eleccion) {
			case "1": 
				if (P1.ObjPiedra != true) {
					System.out.println ("Buscas en la peque�a habitaci�n. \nNo encuentras nada de valor o utilidad, lo �nico que podr�as llevarte es una piedra suelta de la pared... \n�Cogerla?");
					eleccion = teclado.nextLine();
					if (eleccion.equals("inventario"))
						P1.inventario();
					if (eleccion.equals("si")){
						System.out.println (P1.nombre + " ha conseguido una piedra.");
						P1.a�adir_objetos("Piedra");
						break;
					} else {
						System.out.println ("Lo dejas todo como estaba.");
						break;
					}
				} else {
					System.out.print("la habitaci�n esta completamente vacia.");
					break;
				}
			
			case "2": 
			System.out.println ("Te acercas a las extra�as palabras del suelo. Por alguna raz�n eres incapaz de ver nada m�s alla de la l�nea de palabras...que extra�o."
				+ "\nAntes de llegar y fijarte mejor, las palabras empiezan a volar y a escribir frases en el aire. "
				+ "\nBienvenido a X, est�s en el piso m�s bajo del castillo, ante ti te espera una serie de pruebas hasta llegar a la cima y reclamar tu libertad y el premio. "
				+ "\n�Ser�s capaz?"
				+ "\nLas palabras se desvanecen y tras ellas aparece la salida, un largo pasillo lleno de rutas secundarias. \nUn laberinto.");			
			System.out.println("Si sales de esta habitaci�n puede que no consigas volver a regresas, aun as� �Qui�res salir?");
			eleccion = teclado.nextLine();
			if (eleccion.equals("inventario"))
				P1.inventario();
			if (eleccion.equals("si")) {
				Laberinto laberinto = new Laberinto (P1, P2);
				laberinto.laberinto1();
			}
			break;
		}
	} while (bucle == true);
}		


	public void celda1_2 () {
		System.out.println("Llegas a la celda donde "+ P1.nombre +" estaba encerrado.");
		do { 
			bucle = true;
			System.out.println ("�Qu� haces? \nElecciones:"
					+ "\n1) Buscar por la habitaci�n."
					+ "\n2) Ir al laberinto.");		
			eleccion = teclado.nextLine();
			if (eleccion.equals("inventario"))
				P1.inventario();
			switch (eleccion) {
			case "1": 
				if (P1.ObjPiedra != true) {
					System.out.println ("Buscas en la peque�a habitaci�n. \nNo encuentras nada de valor o utilidad, lo �nico que podr�as llevarte es una piedra suelta de la pared... \n�Cogerla?");
					eleccion = teclado.nextLine();
					if (eleccion.equals("inventario"))
						P1.inventario();
					if (eleccion.equals("si")){
						System.out.println (P1.nombre + " ha conseguido una piedra.");
						P1.a�adir_objetos("Piedra");
						break;
					} else {
						System.out.println ("Lo dejas todo como estaba.");
						break;
					}
				} else {
					System.out.println("La habitaci�n esta completamente vacia.");
				}
			case "2":	
			Laberinto laberinto = new Laberinto (P1, P2);
			laberinto.laberinto2();
			}
		}while (bucle == true);
	}


	public void celda2 () {
		System.out.println(P2.nombre+" despierta en un pasillo, en los laterales hay multitud de celdas, parece que se puede seguir bajando o bien subir.");
		do {  //return bucle
			bucle = true;
			System.out.println("�Que haces?"
					+ "\n1) Bajar"
					+ "\n2) Subir"
					+ "\n3) Buscar por las celdas");
			eleccion = teclado.nextLine();
			if (eleccion.equals("inventario"))
				P1.inventario();
			switch (eleccion) {
			case "1": 
				System.out.println("Bajas por el pasillo, por los laterales sigue habiendo m�s y m�s celdas vacias."
						+ "\nLlegas a una puerta que tiene pintada un extra�o dibujo que resplandece");
				do { //return bucle2
					bucle2 = true;
					System.out.println("�Que haces?"
							+ "\n1) Intentar abrir la puerta."
							+ "\n2) Dar media vuelta");
					if (simbbajar == false) {
						System.out.println("3) Tocar el s�mbolo.");
					}
					eleccion = teclado.nextLine();
					if (eleccion.equals("inventario"))
						P1.inventario();
					switch (eleccion) {
					case "1":
						System.out.println("Cuando tocas el pomo recibes una fuerte descarga el�ctrica. "+P2.nombre+" pierde 10 de vida.");
						P2.resta_vida_personaje(10);
						Final final1 = new Final(P1,P2);
						final1.comprobar_final();
						break;
					case "2":
						System.out.println("Das media vuelta y vuelves a donde empezaste.");
						bucle2 = false;
						break;
						
					case "3":
						System.out.println("Cuando tocas el extra�o s�mbolo este se eleva en el aire y se divide en muchas letras."
								+ "\nLas letras se ordenan formando el siguiente texto:"
								+ "\nSi atraviesas esta puerta tendr�s que superar diversos retos para salir de aqu�, pero tendras una recompensa."
								+ "\nDa media vuelta y tendr�s tu libertad, aunque quizas abandones a alguien a su suerte..."
								+ "\n�Segu�ras por aqu� y reclamaras la recompensa?");
						eleccion = teclado.nextLine();
						if (eleccion.equals("inventario"))
							P1.inventario();
						if (eleccion.equals("si")) {
							System.out.println("Las palabras desaparecen y la puerta se abre sola."
									+ "\nEchas un vistazo y descubres lo que parece ser un laberinto, a�n estas a tiempo de dar media vuelta..."
									+ "\n�Te adentras?");
							if (eleccion.equals("si")) {
								simbbajar = true;
								Laberinto laberinto = new Laberinto(P1,P2);
								laberinto.laberinto2();
							}
						} else {
							System.out.println("Das media vuelta y vuelves a donde empezaste.");
							bucle2 = false;
							break;
						}
					}
				} while (bucle2 == true);
				break;
			case "2":
				System.out.println("Subes por el pasillo mientras a tu alrededor sigues viendo m�s celdas vacias."
						+ "\nAcabas llegando a una puerta con un extra�o s�mbolo resplandeciente");	
				do { //return bucle2
					bucle2 = true;
					System.out.println("\n�Que haces?"
							+ "\n1) Intentar abrir la puerta."
							+ "\n2) Tocar el s�mbolo."
							+ "\n3) Dar media vuelta");
					eleccion = teclado.nextLine();
					if (eleccion.equals("inventario"))
						P1.inventario();
					switch (eleccion) {
						case "1":
							System.out.println("Cuando tocas el pomo recibes una fuerte descarga el�ctrica. "+P2.nombre+" pierde 10 de vida.");
							P2.resta_vida_personaje(10);
							Final final1 = new Final(P1,P2);
							final1.comprobar_final();
							break;
						case "2":
							System.out.println("Cuando tocas el extra�o s�mbolo este se eleva en el aire y se divide en muchas letras."
									+ "\nLas letras se ordenan formando el siguiente texto:"
									+ "\nSi cruzas obtendr�s tu libertad, pero quizas dejes atras a alguien... y un tesoro."
									+ "\n�Saldr�s de aqui?");
							eleccion = teclado.nextLine();
							if (eleccion.equals("inventario"))
								P1.inventario();
							if (eleccion.equals("si")) {
								System.out.println(P2.nombre+" cruza la puerta y sale a la superficie."
										+ "\n�"+P2.nombre+" es libre!");
								P2.libre = true;
								bucle2 = false;
								Final final2 = new Final(P1,P2);
								final2.comprobar_final();
								break;
							}
						case "3":
							System.out.println("Das media vuelta y vuelves a donde empezaste.");
							bucle2 = false;
							break;
					}
				} while (bucle2 == true);
				break;
			case "3":
				do {
					bucle2 = true;
						System.out.print("Buscas por todas las celdas y");
							if (dibujocelda == false || P1.ObjPinturaBrillante != true) {
								System.out.print(" encuentras:");
								if (P1.ObjPinturaBrillante != true) {
									System.out.print("\nUn bote con una extra�a pintura que emite un ligero brillo.");
								}
								if (dibujocelda == false) {
									System.out.print("\nUn extra�o dibujo en la pared, parece estar hecho con la pintura brillante del bote.");
								}
							System.out.println("\n�Que haces?"
									+ "\n1) Salir");
							if (P1.ObjPinturaBrillante == false) {
								System.out.println("2) Coger el bote.");
							}
							if (dibujocelda == false){
								System.out.println("3) Acercarse al dibujo.");
							}
							eleccion = teclado.nextLine();
							if (eleccion.equals("inventario"))
								P1.inventario();
							switch (eleccion) {
							case "1":
								System.out.print("Vuelves a donde estabas.");
								bucle2 = false;
								break;
							case "2":
										System.out.println(P2.nombre+" ha conseguido un bote de pintura brillante.");
										P1.a�adir_objetos("Pintura Brillante");
										break;
							case "3":
								dibujocelda = true;
								System.out.println("Te acercas al dibujo de la pared. Levita enfrente tuya y se empieza a dividir, formando distintas palabras."
										+ "\nLas palabras se ordenan formando el siguiente mensaje:"
										+ "\nCuando no sepas por donde ir recuerda las siguientes direcciones, izquierda, recto, derecha, izquierda.");
								break;
							}
							} else {
								System.out.print(" no encuentras nada");
								break;
							}
						}while (bucle2 == true);
						break;
				} 
			} while (bucle == true);
		} 	
	}
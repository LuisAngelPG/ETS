package proyecto;

import java.util.Scanner;

public class Crearpj {

	Scanner teclado = new Scanner(System.in);
	Personaje personaje = new Personaje();
	
	boolean bucle;		
	String eleccion;
	String respuesta; 

	void crear_pj () {		
		do {	
			System.out.print("Introduce el nombre del personaje: ");
			String nombre1 = teclado.next();
			personaje.cambiar_nombre(nombre1);
			System.out.println("El nombre es: "+personaje.nombre+"\n�Es correcto? (S�/No)");
			respuesta = teclado.next();			
				if (respuesta.equals(("si")) || respuesta.equals(("s�")) || respuesta.equals(("Si")) || respuesta.equals(("S�"))) {
					bucle = false;	
			} else {
					if(respuesta.equals(("no")) || respuesta.equals(("No"))){
						bucle = true;
					} else {
						System.out.println("Introduce una respuesta v�lida.");
						bucle = true;
					}
			}
		} while (bucle == true);
	}
}
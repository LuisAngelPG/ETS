package proyecto;

import java.util.Scanner;

public class Personaje {
	
	Scanner teclado = new Scanner(System.in);
	
	String eleccion;
	String nombre;
	
	int VApersonaje = 100;
	int VMpersonaje = 100;
	
	boolean perdido;
	boolean libre;
	boolean muerto;
	
	//Inventario
	String descripcion, obj1, obj2;
	
	boolean ObjPiedra = false;
	Objeto Piedra = new Objeto();
	boolean ObjPinturaBrillante = false;
	Objeto PinturaBrillante = new Objeto();
	int pintura;
	boolean ObjGlifo = false;
	Objeto Glifo = new Objeto();
		

	void cambiar_nombre (String nombre) {
		this.nombre = nombre;	
	}
	
	void añadir_objetos (String objeto) {
		switch (objeto) {
		case "Piedra":
			ObjPiedra = true;
			descripcion = "Una simple piedra, tiene una forma completamente redonda";
			Piedra.añadir_objeto(objeto, descripcion);
			break;
			
		case "Pintura Brillante":
			ObjPinturaBrillante = true;
			descripcion = "Un bote de una extraña pintura que brilla.";
			PinturaBrillante.añadir_objeto(objeto, descripcion);
			break;
			
		case "Glifo":
			ObjGlifo = true;
			descripcion = "Una piedra a la que le has pintado un glifo con pintura brillante";
			Glifo.añadir_objeto(objeto, descripcion);
		}
	}
	
	void suma_vida_personaje (int suma) {
		if (VApersonaje < VMpersonaje) {
			VApersonaje = VApersonaje + suma;
			if (VApersonaje > VMpersonaje){
				int sobrante = VApersonaje - VMpersonaje;
				VApersonaje = VApersonaje - sobrante;
			}
			System.out.println("Vida de "+ nombre + ": " + VApersonaje);
			}
		else {
			System.out.println(nombre + " está al máximo de vida.");
		}
	}
	
	void resta_vida_personaje (int resta) {
		VApersonaje = VApersonaje - resta;
		if (VApersonaje <= 0) {
			muerto = true;
		}
		else 
		System.out.println("Vida de " + nombre + ": "+ VApersonaje);
	}
	
	void inventario () {
		System.out.println("Escribe el nombre del objeto para ver una descripción o combinarlo.");
		if (ObjPiedra == true) 
			System.out.println(Piedra.nombre);	
		if (ObjPinturaBrillante == true)
			System.out.println(PinturaBrillante.nombre);
		if (ObjGlifo == true)
			System.out.println(Glifo.nombre);
		eleccion = teclado.nextLine ();
		switch (eleccion) {
		case "Piedra":
			System.out.println(Piedra.descripcion);
			combinar(eleccion);
			break;
		case "Pintura Brillante":
			System.out.println(PinturaBrillante.descripcion);
			combinar(eleccion);
			break;
		case "Glifo":
			System.out.println(Glifo.descripcion);
			combinar(eleccion);
			break;
		}
	}
	
	void combinar (String obj1) {
		System.out.println("¿Combinar?");
		eleccion = teclado.nextLine ();
		if (eleccion.equals("si")) {
			System.out.println("¿Con que?");
			if (ObjPiedra == true && obj1 != "Piedra") 
				System.out.println(Piedra.nombre);	
			if (ObjPinturaBrillante == true && obj1 != "Pintura Brillante")
				System.out.println(PinturaBrillante.nombre);
			if (ObjGlifo == true && obj1 != "Glifo")
				System.out.println(Glifo.nombre);
			eleccion = teclado.nextLine ();
			obj2 = eleccion;
			combinar2 (obj1, obj2);
		}
	}
	
	void combinar2 (String obj1, String obj2) {
		if (obj1.equals("Piedra") || obj1.equals("PinturaBrillante") && obj2.equals("Piedra") || obj2.equals("Pinturabrillante"));
		ObjPiedra = false;
		ObjGlifo = true;
		añadir_objetos("Glifo");
		System.out.println("Con la pintura escribes el glifo en la piedra. \nObtienes Glifo");
		pintura = pintura - 1;
		if (pintura < 0) {
			System.out.println("Aun te sobra pintura.");
		} else {
			System.out.println("Te has quedado sin pintura.");
			ObjPinturaBrillante = false;
		}
	}
}
	
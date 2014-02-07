package proyecto;

import java.util.Scanner;

public class Final {
	
Scanner teclado = new Scanner(System.in);

String eleccion;
	
	public Personaje P1;
	public Personaje P2;
	
	public Final(Personaje P1, Personaje P2){
		this.P1 = P1;	
		this.P2 = P2;
	}
	
	public void comprobar_final() {
		if (P1.perdido == true && P2.perdido == true) {
			System.out.println("¡Estáis perdidos, y vagaréis en este sitio para siempre!\n¿Volver a empezar?");
			eleccion = teclado.nextLine();
			if (eleccion.equals("si")) {
				Game.main(null);
			}	
		}
		
		if (P1.muerto == true || P2.muerto == true) {
			if (P1.muerto == true)
				System.out.println("¡"+P1.nombre+" ha muerto! \nAhora "+P2.nombre+" no podra salir de aquí...");
			if (P2.muerto == true)
				System.out.println("¡"+P2.nombre+" ha muerto! \nAhora "+P1.nombre+" no podra salir de aquí...");
			System.out.println("¿Volver a empezar?");
			eleccion = teclado.nextLine();
			if (eleccion.equals("si")) {
				Game.main(null);
			}		
		}
	}
	
}

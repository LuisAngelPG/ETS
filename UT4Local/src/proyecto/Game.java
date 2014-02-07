package proyecto;


public class Game {

	public static void main(String[] args) {
		System.out.println("Bienvenido a Snifod, a continuación crearas al primer personaje");
		Crearpj P1 = new Crearpj ();
		P1.crear_pj();
		System.out.println("El primer personaje, "+P1.personaje.nombre+", se ha creado correctamente.");
		
		System.out.println("Ahora crea al segundo personaje.");
		Crearpj P2 = new Crearpj ();
		P2.crear_pj();
		System.out.println("El segundo personaje, "+P2.personaje.nombre+", se ha creado correctamente."
				+ "\nPara jugar tan solo tendras que hacer las elecciones que se te van preguntando, seleccionalas con el número que les corresponde."
				+ "\nAdemás siempre podras escribir inventario, sin mayúsculas, para ver los objetos que posees.");

		Celda c = new Celda(P1.personaje, P2.personaje);
		c.celda1();
		
		boolean prueba;
	}
}
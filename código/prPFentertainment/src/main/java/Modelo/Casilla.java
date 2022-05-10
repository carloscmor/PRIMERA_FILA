package Modelo;

public class Casilla {

	private String categoria;
	private int Posicion;

	public Casilla(String categ, int pos) {
		categoria = categ;
		Posicion = pos;

	}

	public String getCategoria() {
		return categoria;
	}

	public int getPosicion() {
		return Posicion;
	}

	public int getPregunta() {
		/*generar pregunta del fichero
		  dificultad ya elegida en el tablero*/
		return 0;
	}


}

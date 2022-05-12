package Modelo;

import java.util.StringJoiner;

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

	@Override
	public String toString() {
		return new StringJoiner(", ", "Casilla" + "[", "]")
				.add("categoria='" + categoria + "'")
				.add("Posicion=" + Posicion)
				.toString();
	}
}

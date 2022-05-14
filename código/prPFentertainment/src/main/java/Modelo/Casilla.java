package Modelo;

import java.util.StringJoiner;

public class Casilla {

	private String categoria;
	private int posicion;
	private Dificultad dificultad;
	private Pregunta pregunta;

	public Casilla(String categ, int pos, Dificultad d) {
		categoria = categ;
		posicion = pos;
		if(d != Dificultad.desafio) {
			dificultad = d;
		}else {
			if(pos  <  Tablero.getTamTableroDesafio() / 3) {
				dificultad = Dificultad.facil;
			}else if(pos  <  (Tablero.getTamTableroDesafio() / 3)*2) {
				dificultad = Dificultad.medio;
			}else {
				dificultad = Dificultad.dificil;
			}
		}
	}

	public String getCategoria() {
		return categoria;
	}

	public int getPosicion() {
		return posicion;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public Pregunta getPregunta() {
		/*abrir fichero de la dificultad de la casilla y generar pregunta aleatoria de la categoria de la casilla */
		// Pregunta pregunta = null;



		return pregunta;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", "Casilla" + "[", "]")
				.add("Categoria='" + categoria + "'")
				.add("Posicion=" + posicion)
				.toString();
	}

}

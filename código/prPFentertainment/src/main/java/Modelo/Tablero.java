package Modelo;

import java.util.ArrayList;

public class Tablero {

	String[] categorias = new String[] {"Geografia, Historia, Ciencia, Deporte"};
	private char modalidad;

	private ArrayList<Casilla> casillas; //Todas las casillas se almacenan en un arraylist
	private Dificultad dificultad; // Almacena la dificultad del tablero, que se pasar� al metodo que seleccione
								   // la pregunta del fichero de preguntas
	private static final int TAM_TABLERO=80; //Numero de casillas del tablero

	public Tablero(char d) { // para que el tablero se cree en modo desefaio
		iniciarTablero();
		modalidad = d;
	}
	
	public Tablero(char r, Dificultad d){ // para que el tablero se cree en modo partida rapida con la dificultad seleccionada
		iniciarTablero();
		modalidad = d;
		dificultad = d;

	public void setDificultad(Dificultad d) {
		dificultad = d;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	private String generarCategoria() {
		int pos = (int) (Math.random() * categorias.length);

		return categorias[pos];
	}

	public void iniciarTablero() { // hay que cambiarla para cada modalidad
		casillas = new ArrayList<>();

		for(int i=0; i<TAM_TABLERO; i++) {
			//Genero casilla con categoria aleatoria llamando a generarCategoria()
			casillas.add(new Casilla(generarCategoria(), i));
		}
	}

}
/* DUDAS:
- Como se selecciona la dificultad
- Las preguntas estan divididas en diferentes ficheros segun su dificultad
  o estan todas en un mismo fichero y tienen un atributo de dificultad.
- Cuantas categorias vamos a tener y si cada una tiene su dificultad o todas
pueden estar en diferentes dificultades.
-

*/

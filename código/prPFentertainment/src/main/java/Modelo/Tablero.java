package tablero;

import java.util.ArrayList;

public class Tablero {

	String[] categorias = new String[] {"Geografia, Historia, Ciencia, Deporte"};
	
	private ArrayList<Casilla> casillas; //Todas las casillas se almacenan en un arraylist
	private Dificultad dificultad; // Almacena la dificultad del tablero, que se pasará al metodo que seleccione
								   // la pregunta del fichero de preguntas
	private static final int TAM_TABLERO=80; //Numero de casillas del tablero
	
	public Tablero() {
		iniciarTablero();
		
	}
	
	private String generarCategoria() {
		int pos = (int) (Math.random() * categorias.length);
		
		return categorias[pos];
	}
	
	public void iniciarTablero() {
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
package Modelo;

import java.util.ArrayList;

public class Tablero {

	String[] categorias = new String[] {"Entertainment, Animals, Science, History, Sports, General"};

	private ArrayList<Casilla> casillas; //Todas las casillas se almacenan en un arraylist
	private Dificultad dificultad; 	/*Almacena la dificultad del tablero, que se pasar� al metodo que seleccione
									  la pregunta del fichero de preguntas*/
	private static final int TAM_TABLERO_RAPIDA=20; //Numero de casillas partida rapida
	private static final int TAM_TABLERO_DESAFIO=30; // Numero de casillas de tablero desafio

	public Tablero() {				//
		dificultad=Dificultad.desafio;
		iniciarTablero(dificultad);
	}
	
	public Tablero(Dificultad d) { // Para que el tablero se cree en modo partida rapida con la dificultad seleccionad
		dificultad = d;
		iniciarTablero(dificultad);
		
	}

	public void setDificultad(Dificultad d) {
		dificultad = d;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public static int getTamTableroDesafio() {
		return TAM_TABLERO_DESAFIO;
	}
	
	public static int getTamTableroRapida() {
		return TAM_TABLERO_RAPIDA;
	}
	private String generarCategoria() {
		int pos = (int) (Math.random() * categorias.length);

		return categorias[pos];
	}

	public void iniciarTablero(Dificultad d) { // hay que cambiarla para cada modalidad
		casillas = new ArrayList<>();

		if(d != Dificultad.desafio) {
			for(int i=0; i<TAM_TABLERO_RAPIDA; i++) {
				if(i==2 || i==6 || i==10 || i==14 || i==17) {
					casillas.add(new CasillaEspecial(generarCategoria(), i, d));
				}else {
				casillas.add(new Casilla(generarCategoria(), i, d));	// Creando casillas PR
				}
			}
		}else {
			for(int y=0; y<TAM_TABLERO_DESAFIO; y++) {
				if(y==3 || y==7 || y==11 || y==15 || y==18 || y==22 || y==26) {
					casillas.add(new Casilla(generarCategoria(), y, d));
				}else {
				casillas.add(new Casilla(generarCategoria(), y, d));	// Creando casillas Desafio
				}
			}
		}
	}

}

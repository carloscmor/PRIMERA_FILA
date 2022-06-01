package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {

	private static final String[] categorias = {"Entertainment", "Animals", "Science", "History", "Sports", "General"};
	public static final String[] dificultades = {"easy", "medium", "hard"};
	private static final String desafio = "desafio";
	
	private ArrayList<Casilla> casillas; //Todas las casillas se almacenan en un arraylist
	private String dificultad; 	/*Almacena la dificultad del tablero, que se pasar� al metodo que seleccione
									  la pregunta del fichero de preguntas*/
	private static final int TAM_TABLERO_RAPIDA=20; //Numero de casillas partida rapida
	private static final int TAM_TABLERO_DESAFIO=30; // Numero de casillas de tablero desafio

	public Tablero() {				//
		this(desafio);
	}
	
	public Tablero(String d) { // Para que el tablero se cree en modo partida rapida con la dificultad seleccionada
		dificultad = validaDificultad(d);
		iniciarTablero(dificultad);
	}

	private static String validaDificultad(String d) {
		String res = d;
		boolean valida = false;
		
		int i = 0;
		while(i < dificultades.length && !valida) {
			valida = dificultades[i].equalsIgnoreCase(d);
			i++;
		}
		if(!valida) {
			Random rnd = new Random();
			res = dificultades[rnd.nextInt(dificultades.length)];
		}
		return res;
	}
	
	public String getDificultad() {
		return dificultad;
	}

	public ArrayList<Casilla> getCasillas() {
		return casillas;
	}
	
	public static int getTamTableroDesafio() {
		return TAM_TABLERO_DESAFIO;
	}
	
	public static int getTamTableroRapida() {
		return TAM_TABLERO_RAPIDA;
	}
	private String generarCategoria() {
		Random rnd = new Random();
		int pos = rnd.nextInt(categorias.length);

		return categorias[pos];
	}

	public void iniciarTablero(String d) {
		casillas = new ArrayList<>();

		if(!d.equals(desafio)) {
			for(int i=0; i<TAM_TABLERO_RAPIDA; i++) {
				if(i==2 || i==6 || i==10 || i==14 || i==17) {
					casillas.add(new CasillaEspecial(generarCategoria(), i));
				}else {
				casillas.add(new Casilla(generarCategoria(), i, d));	// Creando casillas PR
				}
			}
		}else {
			for(int y=0; y<TAM_TABLERO_DESAFIO; y++) {
				if(y==3 || y==7 || y==11 || y==15 || y==18 || y==22 || y==26) {
					casillas.add(new CasillaEspecial(generarCategoria(), y));
				}else {
				casillas.add(new Casilla(generarCategoria(), y, d));	// Creando casillas Desafio
				}
			}
		}
	}
	
	public String toString() {
		return dificultad + casillas.toString();
	}
//Subirlo actualizado por cambiar dificultad a string
}
package Modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que representa el tablero de juego asociado a la {@link Partida}.
 */
public class Tablero {

//<<<<<<< Updated upstream
	/*private static final String[] categorias = {"Entertainment", "Animals", "Science", "History", "Sports", "General"};
	public static final String[] dificultades = {"easy", "medium", "hard"};
	private static final String desafio = "desafio";
	
	private ArrayList<Casilla> casillas; //Todas las casillas se almacenan en un arraylist
	private String dificultad; 	/*Almacena la dificultad del tablero, que se pasar� al metodo que seleccione*/
//=======
    /**
     * Categorías de las {@link Casilla casillas} para generar.
     */
    private static final String[] categorias = {"Entertainment", "Animals", "Science", "History", "Sports", "General"};

    /**
     * Posibles dificultades para las {@link Casilla casillas}.
     */
    private static final String[] dificultades = {"easy", "medium", "hard"};

    /**
     * Dificultad "extra" para el modo desafío (para comparar).
     */
    private static final String desafio = "desafio";

    /**
     * {@link Casilla Casillas} que forman el tablero.
     */
    private ArrayList<Casilla> casillas; //Todas las casillas se almacenan en un arraylist

    /**
     * Dificultad del tablero (cualquiera de {@link #dificultades} o <i>{@link #desafio desafío}</i>).
     */
    private final String dificultad; 	/*Almacena la dificultad del tablero, que se pasará al metodo que seleccione
>>>>>>> Stashed changes
									  la pregunta del fichero de preguntas*/
    /**
     * Tamaño de tablero de {@link Partida} rápida.
     */
    private static final int TAM_TABLERO_RAPIDA = 20; //Numero de casillas partida rapida

    /**
     * Tamaño de tablero de {@link Partida} <i>desafío</i>.
     */
    private static final int TAM_TABLERO_DESAFIO = 30; // Numero de casillas de tablero desafio

    /**
     * Crea un tablero <i>desafío</i>.
     */
    public Tablero() {
        this(desafio);
    }

    /**
     * Crea un tablero de la dificultad argumento.
     * @param d dificultad del tablero
     */
    public Tablero(String d) {
        dificultad = validaDificultad(d);
        iniciarTablero();
    }

    /**
     * Comprueba si la dificultad argumento es válida.
     * @param d dificultad a validar
     * @return {@code d} si es válida, o una aleatoria de {@link #dificultades} en caso contrario
     */
    private static String validaDificultad(String d) {
        String res = d;
        boolean valida = false;
        if (d.equalsIgnoreCase("desafio")) return desafio; //añadido para evitar cambiar Controlador
        int i = 0;
        while (i < dificultades.length && !valida) {
            valida = dificultades[i].equalsIgnoreCase(d);
            i++;
        }

        if (!valida) {
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

    /**
     * Genera una categoría aleatoria de {@link #categorias}.
     * @return la categoría generada.
     */
    private String generarCategoria() {
    	Random rnd = new Random();
		int pos = rnd.nextInt(categorias.length);
		Casilla ultima = null;
		if(casillas.size() != 0) {
			 ultima = casillas.get(casillas.size() - 1);
			while(ultima.getCategoria().equalsIgnoreCase(categorias[pos])) {
				pos = rnd.nextInt(categorias.length);
			}
		}

		return categorias[pos];
    }

    /**
     * Crea las casillas del tablero.
     */
    private void iniciarTablero() {
        casillas = new ArrayList<>();

        if (dificultad.equals(desafio)) {
            for (int y = 0; y < TAM_TABLERO_DESAFIO; y++) {
                if (y == 3 || y == 7 || y == 11 || y == 15 || y == 18 || y == 22 || y == 26)
                    casillas.add(new CasillaEspecial(generarCategoria(), y));
                else casillas.add(new Casilla(generarCategoria(), y, dificultad));    // Creando casillas Desafio
            }
        } else {
            for (int i = 0; i < TAM_TABLERO_RAPIDA; i++) {
                if (i == 2 || i == 6 || i == 10 || i == 14 || i == 17)
                    casillas.add(new CasillaEspecial(generarCategoria(), i));
                else casillas.add(new Casilla(generarCategoria(), i, dificultad));    // Creando casillas PR
            }
        }
    }

    public String toString() {
        return dificultad + casillas.toString();
    }
}
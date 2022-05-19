import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Casilla {

	private String categoria;
	private int posicion;
	private String dificultad;
	private Pregunta pregunta;
	private int rn; //Atributo para no repetir la misma pregunta si cae en la misma casilla por efectos de casilla especial

	//Constructor de la clase, se le pasa la categoria, la posicion en el "tablero" y la dificultad
	public Casilla(String categ, int pos, String d) {
		categoria = categ;
		posicion = pos;
		Random rdn = new Random();
		rn = rdn.nextInt(59);
		if (!d.equals("desafio")) {
			dificultad = d;
		} else {
			if (pos < Tablero.getTamTableroDesafio() / 3) {
				dificultad = "easy";
			} else if (pos < (Tablero.getTamTableroDesafio() / 3) * 2) {
				dificultad = "medium";
			} else {
				dificultad = "hard";
			}
		}

	}

	//Devuelve una pregunta en forma de array despues del split
	private String[] leerDeFichero(String nfich) {
		String[] res = new String[6];

		List<String> lc = null;
		try {
			lc = Files.readAllLines(Paths.get(nfich));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (Scanner sc = new Scanner(new File(nfich))) {
			String linea = "";
			int i = (rn % lc.size());
			while (sc.hasNextLine() && i > 0) {
				linea = sc.nextLine();
				--i;
			}
			res = linea.split("[;]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		rn = (rn + 1) % lc.size();
		return res;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getPosicion() {
		return posicion;
	}

	public String getDificultad() {
		return dificultad;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	//Genera una nueva pregunta de fichero para la casilla cada vez que se llama
	//La pregunta solo se genera despues de llamar a este metodo por primera vez
	public Pregunta generarPregunta() {
		String[] pr = null;

		switch (dificultad) {
		case "easy":
			pr = leerDeFichero("api" + categoria + "F.txt");
			break;
		case "medium":
			pr = leerDeFichero("api" + categoria + "M.txt");
			break;
		case "hard":
			pr = leerDeFichero("api" + categoria + "D.txt");
			break;
		}

		//formato de la pregunta: categoria ; tipo ; dificultad ; pregunta ; respuesta correcta ; respuesta incorrecta (puede ser una lista si la respuesta es de multiple eleccion
				//			     	  0	       1	 	 2	     	 3	             4					5
				//indices del array despues del split

		pregunta = pr[1].equals("multiple") ? new Pregunta(pr[0], pr[3], pr[4], new HashSet<String>()) : new Pregunta(pr[0], pr[3], pr[4]); //Falta rellenar el Set con las incorrectas

		return pregunta;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", "Casilla" + "[", "]").add("Categoria='" + categoria + "'")
				.add("Posicion=" + posicion).toString();
	}

}

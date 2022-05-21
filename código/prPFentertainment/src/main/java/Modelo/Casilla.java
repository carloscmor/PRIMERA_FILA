package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Casilla {

	private static final Map<String, Integer> tiempos = Map.of("easy", 20, "medium", 30, "hard", 40);
	//según la dificultad, los tiempos de espera varían 
	
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
		pregunta = generarPregunta();
	}

	//Devuelve una pregunta en forma de array despues del split
	private String[] leerDeFichero(String nfich) throws IOException {
		String[] res = new String[6];

		List<String> lc = Files.readAllLines(Paths.get(nfich));

		try (Scanner sc = new Scanner(new File(nfich))) {
			String linea = "";
			int i = (rn % lc.size());
			while (sc.hasNextLine() && i > 0) {
				linea = sc.nextLine();
				--i;
			}
			res = linea.split("[;]");
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

	private Set<String> procesarIncorrectas(String linea){
		//['The Little Prince', 'Harry Potter and the Philosopher's Stone', 'The Da Vinci Code']
		Set<String> res = new TreeSet<>();
		if(linea.length() > 1) linea = linea.substring(2, linea.length()-2);
		String[] ops = linea.split("', '");
		for(String str : ops) {
			res.add(str);
		}
		return res;
	}
	
	//Genera una nueva pregunta de fichero para la casilla cada vez que se llama
	//La pregunta solo se genera despues de llamar a este metodo por primera vez
	public Pregunta generarPregunta() {
		String[] pr = null;

		do {
			try {
				switch (dificultad) {
				case "easy":
					pr = leerDeFichero("src\\preguntas\\api" + categoria + "F.txt");
					break;
				case "medium":
					pr = leerDeFichero("src\\preguntas\\api" + categoria + "M.txt");
					break;
				case "hard":
					pr = leerDeFichero("src\\preguntas\\api" + categoria + "D.txt");
					break;
				}
				
			}catch (Exception e) { //Fichero por defecto, en caso de no encontrar el requerido.
				categoria = "general"; //como es error nuestro por no disponer de esas preguntas, lo ponemos más fácil
				dificultad = "easy";
			}
			
		} while(pr == null || pr.length < 5); //Si hay una pregunta con formato erróneo, es descartada y otra es seleccionada.
		//formato de la pregunta: categoria ; tipo ; dificultad ; pregunta ; respuesta correcta ; respuesta/s incorrecta (puede ser una lista si la respuesta es de multiple eleccion
				//    	            0	       1	 2	            3	             4			    5
				//indices del array despues del split
		
		pregunta = pr[1].equals("multiple") ? new Pregunta(pr[0], pr[3], pr[4], procesarIncorrectas(pr[5]), tiempos.get(pr[2])) 
			: new Pregunta(pr[0], pr[3], pr[4], tiempos.get(pr[2])); //Falta rellenar el Set con las incorrectas
		return pregunta;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", "Casilla" + "[", "]").add("Categoria='" + categoria + "'")
				.add("Posicion=" + posicion).toString();
	}

}

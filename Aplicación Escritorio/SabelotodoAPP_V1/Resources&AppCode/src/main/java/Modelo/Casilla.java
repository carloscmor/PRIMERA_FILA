package Modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Casilla {
    /**
     * Según la dificultad, los tiempos de espera varían.
     */
    private static final Map<String, Integer> tiempos = Map.of(
            "easy", 20, "medium", 30, "hard", 40);

    private String categoria;
    private final int posicion;
    private String dificultad;
    private Pregunta pregunta;

    /**
     * Atributo para intentar no repetir la misma pregunta si cae en la misma casilla por efectos de casilla especial.
     */
    private int rn;

    /**
     * Constructor de la clase.
     * @param categ la categoría de la casilla.
     * @param pos la posición en el tablero
     * @param d la dificultad
     */
    public Casilla(String categ, int pos, String d) {
        categoria = categ;
        posicion = pos;
        Random rdn = new Random();
        rn = rdn.nextInt(59);

        if (d.equals("desafio")) {
            if (pos < Tablero.getTamTableroDesafio() / 3) dificultad = "easy";
            else if (pos < (Tablero.getTamTableroDesafio() / 3) * 2) dificultad = "medium";
            else dificultad = "hard";
        } else dificultad = d;
        generarPregunta(); //inicial, después otras se generan.
    }

    /**
     * @param nfich nombre del fichero a leer
     * @return una pregunta en forma de array después del {@code split}.
     */
    private String[] leerDeFichero(String nfich) throws IOException {
        String[] res;

        List<String> lc = Files.readAllLines(Paths.get(nfich));

        res = lc.get((rn % lc.size())).split(";");

        rn = (rn + 1) % lc.size();
        return res;
    }


    public String getCategoria() {
        return categoria;
    }

    int getPosicion() {
        return posicion;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    /**
     * @param linea línea del fichero que representa la pregunta
     * @return las opciones incorrectas de la pregunta
     */
    private Set<String> procesarIncorrectas(String linea) {
        //Ejemplo: ['The Little Prince', 'Harry Potter and the Philosopher's Stone', 'The Da Vinci Code']
        if (linea.length() > 1) linea = linea.substring(2, linea.length() - 2);
        String[] ops = linea.split("', '");
        return new TreeSet<>(Arrays.asList(ops));
    }

    /**
     * Genera una nueva pregunta de fichero para la casilla cada vez que se llama. <br>
     * La pregunta solo se genera después de llamar a este método por primera vez. <br>
     * En el caso de que no se pueda crear la pregunta, se vuelve a ejecutar este método.
     */
    void generarPregunta() {
        String[] pr = null;
        do {
            try {
                if (dificultad.equalsIgnoreCase("easy"))
                    pr = leerDeFichero("src\\preguntas\\api" + categoria + "F.txt");
                else if (dificultad.equalsIgnoreCase("hard"))
                    pr = leerDeFichero("src\\preguntas\\api" + categoria + "D.txt");
                else if (dificultad.equalsIgnoreCase("medium"))
                    pr = leerDeFichero("src\\preguntas\\api" + categoria + "M.txt");
                else {
                    pr = leerDeFichero("src\\preguntas\\apiGeneralF.txt");
                    categoria = "general";
                    dificultad = "easy";
                }
            } catch (Exception e) { //Fichero por defecto, en caso de no encontrar el requerido.
                categoria = "general"; //como es error nuestro por no disponer de esas preguntas, lo ponemos más fácil
                dificultad = "easy";
            }

        } while (pr == null || pr.length < 4); //Si hay una pregunta con formato erróneo, es descartada y otra es seleccionada.
        //formato de la pregunta: categoria ; tipo ; dificultad ; pregunta ; respuesta correcta ; respuesta/s incorrecta (puede ser una lista si la respuesta es de multiple eleccion
        //    	            0	       1	 2	            3	             4			    5
        //indices del array despues del split
        try {
            pregunta = pr[1].equals("multiple") ?
                    new Pregunta(pr[0], pr[3], pr[4], procesarIncorrectas(pr[5]), tiempos.get(pr[2].toLowerCase())) :
                    new Pregunta(pr[0], pr[3], pr[4], tiempos.get(pr[2].toLowerCase()));
        } catch (IndexOutOfBoundsException e) {
            generarPregunta();
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Casilla" + "[", "]")
                .add("Categoria = '" + categoria + "'")
                .add("Posicion = " + posicion)
                .toString();
    }

}

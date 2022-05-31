package Modelo;

import java.util.*;

/**
 * Clase que representa cada pregunta del juego.<br>
 * Consta de la {@link #categoria categoría}, la {@link #pregunta},
 * las {@link #incorrectas opciones} (con la {@link #solucion solución} aparte),
 * su {@link #respuesta} (en caso de haber sido {@link #responderPregunta(String) respondida}),
 * si ha sido {@link #acertada}, y su {@link #temporizador} asociado.
 */
public class Pregunta {
    public static final String verdadero = "TRUE", falso = "FALSE";
    private final String categoria;
    private final String pregunta;
    private final String solucion;
    private final Set<String> incorrectas;

    private boolean acertada;
    private String respuesta;
    private final Temporizador temporizador;

    /**
     * Constructor para preguntas de multiple opción. <br>
     * Se pasan como parámetro por orden los elementos como vienen en el json, después de hacerle el {@code split}. <br>
     * <br><b>Nota: </b><u>Tipo</u> y <u>dificultad</u> no se pasan como parámetro porque no nos hacen falta para
     * la clase, ya que solo los usaríamos para elegir el fichero y la pregunta a crear.
     *
     * @param categoria   La categoría de la pregunta.
     * @param pregunta    La pregunta en sí como {@link String}.
     * @param solucion    La solución a la pregunta como {@link String}.
     * @param incorrectas Las opciones incorrectas de la pregunta como {@link Set}{@code <}{@link String}{@code >}.
     * @param tiempo      Tiempo del temporizador para responder la pregunta (depende de la dificultad de la {@link Casilla}).
     */
    public Pregunta(String categoria, String pregunta, String solucion, Set<String> incorrectas, int tiempo) {
        this.categoria = categoria;
        this.pregunta = pregunta;
        this.solucion = solucion;
        this.incorrectas = incorrectas;

        acertada = false;
        respuesta = null;
        temporizador = new Temporizador(tiempo); //dependiendo de la dificultad de la casilla
    }

    /**
     * Constructor para preguntas de verdadero o falso. <br>
     * En este no se pasan las opciones ya que siempre es o verdadero o falso.
     * <br><br>Véase {@link #Pregunta(String, String, String, Set, int) constructor para preguntas generales}.
     */
    public Pregunta(String categoria, String pregunta, String solucion, int tiempo) {
        this(categoria, pregunta, solucion, null, tiempo);
    }

    /**
     * @return el {@link #temporizador} asociado a la pregunta
     */
    public Temporizador getTemporizador() {
        return temporizador;
    }

    /**
     * @return la {@link #categoria categoría} de la pregunta
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @return la {@link #pregunta} en sí
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * @return la {@link #solucion solución} a la pregunta, es decir, la opción correcta
     */
    public String getSolucion() {
        return solucion;
    }

    /**
     * @return las opciones que no son correctas
     */
    public Set<String> getIncorrectas() {
        return incorrectas;
    }

    public boolean getAcertada() {
        return acertada;
    }

    /**
     * @return {@code true} si la pregunta ha sido respondida
     */
    public boolean isRespondida() {
        return respuesta != null;
    }

    /**
     * Procesa la respuesta del usuario, comprobando si el valor del temporizador es válido.
     *
     * @param resp la respuesta del usuario
     * @return {@code 0} en caso de que se procese la respuesta correctamente,
     * y {@code -1} si se agotó el {@link #temporizador temporizador}
     */
    public int responderPregunta(String resp) {
        int code = -1;
        if (!temporizador.esFinal()) {
            respuesta = resp;
            acertada = validar(respuesta);
            code = 0;
        }
        return code;
    }

    /**
     * Valida la respuesta elegida -> es usuario el método responder
     *
     * @param resp la respuesta del usuario
     * @return {@code true} si la respuesta es correcta (coincide con la
     * {@link #solucion solución}); {@code false} en otro caso
     */
    public boolean validar(String resp) {
        return solucion.equalsIgnoreCase(resp);
    }

    /**
     * Inicia el temporizador.
     */
    public void iniciar() {
        temporizador.start();
    }

    /**
     * Para el temporizador.
     */
    public void parar() {
        temporizador.parar();
    }

    /**
     * @return {@code true} si el temporizador se ha agotado; {@code false} en otro caso
     */
    public boolean agotado() {
        return temporizador.getResultado();
    }

    /**
     * Espera a que el temporizador finalice.
     */
    public void esperar() {
        try {
            temporizador.join();
        } catch (InterruptedException e) {
            //System.err.println("<!> Problema con el temporizador."); todo -> En el modelo no se puede realizar E/S.
            System.exit(-1);
        }
    }

    /**
     * Mezcla las opciones {@link #incorrectas} con la correcta,
     * y las devuelve (o {@link #verdadero} y {@link #falso} si procede).
     *
     * @return todas las opciones a la pregunta (incluyendo la {@link #solucion solución}) mezcladas
     */
    public List<String> getOpciones() {
        List<String> res = new ArrayList<>();
        if (incorrectas != null) {
            res.addAll(incorrectas);
            res.add(solucion);
        } else {
            res.add(verdadero);
            res.add(falso);
        }
        Collections.shuffle(res);
        return res;
    }

    /**
     * Muestra la {@link #pregunta} junto con sus opciones tabuladas e indexadas como a), b), etc.
     *
     * @return la representación de {@code this} como {@link String}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(pregunta.toUpperCase() + "\n");
        List<String> opciones = getOpciones();

        int i = 'a';
        for (String op : opciones) {
            char c = (char) i++;
            sb.append("\t").append(c).append(") ").append(op).append("\n");
        }
        return sb.toString();
    }
}

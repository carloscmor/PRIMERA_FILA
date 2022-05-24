package Modelo;
import java.util.*;

public class Pregunta {
	private static final String verdadero = "TRUE";
	public static final String falso = "FALSE";
	private final String categoria;
	private final String pregunta;
	private final String solucion;
	private final Set<String> incorrectas;

	private boolean acertada;
	private String respuesta;
	private final Temporizador temporizador;

	/**
	 * Constructor para preguntas de multiple opción. <br>
	 * Se pasan como parámetro por orden los elementos como vienen en el json, después de hacerle el split. <br>
	 * Tipo y dificultad no se pasan como parámetro porque no nos hace falta para la clase, ya que solo
	 * lo usaríamos para elegir el fichero y la pregunta a crear.
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
	 */
	public Pregunta(String categoria, String pregunta, String solucion, int tiempo) {
		this(categoria, pregunta, solucion, null, tiempo);
	}

	/**
	 * @return el temporizador
	 */
	public Temporizador getTemporizador() {
		return temporizador;
	}

	/**
	 * Devuelve la categoria de la pregunta
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Devuelve la pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * Devuelve la solucion a la pregunta, es decir, la opcion correcta
	 */
	public String getSolucion() {
		return solucion;
	}

	/**
	 * Devuelve las opciones que no son correctas
	 */
	public Set<String> getIncorrectas() {
		return incorrectas;
	}

	public boolean getAcertada() {
		return acertada;
	}

	/**
	 * Devuelve si la pregunta ha sido respondida
	 */
	public boolean isRespondida() {
		return respuesta == null;
	}

	public int responderPregunta(String resp) {
		if(!temporizador.esFinal()) {
			respuesta = resp;
			acertada = validar(respuesta);
		}
		
		return temporizador.getTiempo();
	}

	/**
	 * Valida la respuesta elegida -> es usuario el método responder
	 */
	public boolean validar(String resp) {
		return solucion.equalsIgnoreCase(resp);
	}

	public void iniciar(){
		temporizador.start();
	}

	public void parar(){
		temporizador.parar();
	}

	public boolean agotado(){
		return temporizador.getResultado();
	}

	public void esperar(){
		try {
			temporizador.join();
		} catch (InterruptedException e) {
			System.err.println("<!> Problema con el temporizador.");
			System.exit(-1);
		}
	}

	public List<String> getOpciones(){
		List<String> res = new ArrayList<>();
		if(incorrectas != null) {
			res.addAll(incorrectas);
			res.add(solucion);
		}else {
			res.add(verdadero);
			res.add(falso);
		}
		Collections.shuffle(res);
		return res;
	}

	 @Override
	public String toString(){
		StringBuilder sb = new StringBuilder(pregunta.toUpperCase() + "\n");
		List<String> opciones = getOpciones();

		int i = 'a';
			for(String op : opciones){
				char c = (char) i++;
				sb.append("\t").append(c).append(") ").append(op).append("\n");
			}
		return sb.toString();
	}


}

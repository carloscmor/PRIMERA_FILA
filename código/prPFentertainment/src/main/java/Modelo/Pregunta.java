import java.util.Set;

public class Pregunta {
	private String categoria;
	private String pregunta;
	private String solucion;
	private Set<String> incorrectas;

	//Constructor para preguntas de multiple opcion
	//Se pasan como parametro por orden los elementos como vienen en el json, depues de hacerle el split
	//Tipo y dificultad no se pasan como parametro porque no nos hace falta para la clase, ya que solo
	//lo usariamos para elegir el fichero y la pregunta a crear
	public Pregunta(String categoria, String pregunta, String solucion, Set<String> incorrectas) {
		this.categoria = categoria;
		this.pregunta = pregunta;
		this.solucion = solucion;
		this.incorrectas = incorrectas;
	}

	//Constructor para preguntas de verdadero o falso
	//En este no se pasan las opciones ya que siempre es o verdadero o falso
	public Pregunta(String categoria, String pregunta, String solucion) {
		this.categoria = categoria;
		this.pregunta = pregunta;
		this.solucion = solucion;
		this.incorrectas = null;
	}

	//Devuelve la categoria de la pregunta
	public String getCategoria() {
		return categoria;
	}
	
	//Devuelve la pregunta
	public String getPregunta() {
		return pregunta;
	}

	//Devuelve la solucion a la pregunta, es decir, la opcion correcta
	public String getSolucion() {
		return solucion;
	}
	
	//Devuelve las opciones que no son correctas
	public Set<String> getIncorrectas() {
		return incorrectas;
	}

	//Valida la respuesta elegida
	public boolean validar(String resp) {
		return solucion.equalsIgnoreCase(resp);
	}
	
	/*
	 @Override
	public String toString(){
		StringBuilder sb = new StringBuilder(pregunta.toUpperCase() + "\n");
		int i = (int) 'a';
			for(String op : opciones){
				char c = (char) i++;
				sb.append("\t" + c + ") " + op + "\n");
			}
		return sb.toString();
	}
	 */

}
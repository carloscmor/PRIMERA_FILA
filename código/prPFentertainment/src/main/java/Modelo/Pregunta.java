package Modelo;

import java.util.Set;

public class Pregunta {
	private String categoria;
	private String pregunta;
	private String solucion;
	private String dificultad;
	private Set<String> opciones;

	public Pregunta(String pregunta, Set<String> opciones, String solucion) {
		this.pregunta = pregunta;
		this.solucion = solucion;
		this.opciones = opciones;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getPregunta() {
		return pregunta;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public Set<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(Set<String> opciones) {
		this.opciones = opciones;
	}

	public boolean validar(String resp) {
		return solucion.equalsIgnoreCase(resp);
	}

	public String getSolucion(){return solucion;}

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

}

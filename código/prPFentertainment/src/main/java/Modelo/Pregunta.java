package Modelo;

import java.util.Set;

public class Pregunta {
	public Pregunta(String pregunta, Set<String> opciones, String solucion) {
		this.pregunta = pregunta;
		this.solucion = solucion;
		this.opciones = opciones;
	}
	String categoria;
	String pregunta;
	String solucion;
	String dificultad;
	Set<String> opciones;
	public String getCategoria() {
		return categoria;
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
	
}

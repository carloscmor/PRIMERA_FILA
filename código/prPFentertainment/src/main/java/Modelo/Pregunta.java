package Modelo;

public class Pregunta {
	public Pregunta(String pregunta, String solucion) {
		this.pregunta = pregunta;
		this.solucion = solucion;
	}
	String categoria;
	String pregunta;
	String solucion;
	String dificultad;
	String opciones;
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
	public String getOpciones() {
		return opciones;
	}
	public void setOpciones(String opciones) {
		this.opciones = opciones;
	}
	
	public boolean validar(String resp) {
		return solucion.equals(resp);
	}
	
}

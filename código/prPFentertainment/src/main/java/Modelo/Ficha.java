package Modelo;

public class Ficha {

	private int posicion;
	
	public Ficha() {
		this(0);
	}
	
	public Ficha(int pos) {
		posicion = pos;
	}
	
	public void SetPosicion(int pos) {
		posicion = pos;
	}
	
	public int getPosicion() {
		return posicion;
	}
	
	public void Avanzar() {
		posicion++;
	}
	
	public void Retroceder() {
		posicion--;
	}
	
/* Revisar y mejorar*/	
}

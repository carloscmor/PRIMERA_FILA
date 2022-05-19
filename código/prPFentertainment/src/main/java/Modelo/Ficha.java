package Modelo;

public class Ficha {

	private int posicion;
	
	public int getPosicion() {
		return posicion;
	}
	
	public void Avanzar() {
		posicion++;
	}
	
	public void Retroceder() {
		posicion--;
	}
	
	@Override
	public String toString() {
		return "Posicion de la ficha: "+ getPosicion();
	}

	
}

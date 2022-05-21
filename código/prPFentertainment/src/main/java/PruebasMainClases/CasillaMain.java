package PruebasMainClases;

import Modelo.Casilla;

public class CasillaMain {

	public static void main(String[] args) {
		Casilla c = new Casilla("science", 2, ""); //no existe el fichero -> Hemos tratado la excepción
		System.out.println(c);
		System.out.println(c.getPregunta());
	}

}

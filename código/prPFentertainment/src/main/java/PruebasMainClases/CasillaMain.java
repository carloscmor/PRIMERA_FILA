package PruebasMainClases;

import Modelo.Casilla;

public class CasillaMain {

	public static void main(String[] args) {
		Casilla c = new Casilla("sports", 2, "easy");
		System.out.println(c);
		System.out.println(c.getPregunta());
	}

}

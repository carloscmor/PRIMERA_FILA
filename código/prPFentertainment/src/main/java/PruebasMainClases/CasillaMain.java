package PruebasMainClases;

import Modelo.Casilla;

public class CasillaMain {

	public static void main(String[] args) {
		Casilla c = new Casilla("GeneraL", 2, "hard");
		System.out.println(c);
		System.out.println(c.getPregunta());
	}

}

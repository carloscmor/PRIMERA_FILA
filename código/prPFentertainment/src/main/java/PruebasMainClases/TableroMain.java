package PruebasMainClases;

import Modelo.Casilla;
import Modelo.Tablero;

public class TableroMain {

	public static void main(String[] args) {
		Tablero t = new Tablero("facil");
		
		System.out.println(t);
		
		for(Casilla c : t.getCasillas()) {
			System.out.println(c.getPregunta());
		}
		
	}

}

package Modelo;

import java.util.Random;

public class Dado {
	private final Random rd; // Clase que proporciona el siguiente resultado.
	private int valor; // Valor actual del dado (cara superior).

	public Dado() {
		rd = new Random();
		tirar();
	}

	// Devuelve el valor actual del dado. ¡Depuración!
	public int valor() {
		return valor;
	}

	// Cambia el valor del dado. ¡Depuración!
	public void asignar(int num) {
		valor = num;
	}

	// Asigna a valor el siguiente resultado.
	public int tirar() {
		valor = rd.nextInt(6) + 1;
		return valor;
	}

	@Override
	public String toString() {
		return "[" + valor + "]";
	}
}
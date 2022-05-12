package Modelo;

import java.util.Random;
import java.util.StringJoiner;

public class Dado {
	private Random rd; // Clase que proporciona el siguiente resultado.
	private int valor; // Valor actual del dado (cara superior).

	public Dado() {
		rd = new Random();
		valor = 0; // 0 indica un dado sin lanzar. ¿Cambiar a aleatorio?
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
	public void tirar() {
		valor = rd.nextInt(6) + 1;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", "Dado" + "[", "]")
				.add("Variable Random = " + rd)
				.add("valor = " + valor)
				.toString();
	}
}
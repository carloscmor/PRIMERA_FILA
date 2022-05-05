package Modelo;

import java.util.Random;

public class Dado {
	private Random rd;
	private int valor;

	public Dado() {
		rd = new Random();
		valor = 0;
	}

	public int valor() {
		return valor;
	}

	public void asignar(int num) {
		valor = num;
	}

	public void tirar() {
		valor = rd.nextInt(6) + 1;
	}
}
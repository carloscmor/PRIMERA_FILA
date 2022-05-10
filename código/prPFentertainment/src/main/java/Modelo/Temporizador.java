package Modelo;

public class Temporizador extends Thread {

	private int inicio;
	private int tiempo;
	private boolean agotado;
	private boolean respondido;
	public boolean fin;

	//Constructor
	public Temporizador(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Valor incorrecto.");
		}
		this.inicio = n;
		this.tiempo = n;
		agotado = false;
		respondido = false;
		fin = false;
	}

	//Devuelve si la pregunta ha sido respondida a no.
	public boolean getRespondido() {
		return respondido;
	}

	//Devuelve el estado del temporizador, es decir, si esta agotado o no
	public boolean getResultado() {
		return this.agotado;
	}

	//Devuelve la cantidad de tiempo del temporizador. No usar mientras el temporizador esta corriendo
	public int getTiempo() {
		return tiempo;
	}

	//Para el temporizador
	public void parar() {
		fin = true;
	}

	//Reinicia el temporizador, reinicializando las variables
	public void reiniciar() {
		this.tiempo = inicio + 1;
		this.agotado = false;
		this.respondido = false;
	}

	//Inicia el temporizador
	public void run() {
		while (!fin) {
			if (tiempo >= 0)
				System.out.println(tiempo);
			if (tiempo <= 0)
				agotado = true;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tiempo--;

		}
	}
}
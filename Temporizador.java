package TemporizadorPruebaSemaforo;

public class Temporizador extends Thread {

	private int inicio;
	private int tiempo;
	private boolean agotado;
	private boolean respondido;
	public boolean fin;

	public Temporizador(int n) {
		this.inicio = n;
		this.tiempo = n;
		agotado = false;
		respondido = false;
		fin = false;
	}

	public boolean getResultado() {
		return this.agotado;
	}

	public void parar() {
		fin = true;
	}

	public void reiniciar() {
		this.tiempo = inicio + 1;
		this.agotado = false;
		this.respondido = false;
	}

	public void run() {
		while (!fin) {
			if (tiempo >= 0)
				System.out.println(tiempo);
			if (tiempo <= 0)
				agotado = true;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tiempo--;

		}
	}
}
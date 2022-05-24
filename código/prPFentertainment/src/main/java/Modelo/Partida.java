package Modelo;

import java.util.StringJoiner;

public class Partida {

	private static final int[] vidas= {5,3};
	public enum tipo_partida {desafio, rapida}

	private final Tablero tablero;
	private final Jugador jugador;

	private boolean empezada = false, terminada;
	private final Dado dado;
	private final Ficha ficha;

	public Partida(String nombreJugador) { //Partida desafío
		this(nombreJugador, tipo_partida.desafio, "desafio");
	}

	public Partida(String nombreJugador, tipo_partida tipo, String d) {
		jugador = new Jugador(nombreJugador, vidas[tipo.ordinal()]);
		if (tipo == tipo_partida.desafio) tablero = new Tablero();
		else tablero = new Tablero(d);
		dado = new Dado();
		ficha = new Ficha();
	}

	public Dado getDado() {
		return dado;
	}

	public boolean isTerminada() {
		return terminada;
	}

	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}

	public static int[] getVidas() {
		return vidas;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public boolean isEmpezada() {
		return empezada;
	}

	public Ficha getFicha() {
		return ficha;
	}

    public void empezar() {
    	empezada = true;
    }
    public void terminar() {
    	//todo fin
		terminada = true;
    }

    public Tablero getTablero() {
    	return tablero;
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n", "Partida (Desafío) " + "[\n", "]")
                .add("\tTablero = {" + tablero + "}")
                .add("\tJugador = {" + jugador + "}")
                .toString();
    }
}

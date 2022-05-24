package Modelo;

import java.util.StringJoiner;

public class Partida {

	private static final int[] vidas= {5,3};
	public static enum tipo_partida {desafio, rapida};

	private final Tablero tablero;
	private final Jugador jugador;

	private boolean empezada, terminada;
	private Dado dado;
	private Ficha ficha;

	public Partida(String nombreJugador) { //Partida desafío
		this(nombreJugador, tipo_partida.desafio, "desafio");
	}

	public Partida(String nombreJugador, tipo_partida tipo, String d) {
		jugador = new Jugador(nombreJugador, vidas[tipo.ordinal()]);
		if (tipo == tipo_partida.desafio) {
			tablero = new Tablero();
		} else {
			tablero = new Tablero(d);
		}
		dado = new Dado();
		ficha = new Ficha();
	}

	public Dado getDado() {
		return dado;
	}

	public boolean isTerminada() {
		return terminada;
	}

	public void avanzarFicha() {
		int cont=0;
		dado.tirar();
		while(ficha.getPosicion() < tablero.getCasillas().size()-1 
				&& cont<dado.valor()) {
			ficha.Avanzar();
			cont++;
		}
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
    	while(!terminada); //por completar
    }
    public void terminar() {
    	//fin
    }

    public Tablero getTablero() {
    	return tablero;
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n", "Partida (Desaf�o) " + "[\n", "]")
                .add("\tTablero = {" + tablero + "}")
                .add("\tJugador = {" + jugador + "}")
                .toString();
    }
}
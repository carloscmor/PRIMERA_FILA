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

	public Partida(String nombreJugador, String d) {
		this(nombreJugador, tipo_partida.rapida, d);
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
	
	public void avanzarFicha(int n) {
		int cont = 0;
		while(cont++ < n && 
				ficha.getPosicion() < tablero.getCasillas().size()) {
			ficha.Avanzar();
		}
	}
	
	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
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
    	terminada = true;
    }

    public Tablero getTablero() {
    	return tablero;
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder(jugador.toString());
    	sb.append(tablero.getDificultad());
    	
    	int cont = 0; int linea = 1;
    	int posActual = ficha.getPosicion();
    	
    	sb.append("\nPOSICION -> " + posActual + "\n\n");
    	
        for(Casilla c : tablero.getCasillas()) {
        	sb.append(c);
        	if(cont == posActual) sb.append(" *F* ");
        	if(cont % linea == 0) sb.append("\n");
        	
        	cont++;
        }
        return sb.toString();
    }
}
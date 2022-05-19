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
	
	public Partida(String nombreJugador) {
		this(nombreJugador, tipo_partida.desafio, Dificultad.desafio);
	}
	
	public Partida(String nombreJugador, tipo_partida tipo, Dificultad d) {
		jugador = new Jugador(nombreJugador, vidas[tipo.ordinal()]);
		if(tipo == tipo_partida.desafio) {
			tablero = new Tablero();
		}else {
			tablero = new Tablero(d);
		}
		dado = new Dado();
		ficha = new Ficha();
	}
	
	
	
    public void empezar() {
    	while(!terminada);
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

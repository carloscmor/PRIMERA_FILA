package Modelo;

import java.util.StringJoiner;

public class PartidaDesafio implements Partida{
	private final Tablero t;
	private final Jugador j;

	public PartidaDesafio() {
        t = new Tablero();
        j = new Jugador("Jugador 1", 5);
	}

    public Jugador getJugador() {
        return j;
    }
    public Tablero getTablero() {
		return t;
	}

    @Override
    public void empezar() {
        //TODO
    }

    @Override
    public void terminar() {
        if (j.getVidas() == 0){
            //TODO completar
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n", "Partida (Desafío) " + "[\n", "]")
                .add("\tTablero = {" + t + "}")
                .add("\tJugador = {" + j + "}")
                .toString();
    }
}

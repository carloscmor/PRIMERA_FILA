package Modelo;

import java.util.StringJoiner;

public class PartidaRapida implements Partida{
    private final Tablero t;
    private final Jugador j;

    public PartidaRapida(Dificultad d) {
        t = new Tablero(d);
        j = new Jugador("Jugador 1", 3);
    }

    public Jugador getJugador() {
        return j;
    }
    public Tablero getTablero() {
        return t;
    }

    @Override
    public void empezar() {
        // por hacer
    }

    @Override
    public void terminar() {
        if (j.getVidas() == 0){
            // por completar
        }
    }
    @Override
    public String toString() {
        return new StringJoiner(", \n", "Partida (Desaf�o) " + "[\n", "]")
                .add("\tTablero = {" + t + "}")
                .add("\tJugador = {" + j + "}")
                .toString();
    }
}
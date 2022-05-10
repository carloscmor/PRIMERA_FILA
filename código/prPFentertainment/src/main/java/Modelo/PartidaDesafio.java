package Modelo;

private Tablero t;
private Jugador j;

public class PartidaDesafio implements Partida{
    public PartidaDesafio() {
    }

    @Override
    public void empezar() {
        t = new Tablero(d);
        j = new Jugador();
        j.setvidas(5);
    }

    @Override
    public void terminar() {
        if (j.getvidas() == 0){
            //hay que completar
        }
    }
}

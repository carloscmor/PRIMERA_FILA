package Modelo;

public class PartidaDesafio implements Partida{
	private Tablero t;
	private Jugador j;

	public PartidaDesafio() {
	}

	public Tablero getTablero() {
		return t;
	}

    @Override
    public void empezar() {
        t = new Tablero('m');
        j = new Jugador("Jugador 1", 5);
    }

    @Override
    public void terminar() {
        if (j.getVidas() == 0){
            //hay que completar
        }
    }
}

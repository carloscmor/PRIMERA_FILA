package Modelo;

public class Ficha {

    private int posicion;

    public Ficha() {
        this(0);
    }

    public Ficha(int pos) {
        posicion = pos;
    }

    public void setPosicion(int pos) {
        posicion = pos;
    }

    public int getPosicion() {
        return posicion;
    }

    public void avanzar(int n) {
        posicion += n;
    }

    public void retroceder() {
        posicion--;
    }

    @Override
    public String toString() {
        return "Posicion de la ficha: " + getPosicion();
    }


}

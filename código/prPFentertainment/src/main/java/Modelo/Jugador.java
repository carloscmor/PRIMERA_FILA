package Modelo;

import java.util.StringJoiner;

public class Jugador {
    private String nombre;
    private int vidas, puntuacion;

    public Jugador(String nombre, int vidas){
        this(nombre, vidas, 0);
    }

    public Jugador(String nombre, int vidas, int puntuacion){
        this.nombre = nombre;
        this.vidas = vidas;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        if(vidas >= 0)
            this.vidas = vidas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        if(puntuacion >= 0)
            this.puntuacion = puntuacion;
    }

    public void incrementaPuntuacion(int p){
        puntuacion += p;
    }

    @Override
    public String toString(){
        StringJoiner str = new StringJoiner(", ","(",")");
        str.add(nombre);
        str.add("Vidas= " + Integer.toString(vidas));
        str.add("Puntuación= " + Integer.toString(puntuacion));
        return str.toString();
    }
}

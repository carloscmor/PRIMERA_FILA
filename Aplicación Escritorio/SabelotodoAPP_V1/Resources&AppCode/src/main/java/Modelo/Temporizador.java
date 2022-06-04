package Modelo;

public class Temporizador extends Thread {

    private final int inicio;
    private int tiempo;
    private boolean agotado;
    private boolean fin;

    /**
     * Constructor de la clase
     *
     * @param n Tiempo de inicio del temporizador
     */
    public Temporizador(int n) {
        if (n <= 0) throw new IllegalArgumentException("Valor incorrecto.");
        this.inicio = n;
        this.tiempo = n;
        agotado = false;
        fin = false;
    }

    /**
     * @return el estado del temporizador, es decir, si está agotado o no
     */
    public boolean getResultado() {
        return this.agotado;
    }

    /**
     * <b>No usar mientras el temporizador está corriendo.<b/>
     *
     * @return la cantidad de tiempo actual del temporizador
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Para el temporizador.
     */

    void parar() {
        fin = true;
    }

    /**
     * Reinicia el temporizador, reinicializando las variables.
     */
    public void reiniciar() {
        this.tiempo = inicio + 1;
        this.agotado = false;
    }

    /**
     * @return si se agotó el temporizador
     */
    boolean esFinal() {
        return fin;
    }

    /**
     * Inicia el temporizador
     */
    public void run() {
        while (!fin) {
            if (tiempo > 0) tiempo--;
            else {
                agotado = true;
                fin = true;
            }
            try {
                if (tiempo > 0)
                    //noinspection BusyWait
                    Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

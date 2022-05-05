package Modelo;
import java.util.Set;

public class Pregunta {
    private String categoria;
    private String pregunta;
    private String solucion;
    private int dificultad; // 1 facil 2 medio 3 dificil
    private Set<String> opciones;

    public boolean validar(String respuesta) {
        return respuesta.equalsIgnoreCase(solucion);
    }

    /*
    Categoría
    Pregunta
    Solución
    Dificultad
    Opciones
    Timer timerPregunta

    Pregunta()

    validar()

     */
}


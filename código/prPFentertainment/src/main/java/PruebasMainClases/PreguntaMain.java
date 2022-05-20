package PruebasMainClases;

import Modelo.Pregunta;

import java.util.Set;
import java.util.TreeSet;

public class PreguntaMain {
    public static void main(String[] args){
        Set<String> s = new TreeSet<>();
        s.add("Homo Ergaster");
        s.add("Homo Erectus");
        s.add("Homo Neanderthalensis");
        
        String sol = "Homo Sapiens";

        Pregunta p1 = new Pregunta("Historia", "What is the scientific name for modern day humans?",
                                    sol, s,10);

        System.out.println(p1 + "\n");

        Pregunta p2 = new Pregunta("General", "Flat earth?",
                Pregunta.falso,10);
        System.out.println(p2);
    }
}

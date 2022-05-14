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

        Pregunta p = new Pregunta("Historia", "What is the scientific name for modern day humans?",
                                    sol, s);

        System.out.println(p);


    }
}

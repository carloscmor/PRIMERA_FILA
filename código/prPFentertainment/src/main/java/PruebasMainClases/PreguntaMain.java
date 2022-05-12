package PruebasMainClases;

import Modelo.Pregunta;

import java.util.Set;
import java.util.TreeSet;

public class PreguntaMain {
    public static void main(String[] args){
        Set<String> s = new TreeSet<>();
        s.add("Homo Sapiens");
        s.add("Homo Ergaster");
        s.add("Homo Erectus");
        s.add("Homo Neanderthalensis");

        Pregunta p = new Pregunta("What is the scientific name for modern day humans?",
                                    s, "Homo Sapiens");

        System.out.println(p);


    }
}

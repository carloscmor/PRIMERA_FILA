package PrimeraFila.PFENTERTAINMENT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Pregunta;

public class PreguntaTest {
	String pregunta;
	Set<String> opciones;
	String solucion;
	Pregunta p;

	@BeforeEach
	public void init() {
		opciones = new HashSet<String>();
		pregunta = "Which Game Boy from the Game Boy series of portable video game consoles was released first?";
		opciones.add("Game Boy Color");
		opciones.add("Game Boy Advance");
		opciones.add("Game Boy Micro");
		opciones.add("Game Boy Advance SP");
		solucion = "Game Boy Color";
		p = new Pregunta(pregunta,opciones,solucion);
		//Pregunta de ejemplo, la idea es probar los tests con todas las preguntas, extraidas de los json.
	}

	@Test
	public void haySoloUnaSolucion() {
		int correctas = 0;
		for(String opcion:opciones) {
			if(p.validar(opcion)) correctas++;
		}
		assertEquals(1,correctas);
	}

	@Test
	public void tieneCategoria(){
		assertTrue( p.getCategoria()!=null && !(p.getCategoria().isEmpty()) );
	}

	@Test
	public void tieneDificultad(){
		assertTrue( p.getDificultad()!=null && !(p.getDificultad().isEmpty()) );
	}

	@Test
	public void tieneOpciones(){
		assertTrue( p.getOpciones()!=null && !(p.getOpciones().isEmpty()) );
	}

	@Test
	public void solucionEstaEnOpciones() {
		assertTrue(opciones.contains(solucion));
	}



}

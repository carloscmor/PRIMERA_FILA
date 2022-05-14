package PrimeraFila.PFENTERTAINMENT;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Casilla;
import Modelo.Pregunta;

public class PreguntaTest {

	Pregunta pregunta;

	@BeforeEach
	public void init() {
		Set<String> incorrectas = new HashSet<String>();
		incorrectas.add("A");
		incorrectas.add("B");
		incorrectas.add("C");
		incorrectas.add("Solucion");
		pregunta = new Pregunta("Categoria" , "Pregunta", "Solucion", incorrectas);

	}

	@Test
	public void laPreguntaSeHaCreadoCorrectaMente() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);

		Pregunta p = cMock.getPregunta();

		assertAll(
				() -> assertEquals("Pregunta", p.getPregunta()),
				() -> assertEquals("Solucion", p.getSolucion())
				);
	}

	@Test
	public void lasOpcionesTienenQueSerCuatroONull() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);

		Pregunta p = cMock.getPregunta();

		assertTrue(p.getIncorrectas() == null || p.getIncorrectas().size() == 4);
	}

	@Test
	public void elMetodoValidarFuciona() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);

		Pregunta p = cMock.getPregunta();

		assertAll(
				() -> assertTrue(p.validar("solucion")),
				() -> assertFalse(p.validar("B"))
				);

	}
	
	@Test
	public void laSolucionEstaEnLasOpciones() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);
		
		Pregunta p = cMock.getPregunta();
		
		assertTrue(p.getIncorrectas().contains("Solucion"));
	}

}

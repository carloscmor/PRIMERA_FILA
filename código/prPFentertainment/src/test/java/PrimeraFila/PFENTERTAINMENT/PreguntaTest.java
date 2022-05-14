package PrimeraFila.PFENTERTAINMENT;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
		pregunta = new Pregunta("Categoria", "Pregunta", "Solucion", incorrectas);

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
	public void lasIncorrectasTienenQueSerTresONull() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);

		Pregunta p = cMock.getPregunta();

		assertTrue(p.getIncorrectas() == null || p.getIncorrectas().size() == 3);
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
	public void lasIncorrectasAparecenSoloUnaVez() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);

		Pregunta p = cMock.getPregunta();

		assertAll(
				() -> assertNotEquals(p.getOpciones().get(0), p.getOpciones().get(1)),
				() -> assertNotEquals(p.getOpciones().get(1), p.getOpciones().get(2)),
				() -> assertNotEquals(p.getOpciones().get(2), p.getOpciones().get(0)),
				() -> assertNotEquals(p.getOpciones().get(0), p.getOpciones().get(3)),
				() -> assertNotEquals(p.getOpciones().get(1), p.getOpciones().get(3)),
				() -> assertNotEquals(p.getOpciones().get(2), p.getOpciones().get(3)));
	}

	@Test
	public void laSolucionEstaEnLasOpciones() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);

		Pregunta p = cMock.getPregunta();

		boolean apareceSolucion = false;
		int i = 0;

		while (i < 4 && !apareceSolucion) {
			apareceSolucion = p.getSolucion().equalsIgnoreCase(p.getOpciones().get(i));
			i++;
		}

		assertTrue(apareceSolucion);
	}

}

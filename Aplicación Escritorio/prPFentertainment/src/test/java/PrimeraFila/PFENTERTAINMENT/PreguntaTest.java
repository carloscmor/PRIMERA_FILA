package PrimeraFila.PFENTERTAINMENT;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
		pregunta = new Pregunta("Categoria", "Pregunta", "Solucion", incorrectas, 5);

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

	private List<String> copiaLista(List<String> l){
		List<String> res = new ArrayList<>();
		for(String str : l) res.add(str);
		return res;
	}

	@Test
	public void lasOpcionesAparecenSoloUnaVez() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);

		Pregunta p = cMock.getPregunta();
		List<String> opciones = p.getOpciones();
		List<String> opcionesCopia = copiaLista(opciones); //para no modificar la original
		boolean res = false;

		Iterator<String> it = opciones.iterator();
		while(it.hasNext() && !res) {
			String op = it.next();
			opcionesCopia.remove(op);
			res = !(opcionesCopia.contains(op));
		}

		assertTrue(res);
	}

	@Test
	public void laSolucionEstaEnLasOpciones() {
		Casilla cMock = mock(Casilla.class);
		when(cMock.getPregunta()).thenReturn(pregunta);

		Pregunta p = cMock.getPregunta();

		boolean apareceSolucion = false;
		String solucion = p.getSolucion();
		List<String> opciones = p.getOpciones();

		Iterator<String> it = opciones.iterator();
		while (it.hasNext() && !apareceSolucion) {
			apareceSolucion = it.next().equalsIgnoreCase(solucion);
		}

		assertTrue(apareceSolucion);
	}

}

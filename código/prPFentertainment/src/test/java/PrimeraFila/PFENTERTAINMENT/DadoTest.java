package practicaMockito.practicaSensores;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Temporizador.Dado;

public class DadoTest {
	Dado d;

	@BeforeEach
	public void init() {
		d = new Dado();
	}
	
	@AfterEach
	public void terminate() {
		d = null;
	}

	@Test
	public void siTiroElDadoDevuelveUnValor() {
		d.tirar();
		assertTrue(d.valor() > 0 && d.valor() < 7);
	}
	
	@Test
	public void elDadoDevuelveTodosLosPosiblesValores() {
		Set<Integer> lista = new HashSet<>();
		for (int i = 1; i < 7; ++i) {
			lista.add(i);
		}
		while (!lista.isEmpty()) {
			d.tirar();
			if(lista.contains(d.valor())) {
				lista.remove(d.valor());
			}
		}
		assertTrue(lista.isEmpty());
	}
}
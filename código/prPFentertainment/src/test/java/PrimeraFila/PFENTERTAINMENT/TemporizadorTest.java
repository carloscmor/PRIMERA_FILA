package pruebasJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Temporizador.Temporizador;

public class TemporizadorTest {
	Temporizador t;

	@BeforeEach
	public void init() {
		t = new Temporizador(3);
	}

	@AfterEach
	public void terminate() {
		t = null;
	}

	@Test
	public void alPrincipioElTimerNoEstaAgotado() {
		assertFalse(t.getResultado());
	}

	@Test
	public void siSeRespondeAntesDeTiempoNoEstaAgotado() {
		t.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(t.getResultado());
	}

	@Test
	public void siNoSeRespondeTiempoEstaAgotado() {
		t.start();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(t.getResultado());
	}

	@Test
	public void alReiniciarElTemporizadorElTiempoSeQuedaIgualQueAlPrincipio() {
		int inicio = t.getTiempo();
		t.start();

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t.reiniciar();
		assertEquals(inicio, t.getTiempo()-1);
	}

	@Test
	public void siSeCreaElTimerConUnValorIncorrectoLanzaExcepcion() throws IllegalArgumentException {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Temporizador(-5));
	    assertEquals("Valor incorrecto.", exception.getMessage());
	}

}

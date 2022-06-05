import java.util.concurrent.TimeUnit;

import GUIs.PantallaInicio;
import GUIs.finJuego;
import GUIs.frameJuego;
import Modelo.Partida;

public class mainJuego {

	public static void main(String[] args) {
		
		PantallaInicio window = new PantallaInicio();
		window.frame.setVisible(true);
		while(!window.isSelected() || window.getNick().length() == 0) {
			System.out.println("Esperando...");
		}
		
		System.out.println("Creando partida");
		Partida par = null;
		String nick = window.getNick();
		
		if (window.esRapida()) {
			par = new Partida(nick, window.esRapida(), "easy");			
		} else {
			par = new Partida(nick);
		}
		
		System.out.println("Partida creada");
		
		frameJuego juego = new frameJuego(par);
		juego.frame.setVisible(true);
		window.frame.setVisible(false);
		
		while(!juego.finalTablero) {
			System.out.println("Juego en marcha...");
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("lmao");
		}
		
		finJuego finalJuego = new finJuego(juego.sinVidas, nick);
		finalJuego.frame.setVisible(true);
		juego.frame.setVisible(false);
		
		
		
		//window.frame.dispatchEvent(new WindowEvent(window.frame, WindowEvent.WINDOW_CLOSING));
	}

}

package GUIs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class finJuego {

	public JFrame frame;
	private boolean derrota;
	private String nombre = "";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public finJuego(boolean res, String nick) {
		derrota = res;
		nombre = nick;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Fin del juego");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\logo.png"));
		frame.setBounds(0, 0, 1277, 655);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBounds(0, 0, 1277, 655);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblDespedida = new JLabel("New label");
		lblDespedida.setForeground(Color.GREEN);
		lblDespedida.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 33));
		lblDespedida.setHorizontalAlignment(SwingConstants.CENTER);
		lblDespedida.setBounds(50, 218, 1200, 300);
		
		if (!derrota) {
			lblDespedida.setText("¡Has ganado! Buen trabajo, sigue así.");
		} else {
			lblDespedida.setForeground(Color.RED);
			lblDespedida.setText("Vaya has perdido... ¡Estudia un poco más y vuelve para la revancha!");
		}
		
		frame.getContentPane().add(lblDespedida);
		
		JLabel lblNickJugador = new JLabel(nombre);
		lblNickJugador.setFont(new Font("Arial Black", Font.PLAIN, 45));
		lblNickJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickJugador.setBounds(173, 104, 931, 86);
		frame.getContentPane().add(lblNickJugador);
		
		//frame.pack();
		//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		//frame.setLocationRelativeTo(null);
		frame.revalidate();
		frame.repaint();
		//frame.setVisible(true);
	}

}

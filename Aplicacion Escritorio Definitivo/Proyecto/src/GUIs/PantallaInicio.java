package GUIs;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PantallaInicio {

	public JFrame frame;
	private boolean rapida;
	private String nombre = "";
	private boolean modoSelected = false;
	private Boolean dificultad = null;
	private JTextField tfNick;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PantallaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Bienvenido a SABELOTODO");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\logo.png"));
		frame.setBounds(0, 0, 1277, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBounds(0, 0, 1277, 655);
		frame.getContentPane().setLayout(null);
		


		JLabel lblWelcome = new JLabel("Bienvenido a SABELOTODO");
		lblWelcome.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 39));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(298, 38, 681, 229);
		frame.getContentPane().add(lblWelcome);

		JLabel lblSub = new JLabel("Por favor, elige la modalidad de juego y tu nick");
		lblSub.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblSub.setHorizontalAlignment(SwingConstants.CENTER);
		lblSub.setBounds(351, 270, 574, 46);
		frame.getContentPane().add(lblSub);

		JButton btnModoDesafio = new JButton("MODO DESAFIO");

		
		
		
		
		JButton btnRapida = new JButton("PARTIDA RAPIDA");
		btnRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!modoSelected) {
					rapida = true;
					modoSelected = true;
					btnModoDesafio.setEnabled(false);
				}

			}
		});
		btnRapida.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRapida.setBounds(395, 327, 215, 165);
		frame.getContentPane().add(btnRapida);

		btnModoDesafio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!modoSelected) {
					rapida = false;
					modoSelected = true;
					btnRapida.setEnabled(false);
				}

			}
		});
		btnModoDesafio.setFont(new Font("Stencil", Font.PLAIN, 21));
		btnModoDesafio.setBounds(670, 327, 215, 165);
		frame.getContentPane().add(btnModoDesafio);

		tfNick = new JTextField();
		tfNick.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre = tfNick.getText();
				tfNick.setEditable(false);
				tfNick.setEnabled(false);
				tfNick.setText("Nombre registrado");
			}
		});
		tfNick.setToolTipText("Introduce tu nick...");
		tfNick.setBounds(514, 518, 249, 34);
		frame.getContentPane().add(tfNick);
		tfNick.setColumns(10);
		
//		frame.pack();
		frame.revalidate();
		frame.repaint();
//		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
		
	}

	public boolean isSelected() {
		return modoSelected;
	}

	public String getNick() {
		return nombre;
	}
	
	public Boolean getDificultad() {
		return dificultad;
	}
	
	public boolean esRapida() {
		return rapida;
	}
}

package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Modelo.Casilla;
import Modelo.Dado;
import Modelo.Ficha;
import Modelo.Partida;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class frameJuego {

	public JFrame frame;
	private JButton opcionA = new JButton("");
	private JButton opcionB = new JButton("");
	private JButton opcionC = new JButton("");
	private JButton opcionD = new JButton("");
	private Partida par;
	public boolean finalTablero = false;
	private static boolean esperaRespuesta = false;
	private static boolean respondido = false;
	public boolean sinVidas = false;
	private boolean bloqueado = false;
	private String respuesta = "";
	private String correcta = "";
	private int rows = 1;
	private int cols = 1;
	private int vidas = 0;
	private final JLabel lblResultado = new JLabel("");
	private final JLabel lblVida1 = new JLabel("");
	private final JLabel lblVida2 = new JLabel("");
	private final JLabel lblVida3 = new JLabel("");
	private final JLabel lblVida4 = new JLabel("");
	private final JLabel lblVida5 = new JLabel("");
	private final JTextField lblPregunta = new JTextField();
	private final JLabel lblAux = new JLabel("Dificultad");
	private final JLabel lblDificultadPr = new JLabel("New label");

	/**
	 * Create the application.
	 */
	public frameJuego(Partida p) {
		par = p;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPregunta.setEditable(false);
		lblPregunta.setBounds(662, 261, 564, 146);
		lblPregunta.setColumns(10);

		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("SABELOTODO");
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage("resources\\logo.png"));
		frame.setBounds(0, 0, 1277, 655);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBounds(0, 0, 1277, 655);
		frame.getContentPane().setLayout(null);
		//frame.pack();
		

		JLayeredPane contenedorTablero = new JLayeredPane();
		contenedorTablero.setBounds(10, 20, 614, 576);
		frame.getContentPane().add(contenedorTablero);

		vidas = par.getJugador().getVidas();

		JLabel lblFicha = new JLabel("");
		lblFicha.setIcon(new ImageIcon("resources\\ficha2.png"));
		lblFicha.setForeground(Color.WHITE);
		lblFicha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFicha.setBounds(120, 250, 79, 68);
		frame.getContentPane().add(lblFicha);

		JLabel lastPos = new JLabel("");
		lastPos.setIcon(new ImageIcon("resources\\lastPos.png"));
		lblFicha.setForeground(Color.WHITE);
		lastPos.setHorizontalAlignment(SwingConstants.CENTER);
		lastPos.setBounds(0, 0, 118, 114);
		// lastPos.setVisible(false);
		// frame.getContentPane().add(lastPos);

		lblResultado.setForeground(Color.GREEN);
		lblResultado.setFont(new Font("Broadway", Font.PLAIN, 25));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(634, 22, 250, 105);
		frame.getContentPane().add(lblResultado);

		opcionA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!respondido) {
					respuesta = opcionA.getText();
					respondido = true;

					if (respuesta.equals(correcta)) {
						lblResultado.setForeground(Color.GREEN);
						lblResultado.setText("HAS ACERTADO!");
					} else {
						lblResultado.setForeground(Color.RED);
						lblResultado.setText("HAS FALLADO...");
						--vidas;
						actualizarVidas();
					}

					modoTablero();
				}
			}
		});
		opcionA.setBounds(662, 420, 280, 86);
		opcionA.setVisible(false);
		frame.getContentPane().add(opcionA);

		opcionB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!respondido) {
					respuesta = opcionB.getText();
					respondido = true;

					if (respuesta.equals(correcta)) {
						lblResultado.setForeground(Color.GREEN);
						lblResultado.setText("HAS ACERTADO!");
					} else {
						lblResultado.setForeground(Color.RED);
						lblResultado.setText("HAS FALLADO...");
						--vidas;
						actualizarVidas();
					}

					modoTablero();
				}
			}
		});
		opcionB.setBounds(960, 420, 280, 86);
		opcionB.setVisible(false);
		frame.getContentPane().add(opcionB);

		opcionC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!respondido) {
					respuesta = opcionC.getText();
					respondido = true;

					if (respuesta.equals(correcta)) {
						lblResultado.setForeground(Color.GREEN);
						lblResultado.setText("HAS ACERTADO!");
					} else {
						lblResultado.setForeground(Color.RED);
						lblResultado.setText("HAS FALLADO...");
						--vidas;
						actualizarVidas();
					}

					modoTablero();
				}
			}
		});
		opcionC.setBounds(662, 515, 280, 86);
		opcionC.setVisible(false);
		frame.getContentPane().add(opcionC);

		opcionD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!respondido) {
					respuesta = opcionD.getText();
					respondido = true;

					if (respuesta.equals(correcta)) {
						lblResultado.setForeground(Color.GREEN);
						lblResultado.setText("HAS ACERTADO!");
					} else {
						lblResultado.setForeground(Color.RED);
						lblResultado.setText("HAS FALLADO...");
						--vidas;
						actualizarVidas();
					}

					modoTablero();
				}
			}
		});
		opcionD.setBounds(960, 517, 280, 86);
		opcionD.setVisible(false);
		frame.getContentPane().add(opcionD);

		Dado d = new Dado();

		Dimension boardSize = new Dimension(500, 500);

		int tam = par.getTablero().getCasillas().size();
		System.out.println("El tamaño es " + tam);
		frame.getContentPane().add(contenedorTablero);
		contenedorTablero.setPreferredSize(boardSize);

		JPanel tablero = new JPanel();
		contenedorTablero.add(tablero, JLayeredPane.DEFAULT_LAYER);

		if (tam == 30) {
			rows = 5;
			cols = 6;
		} else {
			rows = 4;
			cols = 5;
		}
		System.out.println("Las columnas son " + cols + " y las filas son " + rows);

		GridLayout gl = new GridLayout(rows, cols);
		gl.setVgap(40);
		gl.setHgap(5);
		tablero.setLayout(gl);

		tablero.setPreferredSize(boardSize);
		tablero.setBackground(Color.black);
		tablero.setBounds(0, 0, 614, 576);

		BorderLayout bl = new BorderLayout();

		int cont = 0;
		for (int i = 0; i < rows * cols; i++) {

			JPanel square = new JPanel(bl);

			int index = cont;

			if ((index / cols) % 2 != 0) {
				index = (rows - (index % cols)) + (cols * (index / cols));
			}

			if (par.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("Sports"))
				square.setBackground(Color.orange);
			else if (par.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("Science"))
				square.setBackground(Color.green);
			else if (par.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("Animals"))
				square.setBackground(Color.pink);
			else if (par.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("General"))
				square.setBackground(Color.CYAN);
			else if (par.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("History"))
				square.setBackground(Color.yellow);
			else
				square.setBackground(Color.red);

			cont++;

			tablero.add(square);
		}

		JPanel inicio = (JPanel) tablero.getComponent(0);
		inicio.add(lblFicha);

		Ficha f = new Ficha();

		JButton btnDado = new JButton("");
		btnDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!sinVidas && !bloqueado) {
					d.tirar();

					int nCasillas = par.getTablero().getCasillas().size();

					if (nCasillas == 30) {
						if (f.getPosicion() + d.valor() < 29 && !esperaRespuesta) {

							btnDado.setIcon(new ImageIcon("resources\\" + d.valor() + ".png"));

							moverDesafio(f, tablero, lblFicha, d.valor(), lastPos);

							modoPregunta(f, tablero);
						} else if (!esperaRespuesta && f.getPosicion() + d.valor() >= 29) {
							if (!finalTablero) {
								btnDado.setIcon(new ImageIcon("resources\\" + d.valor() + ".png"));

								moverDesafio(f, tablero, lblFicha, lastPos);

							}

						}
					} else {
						if (f.getPosicion() + d.valor() < 19 && !esperaRespuesta) {

							btnDado.setIcon(new ImageIcon("resources\\" + d.valor() + ".png"));

							moverRapida(f, tablero, lblFicha, d.valor(), lastPos);

							modoPregunta(f, tablero);
						} else if (!esperaRespuesta && f.getPosicion() + d.valor() >= 19) {
							if (!finalTablero) {
								btnDado.setIcon(new ImageIcon("resources\\" + d.valor() + ".png"));

								moverRapida(f, tablero, lblFicha, lastPos);

							}

						}

					}

				}

			}
		});
		btnDado.setIcon(new ImageIcon("resources\\5.png"));
		btnDado.setBounds(1010, 20, 230, 230);
		frame.getContentPane().add(btnDado);

		lblVida1.setIcon(new ImageIcon("resources\\corazon.png"));
		lblVida1.setBounds(885, 10, 70, 70);
		frame.getContentPane().add(lblVida1);

		lblVida2.setIcon(new ImageIcon("resources\\corazon.png"));
		lblVida2.setBounds(937, 10, 70, 70);
		frame.getContentPane().add(lblVida2);

		lblVida3.setIcon(new ImageIcon("resources\\corazon.png"));
		lblVida3.setBounds(911, 110, 70, 70);
		frame.getContentPane().add(lblVida3);

		lblVida4.setIcon(new ImageIcon("resources\\corazon.png"));
		lblVida4.setBounds(937, 61, 70, 70);
		frame.getContentPane().add(lblVida4);

		lblVida5.setIcon(new ImageIcon("resources\\corazon.png"));
		lblVida5.setBounds(885, 61, 70, 70);
		frame.getContentPane().add(lblVida5);

		frame.getContentPane().add(lblPregunta);
		lblAux.setFont(new Font("Arial", Font.PLAIN, 23));
		lblAux.setHorizontalAlignment(SwingConstants.CENTER);
		lblAux.setVisible(false);
		lblAux.setBounds(634, 190, 143, 60);

		frame.getContentPane().add(lblAux);
		lblDificultadPr.setForeground(Color.CYAN);
		lblDificultadPr.setFont(new Font("Stencil", Font.PLAIN, 23));
		lblDificultadPr.setHorizontalAlignment(SwingConstants.CENTER);
		lblDificultadPr.setVisible(false);
		lblDificultadPr.setBounds(751, 193, 143, 60);

		frame.getContentPane().add(lblDificultadPr);

		if (par.getJugador().getVidas() == 3) {
			lblVida4.setVisible(false);
			lblVida5.setVisible(false);
		}
		
		
		//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		//frame.setLocationRelativeTo(null);
		frame.revalidate();
		frame.repaint();
		//frame.setVisible(true);

	}

	private void moverRapida(Ficha f, JPanel tablero, JLabel lblFicha, int valor, JLabel lastPos) {

		int index = f.getPosicion();

//		JPanel c = (JPanel) tablero.getComponent(index);
//		c.add(lastPos);
//		c.revalidate();
//		c.repaint();

		if ((index / cols) % 2 != 0) {
			index = (rows - (index % cols)) + (cols * (index / cols));
		}

		JPanel c = null;

		for (int i = 0; i < 20; ++i) {
			c = (JPanel) tablero.getComponent(i);
			try {
				c.remove(lblFicha);
				c.remove(lastPos);
			} catch (Exception e) {
				// Nada
			}
			c.revalidate();
			c.repaint();
		}

		c = (JPanel) tablero.getComponent(index);

		try {
			c.remove(lblFicha);
			c.add(lastPos);
		} catch (Exception e) {
			// Nada
		}
		c.revalidate();
		c.repaint();

		f.avanzar(valor);

		// Algoritmo deTell
		index = f.getPosicion();

		if ((index / cols) % 2 != 0) {
			index = (rows - (index % cols)) + (cols * (index / cols));
		}

		JPanel c2 = (JPanel) tablero.getComponent(index);
		c2.add(lblFicha);
		c2.revalidate();
		c2.repaint();
		System.out.println("Esta en la posicion " + f.getPosicion());
	}

	private void moverRapida(Ficha f, JPanel tablero, JLabel lblFicha, JLabel lastPos) {

		int index = f.getPosicion();

//		JPanel c = (JPanel) tablero.getComponent(index);
//		c.add(lastPos);
//		c.revalidate();
//		c.repaint();

		if ((index / cols) % 2 != 0) {
			index = (rows - (index % cols)) + (cols * (index / cols));
		}

		JPanel c = null;

		for (int i = 0; i < 20; ++i) {
			c = (JPanel) tablero.getComponent(i);
			try {
				c.remove(lblFicha);
				c.remove(lastPos);
			} catch (Exception e) {
				// Nada
			}
			c.revalidate();
			c.repaint();
		}

		c = (JPanel) tablero.getComponent(index);

		try {
			c.remove(lblFicha);
			c.add(lastPos);
		} catch (Exception e) {
			// Nada
		}
		c.revalidate();
		c.repaint();

		f.setPosicion(15);

		// Algoritmo deTell
		index = f.getPosicion();

		if ((index / cols) % 2 != 0) {
			index = (rows - (index % cols)) + (cols * (index / cols));
		}

		JPanel c2 = (JPanel) tablero.getComponent(index);
		c2.add(lblFicha);
		c2.revalidate();
		c2.repaint();
		
		for (int i = 0; i < 20; ++i) {
			c = (JPanel) tablero.getComponent(i);
			try {
				c.remove(lblFicha);
				c.remove(lastPos);
			} catch (Exception e) {
				// Nada
			}
			c.revalidate();
			c.repaint();
		}
		
		c2 = (JPanel) tablero.getComponent(15);
		c2.add(lblFicha);

		finalTablero = true;
		bloqueado = true;
		lblPregunta.setText("Has llegado al final!");
		lblPregunta.setForeground(Color.GREEN);
		lblResultado.setText("");

		System.out.println("Esta en la posicion " + f.getPosicion());
	}

	private void moverDesafio(Ficha f, JPanel tablero, JLabel lblFicha, int valor, JLabel lastPos) {

		int index = f.getPosicion();

//	JPanel c = (JPanel) tablero.getComponent(index);
//	c.add(lastPos);
//	c.revalidate();
//	c.repaint();

		if ((index / cols) % 2 != 0) {
			index = (rows - (index % cols)) + (cols * (index / cols));
		}

		JPanel c = null;

		for (int i = 0; i < 30; ++i) {
			c = (JPanel) tablero.getComponent(i);
			try {
				c.remove(lblFicha);
				c.remove(lastPos);
			} catch (Exception e) {
				// Nada
			}
			c.revalidate();
			c.repaint();
		}

		c = (JPanel) tablero.getComponent(index);

		try {
			c.remove(lblFicha);
			c.add(lastPos);
		} catch (Exception e) {
			// Nada
		}
		c.revalidate();
		c.repaint();

		f.avanzar(valor);

		// Algoritmo deTell
		index = f.getPosicion();

		if ((index / cols) % 2 != 0) {
			index = (rows - (index % cols)) + (cols * (index / cols));
		}

		JPanel c2 = (JPanel) tablero.getComponent(index);
		c2.add(lblFicha);
		c2.revalidate();
		c2.repaint();
		System.out.println("Esta en la posicion " + f.getPosicion());
	}

	private void moverDesafio(Ficha f, JPanel tablero, JLabel lblFicha, JLabel lastPos) {

		int index = f.getPosicion();

//	JPanel c = (JPanel) tablero.getComponent(index);
//	c.add(lastPos);
//	c.revalidate();
//	c.repaint();

		if ((index / cols) % 2 != 0) {
			index = (rows - (index % cols)) + (cols * (index / cols));
		}

		JPanel c = null;

		for (int i = 0; i < 30; ++i) {
			c = (JPanel) tablero.getComponent(i);
			try {
				c.remove(lblFicha);
				c.remove(lastPos);
			} catch (Exception e) {
				// Nada
			}
			c.revalidate();
			c.repaint();
		}

		c = (JPanel) tablero.getComponent(index);

		try {
			c.remove(lblFicha);
			c.add(lastPos);
		} catch (Exception e) {
			// Nada
		}
		c.revalidate();
		c.repaint();

		f.setPosicion(29);

		// Algoritmo deTell
		index = f.getPosicion();

		if ((index / cols) % 2 != 0) {
			index = (rows - (index % cols)) + (cols * (index / cols));
		}

		JPanel c2 = (JPanel) tablero.getComponent(index);
		c2.add(lblFicha);
		c2.revalidate();
		c2.repaint();

		finalTablero = true;
		lblPregunta.setText("Has llegado al final!");
		lblPregunta.setForeground(Color.GREEN);
		lblResultado.setText("");

		System.out.println("Esta en la posicion " + f.getPosicion());
	}

	private void modoPregunta(Ficha f, JPanel tablero) {
		esperaRespuesta = true;

		lblResultado.setText("");

		Casilla cas = par.getTablero().getCasillas().get(f.getPosicion());

		lblPregunta.setText(cas.getPregunta().getPregunta());

		List<String> opciones = cas.getPregunta().getOpciones();

		correcta = cas.getPregunta().getSolucion();

		opcionA.setText(opciones.get(0));
		opcionB.setText(opciones.get(1));
		opcionC.setText(opciones.get(2));
		opcionD.setText(opciones.get(3));

		opcionA.setVisible(true);
		opcionB.setVisible(true);
		opcionC.setVisible(true);
		opcionD.setVisible(true);

		Color colorTexto = Color.BLACK;
		String texto = "";

		switch (cas.getDificultad()) {
		case "hard":
			colorTexto = Color.RED;
			texto = "DIFICIL";
			break;
		case "medium":
			colorTexto = Color.ORANGE;
			texto = "MEDIO";
			break;
		case "easy":
			colorTexto = Color.CYAN;
			texto = "FACIL";
			break;
		}

		lblAux.setVisible(true);
		lblDificultadPr.setText(texto);
		lblDificultadPr.setForeground(colorTexto);
		lblDificultadPr.setVisible(true);
	}

	private void modoTablero() {
		esperaRespuesta = false;

		opcionA.setVisible(false);
		opcionB.setVisible(false);
		opcionC.setVisible(false);
		opcionD.setVisible(false);

		lblAux.setVisible(false);
		lblDificultadPr.setVisible(false);

		respondido = false;
	}

	private void actualizarVidas() {

		switch (vidas) {
		case 4:
			lblVida5.setVisible(false);
			break;
		case 3:
			lblVida4.setVisible(false);
			break;
		case 2:
			lblVida3.setVisible(false);
			break;
		case 1:
			lblVida2.setVisible(false);
			break;
		case 0:
			lblVida1.setVisible(false);
			sinVidas = true;
			finalTablero = true;
			lblPregunta.setText("Te has quedado sin vidas... Terminando el juego");
			lblPregunta.setForeground(Color.RED);
			break;
		default:
			//
		}

	}
}

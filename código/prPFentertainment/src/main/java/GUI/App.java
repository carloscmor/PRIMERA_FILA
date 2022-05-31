package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.TextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Canvas;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.ScrollPane;

public class App {

	private JFrame frmSabelotodo;
	private JTextField insertaJugador;
	private JTextField timeLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmSabelotodo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSabelotodo = new JFrame();
		frmSabelotodo.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\static\\archivos\\logo\\logo_oscuro.png"));
		frmSabelotodo.setTitle("SABELOTODO");
		frmSabelotodo.setBounds(100, 100, 1277, 655);
		
		frmSabelotodo.setLocationRelativeTo(null);
		frmSabelotodo.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSabelotodo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSabelotodo.getContentPane().setLayout(null);
		
		JButton EndButton = new JButton("TERMINAR");
		EndButton.setEnabled(false);
		EndButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EndButton.setBounds(1134, 584, 119, 23);
		frmSabelotodo.getContentPane().add(EndButton);
		
		JButton modoDesafio = new JButton("DESAFÍO");
		modoDesafio.setEnabled(false);
		modoDesafio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		modoDesafio.setBounds(846, 58, 99, 42);
		frmSabelotodo.getContentPane().add(modoDesafio);
		
		JButton modoRapida = new JButton("RÁPIDA");
		modoRapida.setEnabled(false);
		modoRapida.setBounds(955, 58, 90, 42);
		frmSabelotodo.getContentPane().add(modoRapida);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\static\\archivos\\logo\\logo_oscuro_chico.png"));
		lblNewLabel.setBounds(10, 11, 133, 139);
		frmSabelotodo.getContentPane().add(lblNewLabel);
		
		JLabel nombreAPP = new JLabel("SABELOTODO");
		nombreAPP.setFont(new Font("Tahoma", Font.PLAIN, 46));
		nombreAPP.setBounds(153, 33, 332, 67);
		frmSabelotodo.getContentPane().add(nombreAPP);
		
		JLabel eslogan = new JLabel("EL JUEGO QUE PONE A PRUEBA TUS CONOCIMIENTOS");
		eslogan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eslogan.setBounds(144, 93, 360, 14);
		frmSabelotodo.getContentPane().add(eslogan);
		
		JLabel modoPartidaLabel = new JLabel("Selección del modo de partida:");
		modoPartidaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modoPartidaLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		modoPartidaLabel.setBounds(846, 33, 199, 14);
		frmSabelotodo.getContentPane().add(modoPartidaLabel);
		
		JPanel panel_partida = new JPanel();
		panel_partida.setBackground(SystemColor.inactiveCaptionBorder);
		panel_partida.setBounds(10, 143, 1243, 431);
		frmSabelotodo.getContentPane().add(panel_partida);
		panel_partida.setLayout(null);
		
		JComboBox comboBoxOpciones = new JComboBox();
		comboBoxOpciones.setEnabled(false);
		comboBoxOpciones.setBounds(1035, 128, 164, 22);
		panel_partida.add(comboBoxOpciones);
		
		JScrollPane scrollTablero = new JScrollPane();
		scrollTablero.setBounds(30, 39, 481, 381);
		panel_partida.add(scrollTablero);
		
		JTextPane tableroPane = new JTextPane();
		tableroPane.setEnabled(false);
		tableroPane.setEditable(false);
		tableroPane.setToolTipText("aquí se muestra el tablero");
		tableroPane.setFont(new Font("Dialog", Font.PLAIN, 19));
		tableroPane.setBackground(UIManager.getColor("List.dropCellBackground"));
		scrollTablero.setViewportView(tableroPane);
		
		JLabel tableroLabel = new JLabel("TABLERO");
		tableroLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tableroLabel.setBounds(201, 11, 108, 29);
		panel_partida.add(tableroLabel);
		
		JLabel preguntaLabel = new JLabel("PREGUNTA");
		preguntaLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		preguntaLabel.setBounds(552, 11, 146, 29);
		panel_partida.add(preguntaLabel);
		
		JLabel selecciónLabel = new JLabel("Selección de la respuesta");
		selecciónLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selecciónLabel.setBounds(1035, 102, 164, 14);
		panel_partida.add(selecciónLabel);
		
		JLabel lblNewLabel_5_2 = new JLabel("DADO");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_5_2.setBounds(542, 228, 68, 29);
		panel_partida.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Resultado:");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_3.setBounds(1035, 162, 100, 29);
		panel_partida.add(lblNewLabel_5_3);
		
		JTextPane infoCasilla = new JTextPane();
		infoCasilla.setEnabled(false);
		infoCasilla.setEditable(false);
		infoCasilla.setFont(new Font("Dialog", Font.PLAIN, 16));
		infoCasilla.setBounds(542, 382, 344, 38);
		panel_partida.add(infoCasilla);
		
		JLabel casillaLabel = new JLabel("CASILLA ACTUAL");
		casillaLabel.setBounds(542, 348, 223, 22);
		panel_partida.add(casillaLabel);
		
		JTextPane dado = new JTextPane();
		dado.setEnabled(false);
		dado.setEditable(false);
		dado.setFont(new Font("Dialog", Font.PLAIN, 73));
		dado.setBounds(617, 228, 118, 108);
		panel_partida.add(dado);
		
		JLabel resLabel = new JLabel("res");
		resLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		resLabel.setBounds(1138, 164, 93, 28);
		panel_partida.add(resLabel);
		
		JButton responderPregunta = new JButton("RESPONDER");
		responderPregunta.setEnabled(false);
		responderPregunta.setBounds(1035, 39, 164, 51);
		panel_partida.add(responderPregunta);
		
		JLabel tiempoLabel = new JLabel("TIEMPO:");
		tiempoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tiempoLabel.setBounds(786, 11, 100, 29);
		panel_partida.add(tiempoLabel);
		
		timeLog = new JTextField();
		timeLog.setEnabled(false);
		timeLog.setEditable(false);
		timeLog.setFont(new Font("Dialog", Font.PLAIN, 19));
		timeLog.setBounds(882, 11, 75, 38);
		panel_partida.add(timeLog);
		timeLog.setColumns(10);
		
		JButton seguirPartida = new JButton("DESPLAZAR FICHA");
		seguirPartida.setEnabled(false);
		seguirPartida.setBounds(747, 267, 139, 69);
		panel_partida.add(seguirPartida);
		
		JButton tiraDado = new JButton("TIRAR");
		tiraDado.setEnabled(false);
		tiraDado.setBounds(750, 228, 88, 26);
		panel_partida.add(tiraDado);
		
		JPanel InformacionPanel = new JPanel();
		InformacionPanel.setBackground(SystemColor.info);
		InformacionPanel.setBounds(898, 209, 333, 211);
		panel_partida.add(InformacionPanel);
		InformacionPanel.setLayout(null);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("INFORMACIÓN DE LA PARTIDA");
		lblNewLabel_5_2_2.setBounds(6, 5, 320, 28);
		InformacionPanel.add(lblNewLabel_5_2_2);
		lblNewLabel_5_2_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JTextPane nombreJugador = new JTextPane();
		nombreJugador.setEnabled(false);
		nombreJugador.setEditable(false);
		nombreJugador.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombreJugador.setBackground(SystemColor.control);
		nombreJugador.setBounds(135, 45, 186, 43);
		InformacionPanel.add(nombreJugador);
		
		JTextPane puntuacion = new JTextPane();
		puntuacion.setEnabled(false);
		puntuacion.setEditable(false);
		puntuacion.setFont(new Font("Dialog", Font.PLAIN, 22));
		puntuacion.setBackground(SystemColor.menu);
		puntuacion.setBounds(182, 100, 139, 43);
		InformacionPanel.add(puntuacion);
		
		JTextPane vidas = new JTextPane();
		vidas.setEnabled(false);
		vidas.setEditable(false);
		vidas.setFont(new Font("Dialog", Font.PLAIN, 22));
		vidas.setBackground(SystemColor.menu);
		vidas.setBounds(182, 155, 139, 44);
		InformacionPanel.add(vidas);
		
		JLabel jugadorLabel = new JLabel("JUGADOR");
		jugadorLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		jugadorLabel.setBounds(42, 46, 86, 21);
		InformacionPanel.add(jugadorLabel);
		
		JLabel puntuacionLabel = new JLabel("PUNTUACIÓN");
		puntuacionLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		puntuacionLabel.setBounds(52, 100, 112, 21);
		InformacionPanel.add(puntuacionLabel);
		
		JLabel vidasLabel = new JLabel("VIDAS");
		vidasLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		vidasLabel.setBounds(78, 155, 86, 21);
		InformacionPanel.add(vidasLabel);
		
		JScrollPane scrollPregunta = new JScrollPane();
		scrollPregunta.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPregunta.setBounds(523, 52, 500, 150);
		panel_partida.add(scrollPregunta);
		
		JTextPane preguntaPane = new JTextPane();
		preguntaPane.setEnabled(false);
		preguntaPane.setEditable(false);
		scrollPregunta.setViewportView(preguntaPane);
		preguntaPane.setFont(new Font("Dialog", Font.PLAIN, 17));
		preguntaPane.setBackground(new Color(240, 255, 255));
		
		insertaJugador = new JTextField();
		insertaJugador.setFont(new Font("Tahoma", Font.PLAIN, 23));
		insertaJugador.setBounds(567, 59, 210, 33);
		frmSabelotodo.getContentPane().add(insertaJugador);
		insertaJugador.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre del jugador:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(557, 33, 165, 14);
		frmSabelotodo.getContentPane().add(lblNewLabel_4);
		
		JButton registraJugador = new JButton("registrar");
		registraJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registraJugador.setBounds(688, 93, 89, 39);
		frmSabelotodo.getContentPane().add(registraJugador);
		
		JButton inicioPartida = new JButton("INICIAR PARTIDA");
		inicioPartida.setEnabled(false);
		inicioPartida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inicioPartida.setBounds(1070, 33, 165, 72);
		frmSabelotodo.getContentPane().add(inicioPartida);
		
		JLabel developpers = new JLabel("PF ENTERTAINMENT");
		developpers.setFont(new Font("Dialog", Font.BOLD, 16));
		developpers.setBounds(71, 584, 258, 19);
		frmSabelotodo.getContentPane().add(developpers);
		
		JLabel partidaLabel = new JLabel("Estado:");
		partidaLabel.setBounds(601, 586, 49, 19);
		frmSabelotodo.getContentPane().add(partidaLabel);
		
		JLabel estadoLabel = new JLabel("estadoPartida");
		estadoLabel.setBounds(662, 587, 99, 16);
		frmSabelotodo.getContentPane().add(estadoLabel);
		
		
	}
}

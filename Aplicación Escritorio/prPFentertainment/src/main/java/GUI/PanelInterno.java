package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class PanelInterno extends JPanel {
	/**
	 * 
	 */
	public static final String cmdModoDesafio = "DESAFIO",
								cmdModoRapida = "RAPIDA",
								cmdRegistraJugador = "REGISTRA",
								cmdInicioPartida = "INICIO",
								cmdEndButton = "TERMINA",
								cmdResponde = "RESPONDE",
								cmdSeguir = "SIGUE",
								cmdTirar = "TIRA";
	
	private static final long serialVersionUID = 1L;

	private JTextField nombreJugador;
	
	private JLabel estadoLabel
				,resLabel
				,selecciónLabel
				,lblNewLabel_5
				,casillaLabel
				,lblNewLabel_1;
	
	private JButton modoDesafio
				,modoRapida
				,registraJugador
				,inicioPartida
				,EndButton
				,responderPregunta
				,seguirPartida
				,tiraDado;
	
	private JComboBox<Object> comboBoxOpciones;
	
	private JScrollPane scrollTablero
				,scrollPregunta;
	
	private JTextPane infoCasilla
				,dado
				,nombre
				,puntuacion
				,vidas
				,modoSeleccionado;
	private JComboBox<Object> comboBoxOpciones_1;
	private JTextArea textTablero;

	public JTextPane getModoSeleccionado() {
		return modoSeleccionado;
	}

	/**
	 * Create the panel.
	 */
	public PanelInterno() {
		setBounds(0, 0, 1263, 618);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\static\\archivos\\logo\\logo_oscuro_chico.png"));
		lblNewLabel.setBounds(10, 14, 133, 139);
		add(lblNewLabel);
		
		JLabel nombreAPP = new JLabel("SABELOTODO");
		nombreAPP.setFont(new Font("Tahoma", Font.PLAIN, 46));
		nombreAPP.setBounds(153, 36, 332, 67);
		add(nombreAPP);
		
		JLabel eslogan = new JLabel("EL JUEGO QUE PONE A PRUEBA TUS CONOCIMIENTOS");
		eslogan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eslogan.setBounds(144, 96, 360, 14);
		add(eslogan);
		
		modoDesafio = new JButton("DESAFÍO");
		modoDesafio.setEnabled(false);
		modoDesafio.setBounds(864, 36, 99, 42);
		add(modoDesafio);
		
		modoRapida = new JButton("RÁPIDA");
		modoRapida.setEnabled(false);
		modoRapida.setBounds(973, 36, 90, 42);
		add(modoRapida);
		
		JLabel modoPartidaLabel = new JLabel("Selección del modo de partida:");
		modoPartidaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modoPartidaLabel.setAlignmentY(1.0f);
		modoPartidaLabel.setBounds(864, 11, 199, 14);
		add(modoPartidaLabel);
		
		nombreJugador = new JTextField();
		nombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 23));
		nombreJugador.setColumns(10);
		nombreJugador.setBounds(585, 37, 210, 33);
		add(nombreJugador);
		
		lblNewLabel_1 = new JLabel("Nombre del jugador:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(575, 11, 165, 14);
		add(lblNewLabel_1);
		
		registraJugador = new JButton("registrar");
		registraJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registraJugador.setBounds(706, 71, 89, 39);
		add(registraJugador);
		
		inicioPartida = new JButton("INICIAR PARTIDA");
		inicioPartida.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inicioPartida.setEnabled(false);
		inicioPartida.setBounds(1088, 11, 165, 72);
		add(inicioPartida);
		
		EndButton = new JButton("TERMINAR");
		EndButton.setEnabled(false);
		EndButton.setBounds(1073, 587, 119, 23);
		add(EndButton);
		
		JLabel developpers = new JLabel("PF ENTERTAINMENT");
		developpers.setFont(new Font("Dialog", Font.BOLD, 16));
		developpers.setBounds(10, 587, 258, 19);
		add(developpers);
		
		JLabel partidaLabel = new JLabel("Estado:");
		partidaLabel.setBounds(540, 589, 49, 19);
		add(partidaLabel);
		
		estadoLabel = new JLabel("estadoPartida");
		estadoLabel.setBounds(601, 590, 230, 16);
		add(estadoLabel);
		
		JPanel panel_partida = new JPanel();
		panel_partida.setLayout(null);
		panel_partida.setBackground(SystemColor.inactiveCaptionBorder);
		panel_partida.setBounds(10, 145, 1243, 431);
		add(panel_partida);
		
		comboBoxOpciones = new JComboBox<Object>();
		comboBoxOpciones.setEnabled(false);
		comboBoxOpciones.setBounds(1035, 128, 164, 22);
		panel_partida.add(comboBoxOpciones);
		
		scrollTablero = new JScrollPane();
		scrollTablero.setBounds(30, 39, 481, 381);
		panel_partida.add(scrollTablero);
		
		textTablero = new JTextArea();
		textTablero.setBackground(SystemColor.activeCaption);
		textTablero.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textTablero.setEditable(false);
		scrollTablero.setViewportView(textTablero);
		
		JLabel tableroLabel = new JLabel("TABLERO");
		tableroLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tableroLabel.setBounds(201, 11, 108, 29);
		panel_partida.add(tableroLabel);
		
		JLabel preguntaLabel = new JLabel("PREGUNTA");
		preguntaLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		preguntaLabel.setBounds(552, 11, 146, 29);
		panel_partida.add(preguntaLabel);
		
		selecciónLabel = new JLabel("Selección de la respuesta");
		selecciónLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selecciónLabel.setBounds(1035, 102, 164, 14);
		panel_partida.add(selecciónLabel);
		
		lblNewLabel_5 = new JLabel("DADO");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_5.setBounds(542, 228, 68, 29);
		panel_partida.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_3 = new JLabel("Resultado:");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_3.setBounds(1035, 162, 100, 29);
		panel_partida.add(lblNewLabel_5_3);
		
		infoCasilla = new JTextPane();
		infoCasilla.setFont(new Font("Dialog", Font.PLAIN, 16));
		infoCasilla.setEditable(false);
		infoCasilla.setBounds(542, 382, 344, 38);
		panel_partida.add(infoCasilla);
		
		casillaLabel = new JLabel("CASILLA ACTUAL");
		casillaLabel.setBounds(542, 348, 223, 22);
		panel_partida.add(casillaLabel);
		
		dado = new JTextPane();
		dado.setFont(new Font("Dialog", Font.PLAIN, 73));
		dado.setEditable(false);
		dado.setBounds(617, 228, 118, 108);
		panel_partida.add(dado);
		
		resLabel = new JLabel("res");
		resLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		resLabel.setBounds(1138, 164, 93, 28);
		panel_partida.add(resLabel);
		
		responderPregunta = new JButton("RESPONDER");
		responderPregunta.setEnabled(false);
		responderPregunta.setBounds(1035, 39, 164, 51);
		panel_partida.add(responderPregunta);
		
		JLabel tiempoLabel = new JLabel("TIEMPO:");
		tiempoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tiempoLabel.setBounds(786, 11, 100, 29);
		panel_partida.add(tiempoLabel);
		
		seguirPartida = new JButton("DESPLAZAR FICHA");
		seguirPartida.setFont(new Font("Tahoma", Font.PLAIN, 9));
		seguirPartida.setEnabled(false);
		seguirPartida.setBounds(747, 267, 139, 69);
		panel_partida.add(seguirPartida);
		
		tiraDado = new JButton("TIRAR");
		tiraDado.setEnabled(false);
		tiraDado.setBounds(750, 228, 88, 26);
		panel_partida.add(tiraDado);
		
		JPanel InformacionPanel = new JPanel();
		InformacionPanel.setLayout(null);
		InformacionPanel.setBackground(SystemColor.info);
		InformacionPanel.setBounds(898, 209, 333, 211);
		panel_partida.add(InformacionPanel);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("INFORMACIÓN DE LA PARTIDA");
		lblNewLabel_5_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_2_2.setBounds(6, 5, 320, 28);
		InformacionPanel.add(lblNewLabel_5_2_2);
		
		nombre = new JTextPane();
		nombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		nombre.setEditable(false);
		nombre.setBackground(SystemColor.menu);
		nombre.setBounds(135, 45, 186, 43);
		InformacionPanel.add(nombre);
		
		puntuacion = new JTextPane();
		puntuacion.setFont(new Font("Dialog", Font.PLAIN, 22));
		puntuacion.setEditable(false);
		puntuacion.setBackground(SystemColor.menu);
		puntuacion.setBounds(182, 100, 139, 43);
		InformacionPanel.add(puntuacion);
		
		vidas = new JTextPane();
		vidas.setFont(new Font("Dialog", Font.PLAIN, 22));
		vidas.setEditable(false);
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
		
		scrollPregunta = new JScrollPane();
		scrollPregunta.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPregunta.setBounds(523, 52, 500, 150);
		panel_partida.add(scrollPregunta);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("");
		scrollPregunta.setViewportView(textArea);
		
		JTextPane tiempo = new JTextPane();
		tiempo.setFont(new Font("Dialog", Font.PLAIN, 20));
		tiempo.setEditable(false);
		tiempo.setBackground(SystemColor.menu);
		tiempo.setBounds(884, 11, 93, 38);
		panel_partida.add(tiempo);
		
		
		//registro de comandos
		modoDesafio.setActionCommand(cmdModoDesafio);
		modoRapida.setActionCommand(cmdModoRapida);
		registraJugador.setActionCommand(cmdRegistraJugador);
		inicioPartida.setActionCommand(cmdInicioPartida);
		EndButton.setActionCommand(cmdEndButton);
		responderPregunta.setActionCommand(cmdResponde);
		seguirPartida.setActionCommand(cmdSeguir);
		tiraDado.setActionCommand(cmdTirar);
		
		modoSeleccionado = new JTextPane();
		modoSeleccionado.setEditable(false);
		modoSeleccionado.setBounds(874, 83, 189, 20);
		add(modoSeleccionado);
		
		comboBoxOpciones_1 = new JComboBox<Object>();
		comboBoxOpciones_1.setEnabled(false);
		comboBoxOpciones_1.setModel(new DefaultComboBoxModel(new String[] {"easy", "medium", "difficult"}));
		comboBoxOpciones_1.setBounds(904, 114, 164, 22);
		add(comboBoxOpciones_1);
		
		JLabel lblNewLabel_2 = new JLabel("dificultad");
		lblNewLabel_2.setBounds(777, 120, 90, 14);
		add(lblNewLabel_2);
	}
	
	public JTextArea getTextTablero() {
		return textTablero;
	}

	public JComboBox<Object> getComboBoxOpciones_1() {
		return comboBoxOpciones_1;
	}

	public void addController(Controlador ctr) {
		modoDesafio.addActionListener(ctr);
		modoRapida.addActionListener(ctr);
		registraJugador.addActionListener(ctr);
		inicioPartida.addActionListener(ctr);
		EndButton.addActionListener(ctr);
		responderPregunta.addActionListener(ctr);
		seguirPartida.addActionListener(ctr);
		tiraDado.addActionListener(ctr);
		
	}

	public JTextField getNombreJugador() {
		return nombreJugador;
	}

	public JLabel getEstadoLabel() {
		return estadoLabel;
	}

	public JLabel getResLabel() {
		return resLabel;
	}

	public JLabel getSelecciónLabel() {
		return selecciónLabel;
	}

	public JLabel getLblNewLabel_5() {
		return lblNewLabel_5;
	}

	public JLabel getCasillaLabel() {
		return casillaLabel;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public JButton getModoDesafio() {
		return modoDesafio;
	}

	public JButton getModoRapida() {
		return modoRapida;
	}

	public JButton getRegistraJugador() {
		return registraJugador;
	}

	public JButton getInicioPartida() {
		return inicioPartida;
	}

	public JButton getEndButton() {
		return EndButton;
	}

	public JButton getResponderPregunta() {
		return responderPregunta;
	}

	public JButton getSeguirPartida() {
		return seguirPartida;
	}

	public JButton getTiraDado() {
		return tiraDado;
	}

	public JComboBox<Object> getComboBoxOpciones() {
		return comboBoxOpciones;
	}

	public JScrollPane getScrollTablero() {
		return scrollTablero;
	}

	public JScrollPane getScrollPregunta() {
		return scrollPregunta;
	}

	public JTextPane getInfoCasilla() {
		return infoCasilla;
	}

	public JTextPane getDado() {
		return dado;
	}

	public JTextPane getNombre() {
		return nombre;
	}

	public JTextPane getPuntuacion() {
		return puntuacion;
	}

	public JTextPane getVidas() {
		return vidas;
	}
}

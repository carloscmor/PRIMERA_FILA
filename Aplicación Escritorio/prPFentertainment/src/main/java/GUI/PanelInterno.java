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
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import Modelo.Partida;
import Modelo.Tablero;

import java.awt.Color;

public class PanelInterno extends JPanel {
	/**
	 * componentes y comandos de los botones del panel.
	 */ 
    public static final String cmdModoDesafio = "DESAFIO",
            cmdModoRapida = "RAPIDA",
            cmdRegistraJugador = "REGISTRA",
            cmdInicioPartida = "INICIO",
            cmdEndButton = "TERMINA",
            cmdResponde = "RESPONDE",
            cmdSeguir = "SIGUE",
            cmdTirar = "TIRA",
            cmdVisualizar = "VISUALIZAR";

    private static final long serialVersionUID = 1L;

    private final JTextField nombreJugador;

    private final JLabel estadoLabel;
    private final JLabel resLabel;
    private final JLabel seleccionLabel;
    private final JLabel lblNewLabel_5;
    private final JLabel casillaLabel;
    private final JLabel lblNewLabel_1;

    private final JButton modoDesafio;
    private final JButton modoRapida;
    private final JButton registraJugador;
    private final JButton inicioPartida;
    private final JButton EndButton;
    private final JButton responderPregunta;
    private final JButton seguirPartida;
    private final JButton tiraDado;

    private final JComboBox<Object> comboBoxOpciones;

    private final JScrollPane scrollTablero;
    private final JScrollPane scrollPregunta;

    private final JTextPane infoCasilla;
    private final JTextPane dado;
    private final JTextPane nombre;
    private final JTextPane puntuacion;
    private final JTextPane vidas;
    private final JTextPane modoSeleccionado;
    private final JComboBox<Object> comboBoxOpciones_1;
    private final JTextArea textTablero;


    private final JButton iniciarPregunta;
    private final JTextArea TextPregunta;


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
        nombreJugador.setBounds(531, 37, 288, 33);
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

        estadoLabel = new JLabel("");
        estadoLabel.setBounds(601, 590, 462, 16);
        add(estadoLabel);

        JPanel panel_partida = new JPanel();
        panel_partida.setLayout(null);
        panel_partida.setBackground(SystemColor.inactiveCaptionBorder);
        panel_partida.setBounds(10, 145, 1243, 431);
        add(panel_partida);

        comboBoxOpciones = new JComboBox<>();
        comboBoxOpciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
        comboBoxOpciones.setEnabled(false);
        comboBoxOpciones.setBounds(1150, 127, 81, 38);
        panel_partida.add(comboBoxOpciones);

        scrollTablero = new JScrollPane();
        scrollTablero.setToolTipText("Aquí se muestra el tablero");
        scrollTablero.setAutoscrolls(true);
        scrollTablero.setBounds(10, 37, 522, 383);
        panel_partida.add(scrollTablero);

        textTablero = new JTextArea();
        textTablero.setBackground(UIManager.getColor("inactiveCaption"));
        textTablero.setFont(new Font("Monospaced", Font.PLAIN, 15));
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

        seleccionLabel = new JLabel("Selección de la respuesta");
        seleccionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        seleccionLabel.setBounds(1067, 102, 164, 14);
        panel_partida.add(seleccionLabel);

        lblNewLabel_5 = new JLabel("DADO");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_5.setBounds(561, 209, 68, 29);
        panel_partida.add(lblNewLabel_5);

        JLabel lblNewLabel_5_3 = new JLabel("Resultado:");
        lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5_3.setBounds(1035, 162, 100, 29);
        panel_partida.add(lblNewLabel_5_3);

        infoCasilla = new JTextPane();
        infoCasilla.setFont(new Font("Dialog", Font.PLAIN, 14));
        infoCasilla.setEditable(false);
        infoCasilla.setBounds(542, 382, 344, 38);
        panel_partida.add(infoCasilla);

        casillaLabel = new JLabel("CASILLA ACTUAL");
        casillaLabel.setBounds(544, 360, 223, 22);
        panel_partida.add(casillaLabel);

        dado = new JTextPane();
        dado.setFont(new Font("Dialog", Font.PLAIN, 73));
        dado.setEditable(false);
        dado.setBounds(548, 241, 118, 108);
        panel_partida.add(dado);

        resLabel = new JLabel("");
        resLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        resLabel.setBounds(1138, 164, 93, 28);
        panel_partida.add(resLabel);

        responderPregunta = new JButton("RESPONDER");
        responderPregunta.setEnabled(false);
        responderPregunta.setBounds(1067, 40, 164, 51);
        panel_partida.add(responderPregunta);

        JLabel tiempoLabel = new JLabel("TIEMPO:");
        tiempoLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        tiempoLabel.setBounds(786, 11, 100, 29);
        panel_partida.add(tiempoLabel);

        seguirPartida = new JButton("SEGUIR");
        seguirPartida.setFont(new Font("Tahoma", Font.PLAIN, 9));
        seguirPartida.setEnabled(false);
        seguirPartida.setBounds(758, 302, 128, 69);
        panel_partida.add(seguirPartida);

        tiraDado = new JButton("TIRAR");
        tiraDado.setEnabled(false);
        tiraDado.setBounds(672, 323, 76, 26);
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
        nombre.setFont(new Font("Dialog", Font.PLAIN, 18));
        nombre.setEditable(false);
        nombre.setBackground(SystemColor.menu);
        nombre.setBounds(135, 45, 186, 76);
        InformacionPanel.add(nombre);

        puntuacion = new JTextPane();
        puntuacion.setFont(new Font("Dialog", Font.PLAIN, 22));
        puntuacion.setEditable(false);
        puntuacion.setBackground(SystemColor.menu);
        puntuacion.setBounds(30, 156, 139, 43);
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
        puntuacionLabel.setBounds(30, 132, 112, 21);
        InformacionPanel.add(puntuacionLabel);

        JLabel vidasLabel = new JLabel("VIDAS");
        vidasLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        vidasLabel.setBounds(182, 132, 86, 21);
        InformacionPanel.add(vidasLabel);

        scrollPregunta = new JScrollPane();
        scrollPregunta.setBounds(551, 52, 472, 150);
        panel_partida.add(scrollPregunta);

        TextPregunta = new JTextArea();
        TextPregunta.setBackground(new Color(255, 222, 173));
        TextPregunta.setForeground(Color.BLACK);
        TextPregunta.setFont(new Font("Monospaced", Font.PLAIN, 16));
        TextPregunta.setEditable(false);
        TextPregunta.setText("");
        scrollPregunta.setViewportView(TextPregunta);

        JTextPane tiempo = new JTextPane();
        tiempo.setFont(new Font("Dialog", Font.PLAIN, 20));
        tiempo.setEditable(false);
        tiempo.setBackground(SystemColor.menu);
        tiempo.setBounds(884, 11, 93, 38);
        panel_partida.add(tiempo);

        iniciarPregunta = new JButton("VISUALIZAR PREGUNTA");
        iniciarPregunta.setFont(new Font("Tahoma", Font.PLAIN, 9));
        iniciarPregunta.setEnabled(false);
        iniciarPregunta.setActionCommand("SIGUE");
        iniciarPregunta.setBounds(695, 209, 191, 69);
        panel_partida.add(iniciarPregunta);

        modoSeleccionado = new JTextPane();
        modoSeleccionado.setEditable(false);
        modoSeleccionado.setBounds(874, 83, 189, 20);
        add(modoSeleccionado);

        comboBoxOpciones_1 = new JComboBox<>();
        comboBoxOpciones_1.setEnabled(false);
        comboBoxOpciones_1.setModel(new DefaultComboBoxModel(new String[]{"easy", "medium", "difficult"}));
        comboBoxOpciones_1.setBounds(904, 114, 164, 22);
        add(comboBoxOpciones_1);

        JLabel lblNewLabel_2 = new JLabel("dificultad");
        lblNewLabel_2.setBounds(815, 120, 79, 14);
        add(lblNewLabel_2);

        //registro de comandos
        modoDesafio.setActionCommand(cmdModoDesafio);
        modoRapida.setActionCommand(cmdModoRapida);
        registraJugador.setActionCommand(cmdRegistraJugador);
        inicioPartida.setActionCommand(cmdInicioPartida);
        EndButton.setActionCommand(cmdEndButton);
        responderPregunta.setActionCommand(cmdResponde);
        seguirPartida.setActionCommand(cmdSeguir);
        tiraDado.setActionCommand(cmdTirar);
        iniciarPregunta.setActionCommand(cmdVisualizar);

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
        iniciarPregunta.addActionListener(ctr);

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

    public JLabel getSeleccionLabel() {
        return seleccionLabel;
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

    public JButton getVisualizarPregunta() {
        return iniciarPregunta;
    }

    public JTextArea getTextPregunta() {
        return TextPregunta;
    }

    public JTextPane getModoSeleccionado() {
        return modoSeleccionado;
    }
}

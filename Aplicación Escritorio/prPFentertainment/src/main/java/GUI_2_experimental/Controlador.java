package GUI_2_experimental;

import Modelo.CasillaEspecial;
import Modelo.Partida;
import Modelo.Pregunta;
import Modelo.Tablero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Controlador implements ActionListener {
	
	private Partida partida;
	private PanelInterno panel;
	private Partida.tipo_partida tipo;
	private String nombreJugador;
	private String dificultad;
	private int pos;
	private Pregunta preg;
	private int vidas;
	private boolean laAnteriorEraEspecial;
	private List<String> opciones;
	
	public Controlador(PanelInterno panel) {
		partida = null;
		this.panel = panel;
		vidas = 0;
		laAnteriorEraEspecial = false;
		opciones = null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		switch (cmd) {
			case PanelInterno.cmdRegistraJugador:
				if (!panel.getNombreJugador().getText().isEmpty()) {
					panel.getRegistraJugador().setEnabled(false);
					panel.getNombreJugador().setEnabled(false);

					nombreJugador = panel.getNombreJugador().getText();
					panel.getNombre().setText(nombreJugador);

					panel.getModoDesafio().setEnabled(true);
					panel.getModoRapida().setEnabled(true);

					panel.getEndButton().setEnabled(true);
					panel.getEstadoLabel().setText("");
					panel.getEstadoLabel().setText("Preparando partida");
				}
				break;
			case PanelInterno.cmdModoDesafio:
				tipo = Partida.tipo_partida.desafio;
				panel.getModoDesafio().setEnabled(false);
				panel.getModoRapida().setEnabled(true);
				panel.getModoSeleccionado().setText(panel.getModoDesafio().getText());
				panel.getInicioPartida().setEnabled(true);
				panel.getComboBoxOpciones_1().setEnabled(false);

				break;
			case PanelInterno.cmdModoRapida:
				tipo = Partida.tipo_partida.rapida;
				panel.getModoDesafio().setEnabled(true);
				panel.getModoRapida().setEnabled(false);
				panel.getModoSeleccionado().setText(panel.getModoRapida().getText());
				panel.getInicioPartida().setEnabled(true);
				panel.getComboBoxOpciones_1().setEnabled(true);

				break;
			case PanelInterno.cmdInicioPartida:
				panel.getModoRapida().setEnabled(false);
				panel.getModoDesafio().setEnabled(false);
				panel.getInicioPartida().setEnabled(false);

				panel.getComboBoxOpciones_1().setEnabled(false);
				dificultad = (String) panel.getComboBoxOpciones_1().getSelectedItem();

				partida = new Partida(nombreJugador, tipo, dificultad);

				panel.getEstadoLabel().setText("");
				panel.getEstadoLabel().setText("JUGANDO");
				panel.getPuntuacion().setText("0");
				panel.getVidas().setText(Integer.toString(partida.getJugador().getVidas()));

				panel.getEndButton().setEnabled(true);

				//tablero
				Dimension boardSize = new Dimension(510,373);
				panel.getLayeredPane().setPreferredSize(boardSize);
				
				// Add a chess board to the Layered Pane

				JPanel tablero = new JPanel();
				panel.getLayeredPane().add(tablero, JLayeredPane.DEFAULT_LAYER);

				int rows, cols;

				if (partida.getTablero().getCasillas().size() == Tablero.getTamTableroDesafio()) {
					rows = 5;
					cols = 6;
				} else {
					rows = 4;
					cols = 5;
				}
				GridLayout gl = new GridLayout(rows, cols);
				gl.setVgap(10);
				gl.setHgap(5);
				tablero.setLayout(gl);
				
				tablero.setPreferredSize(boardSize);
				tablero.setBackground(Color.black);
				tablero.setBounds(0, 0, boardSize.width, boardSize.height);
				
				BorderLayout bl = new BorderLayout();

				int cont = 0;
				for (int i = 0; i < rows * cols; i++) {

					JPanel square = new JPanel(bl);

					int index = cont;

					if ((index / cols) % 2 != 0) index = (rows - (index % cols)) + (cols * (index / cols));

					if (partida.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("Sports"))
						square.setBackground(Color.orange);
					else if (partida.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("Science"))
						square.setBackground(Color.green);
					else if (partida.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("Animals"))
						square.setBackground(Color.pink);
					else if (partida.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("General"))
						square.setBackground(Color.CYAN);
					else if (partida.getTablero().getCasillas().get(index).getCategoria().equalsIgnoreCase("History"))
						square.setBackground(Color.yellow);
					else
						square.setBackground(Color.red);

					cont++;

					tablero.add(square);
				}
				
				pos = 0;
				panel.getInfoCasilla().setText(partida.getTablero().getCasillas().get(pos).toString());
				panel.getVisualizarPregunta().setEnabled(true);

				break;
			case PanelInterno.cmdEndButton:

				partida = null;
				tipo = null;
				nombreJugador = null;
				dificultad = null;
				preg = null;
				pos = 0;
				vidas = 0;
				laAnteriorEraEspecial = false;
				opciones = null;

				//botones
				panel.getRegistraJugador().setEnabled(true);
				panel.getNombreJugador().setText("");
				panel.getNombreJugador().setEnabled(true);
				panel.getModoDesafio().setEnabled(false);
				panel.getModoRapida().setEnabled(false);
				panel.getInicioPartida().setEnabled(false);
				panel.getTiraDado().setEnabled(false);
				panel.getResponderPregunta().setEnabled(false);
				panel.getVisualizarPregunta().setEnabled(false);
				panel.getResponderPregunta().setEnabled(false);
				panel.getComboBoxOpciones_1().setEnabled(false);
				panel.getComboBoxOpciones().setEnabled(false);
				panel.getSeguirPartida().setEnabled(false);

				//textos
				panel.getScrollTablero().removeAll();
				panel.getInfoCasilla().setText("");
				panel.getDado().setText("");
				panel.getNombre().setText("");
				panel.getPuntuacion().setText("");
				panel.getVidas().setText("");
				panel.getModoSeleccionado().setText("");
				panel.getTextPregunta().setText("");
				panel.getEstadoLabel().setText("");
				panel.getResLabel().setText("");
				panel.getComboBoxOpciones().removeAllItems();

				break;
			case PanelInterno.cmdVisualizar:

				panel.getVisualizarPregunta().setEnabled(false);
				preg = partida.getTablero().getCasillas().get(pos).getPregunta();

				opciones = preg.getOpciones();//opciones barajas ->¡UNA ÚNICA LLAMADA!, en otro caso falla la app.

				//Motivo -> respuestas barajadas en cada llamada.

				String enunciado = preg.getPregunta().toUpperCase() + "\n";

				StringBuilder sb = new StringBuilder(enunciado);

				int ini = 'a';
				int numOp = opciones.size();

				for (String op : opciones) {
					char c = (char) ini++;
					sb.append("\t").append(c).append(") ").append(op).append("\n");
				}
				panel.getTextPregunta().setText(sb.toString());

				ini = 'a';

				panel.getComboBoxOpciones().setEnabled(true);
				panel.getResponderPregunta().setEnabled(true);
				panel.getComboBoxOpciones().addItem((char) ini);

				for (int i = 1; i < numOp; i++) panel.getComboBoxOpciones().addItem((char) (ini + i));

				break;
			case PanelInterno.cmdResponde:
				panel.getResponderPregunta().setEnabled(false);

				char sel = (char) panel.getComboBoxOpciones().getSelectedItem();
				int N_respuesta = (int) sel - (int) 'a';
				String resp = opciones.get(N_respuesta);

				preg.responderPregunta(resp);

				vidas = partida.getJugador().getVidas();

				if (preg.getAcertada()) {
					partida.getJugador().incrementaPuntuacion(preg.getPuntuacion());
					panel.getResLabel().setText("¡ACIERTO!");
					panel.getPuntuacion().setText("");
					panel.getPuntuacion().setText(Integer.toString(partida.getJugador().getPuntuacion()));

				} else {
					partida.getJugador().decrementaVida();
					panel.getResLabel().setText("FALLO :(");
					panel.getVidas().setText("");
					vidas = partida.getJugador().getVidas();
					panel.getVidas().setText(Integer.toString(vidas));

				}

				panel.getTextPregunta().setText(panel.getTextPregunta().getText() + "\nRESPUESTA-> " + sel + ")" + resp +
						"\nSOLUCIÓN-> " + preg.getSolucion().toUpperCase());
				panel.getComboBoxOpciones().removeAllItems();
				panel.getComboBoxOpciones().setEnabled(false);

				if (vidas == 0) panel.getEstadoLabel().setText("TE HAS QUEDADO SIN VIDAS -> GAME OVER");
				else if (partida.isTerminada()) {
					panel.getEstadoLabel().setText("TERMINASTE LA PARTIDA");

				} else if (partida.getTablero().getCasillas().get(pos) instanceof CasillaEspecial) {
					CasillaEspecial ce = (CasillaEspecial) partida.getTablero().getCasillas().get(pos);
					ce.ActivarEspecial(partida);
					laAnteriorEraEspecial = true;
					panel.getSeguirPartida().setEnabled(true);
					panel.getTiraDado().setEnabled(true);
				} else panel.getTiraDado().setEnabled(true);


				break;
			case PanelInterno.cmdTirar:
				panel.getDado().setText(Integer.toString(partida.getDado().tirar()));
				panel.getTiraDado().setEnabled(false);
				panel.getSeguirPartida().setEnabled(true);

				panel.getTextPregunta().setText("");
				panel.getResLabel().setText("");

				break;
			case PanelInterno.cmdSeguir:
				panel.getSeguirPartida().setEnabled(false);

				if (!laAnteriorEraEspecial) { //todo debe dejar avanzar también con el dado
					int valorDado = partida.getDado().valor();
					partida.avanzarFicha(valorDado);
				}
				laAnteriorEraEspecial = false;

				if(!partida.isTerminada()) {
					pos = partida.getFicha().getPosicion();

					//tablero
					panel.getInfoCasilla().setText(partida.getTablero().getCasillas().get(pos).toString());

					panel.getVisualizarPregunta().setEnabled(true);
				}

				break;
		}
	}
}

package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Modelo.*;

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
		
		if(cmd.equals(PanelInterno.cmdRegistraJugador)) {
			if(!panel.getNombreJugador().getText().equals("")) {
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
		}else if(cmd.equals(PanelInterno.cmdModoDesafio)) {
			tipo = Partida.tipo_partida.desafio;
			panel.getModoDesafio().setEnabled(false);
			panel.getModoRapida().setEnabled(true);
			panel.getModoSeleccionado().setText(panel.getModoDesafio().getText());
			panel.getInicioPartida().setEnabled(true);
			panel.getComboBoxOpciones_1().setEnabled(false);
			
		}else if(cmd.equals(PanelInterno.cmdModoRapida)){
			tipo = Partida.tipo_partida.rapida;
			panel.getModoDesafio().setEnabled(true);
			panel.getModoRapida().setEnabled(false);
			panel.getModoSeleccionado().setText(panel.getModoRapida().getText());
			panel.getInicioPartida().setEnabled(true);
			panel.getComboBoxOpciones_1().setEnabled(true);
			
		}else if(cmd.equals(PanelInterno.cmdInicioPartida)){
			panel.getModoRapida().setEnabled(false);
			panel.getModoDesafio().setEnabled(false);
			panel.getInicioPartida().setEnabled(false);
			
			panel.getComboBoxOpciones_1().setEnabled(false);
			dificultad = (String) panel.getComboBoxOpciones_1().getSelectedItem();
		
			partida = new Partida(nombreJugador, tipo, dificultad);
			
			panel.getEstadoLabel().setText("");
			panel.getEstadoLabel().setText("JUGANDO");
			panel.getPuntuacion().setText("0");
			panel.getVidas().setText( Integer.toString(partida.getJugador().getVidas()) );
			
			panel.getEndButton().setEnabled(true);
			
			panel.getTextTablero().setText(partida.toString());
			pos = 0;
			panel.getInfoCasilla().setText(partida.getTablero().getCasillas().get(pos).toString());
			panel.getVisualizarPregunta().setEnabled(true);
			
		}else if(cmd.equals(PanelInterno.cmdEndButton)) {
			
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
			panel.getTextTablero().setText("");
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
			
		}else if(cmd.equals(PanelInterno.cmdVisualizar)) {
			
			panel.getVisualizarPregunta().setEnabled(false);
			preg = partida.getTablero().getCasillas().get(pos).getPregunta();
			
			opciones = preg.getOpciones();//opciones barajas ->!UNA ÚNICA LLAMADA¡, en otro caso falla la app.
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
			
			for(int i = 1; i < numOp; i++) {
				panel.getComboBoxOpciones().addItem((char) (ini + i));
			}
			
		}else if(cmd.equals(PanelInterno.cmdResponde)) {
			panel.getResponderPregunta().setEnabled(false);
			
			char sel = (char) panel.getComboBoxOpciones().getSelectedItem();
			int N_respuesta = (int) sel - (int) 'a';
			String resp = opciones.get(N_respuesta);
			
			preg.responderPregunta(resp);
			
			vidas = partida.getJugador().getVidas();
			
			if(preg.getAcertada()) {
				partida.getJugador().incrementaPuntuacion( preg.getPuntuacion() );
				panel.getResLabel().setText("¡ACIERTO!");
				panel.getPuntuacion().setText("");
				panel.getPuntuacion().setText( Integer.toString(partida.getJugador().getPuntuacion()) );
				
			}else {
				partida.getJugador().decrementaVida();
				panel.getResLabel().setText("FALLO :(");
				panel.getVidas().setText("");
				panel.getVidas().setText( Integer.toString(vidas - 1) );
				
			}
			
			panel.getTextPregunta().setText(panel.getTextPregunta().getText() + "\nRESPUESTA-> " + sel + ")" + resp + 
					"\nSOLUCIÓN-> " + preg.getSolucion().toUpperCase());
			panel.getComboBoxOpciones().removeAllItems();
			panel.getComboBoxOpciones().setEnabled(false);
			
			if(vidas == 0) {
				panel.getEstadoLabel().setText("TE HAS QUEDADO SIN VIDAS -> GAME OVER");
				
			}else if(pos == partida.getTablero().getCasillas().size() -1) {
				panel.getEstadoLabel().setText("TERMINASTE LA PARTIDA");
				
			}else if(partida.getTablero().getCasillas().get(pos) instanceof CasillaEspecial) {
				CasillaEspecial ce = (CasillaEspecial) partida.getTablero().getCasillas().get(pos);
				ce.ActivarEspecial(partida);
				laAnteriorEraEspecial = true;
				panel.getSeguirPartida().setEnabled(true);
				
			}
				panel.getTiraDado().setEnabled(true);

			
		}else if(cmd.equals(PanelInterno.cmdTirar)) {
			partida.getDado().tirar();
			panel.getDado().setText(Integer.toString(partida.getDado().valor()));
			panel.getTiraDado().setEnabled(false);
			panel.getSeguirPartida().setEnabled(true);
			
			panel.getTextPregunta().setText("");
			panel.getResLabel().setText("");
			
		}else if(cmd.equals(PanelInterno.cmdSeguir)) {
			panel.getSeguirPartida().setEnabled(false);
			
			if(!laAnteriorEraEspecial) {
				int valorDado = partida.getDado().valor();
				partida.avanzarFicha(valorDado);
			}
			laAnteriorEraEspecial = false;
			
			pos = partida.getFicha().getPosicion();
			
			panel.getTextTablero().setText(partida.toString());
			panel.getInfoCasilla().setText(partida.getTablero().getCasillas().get(pos).toString());
			
			panel.getVisualizarPregunta().setEnabled(true);
		}
	}
}

package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Modelo.*;

public class Controlador implements ActionListener {
	
	private Partida partida;
	private PanelInterno panel;
	private Partida.tipo_partida tipo;
	private String nombreJugador;
	private String dificultad;
	
	public Controlador(PanelInterno panel) {
		partida = null;
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(PanelInterno.cmdRegistraJugador)) {
			if(!panel.getNombreJugador().getText().equals("")) {
				panel.getRegistraJugador().setEnabled(false);
				panel.getNombreJugador().setEnabled(false);
				
				String nombreDelJugador = panel.getNombreJugador().getText();
				panel.getNombre().setText(nombreDelJugador);
				
				panel.getModoDesafio().setEnabled(true);
				panel.getModoRapida().setEnabled(true);
				
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
			
			panel.getEndButton().setEnabled(true);
			
			panel.getTextTablero().setText(partida.toString());
		}
	}

}

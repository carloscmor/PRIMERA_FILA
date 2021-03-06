package GUI;

import Modelo.Casilla;
import Modelo.CasillaEspecial;
import Modelo.Partida;
import Modelo.Pregunta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controlador implements ActionListener {

    private Partida partida;
    private final PanelInterno panel;
    private Partida.tipo_partida tipo;
    private String nombreJugador;
    private String dificultad;
    private int pos;
    private Pregunta preg;
    private int vidas;
    private boolean laAnteriorEraEspecial;
    private List<String> opciones;

    Controlador(PanelInterno panel) {
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

                panel.getTextTablero().setText(partida.toString());
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

                break;
            case PanelInterno.cmdVisualizar:

                panel.getVisualizarPregunta().setEnabled(false);
                Casilla casilla = partida.getTablero().getCasillas().get(pos);
                if (casilla instanceof CasillaEspecial && !(pos == 10 || pos == 11 || pos == 22)) {
                    CasillaEspecial ce = (CasillaEspecial) casilla;
                    //no hay pregunta
                    String efecto = ce.ActivarEspecial(partida);
                    laAnteriorEraEspecial = true;
                    panel.getSeguirPartida().setEnabled(true);
                    panel.getVidas().setText("");
                    vidas = partida.getJugador().getVidas();
                    panel.getVidas().setText(Integer.toString(vidas)); //actualizar display de vidas
                    panel.getTextPregunta().setText("??Casilla especial! " + efecto);

                } else {
                    if (casilla instanceof CasillaEspecial) {
                        CasillaEspecial ce = (CasillaEspecial) casilla;
                        ce.ActivarEspecial(partida);
                        panel.getEstadoLabel().setText("??PREGUNTA EXPERTO!");
                    }
                    preg = casilla.getPregunta();

                    opciones = preg.getOpciones();//opciones barajas ->??UNA ??NICA LLAMADA!, en otro caso falla la app.

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
                }
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
                    panel.getResLabel().setText("??ACIERTO!");
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
                        "\nSOLUCI??N-> " + preg.getSolucion().toUpperCase());
                panel.getComboBoxOpciones().removeAllItems();
                panel.getComboBoxOpciones().setEnabled(false);

                if (partida.getFicha().getPosicion() == partida.getTablero().getCasillas().size())
                    partida.terminar();

                if (vidas == 0) panel.getEstadoLabel().setText("TE HAS QUEDADO SIN VIDAS -> GAME OVER");
                else if (partida.isTerminada()) panel.getEstadoLabel().setText("??HAS GANADO!");
                else if (partida.getTablero().getCasillas().get(pos) instanceof CasillaEspecial) {
                    CasillaEspecial ce = (CasillaEspecial) partida.getTablero().getCasillas().get(pos);
                    ce.ActivarEspecial(partida);
                    panel.getEstadoLabel().setText("JUGANDO");
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
                if (partida.getFicha().getPosicion() == partida.getTablero().getCasillas().size())
                    partida.terminar();
                if (partida.isTerminada()) panel.getEstadoLabel().setText("HAS GANADO!");
                else {
                    if (laAnteriorEraEspecial) {
                        panel.getTiraDado().setEnabled(true);
                        laAnteriorEraEspecial = false;
                    } else {
                        int valorDado = partida.getDado().valor();
                        partida.avanzarFicha(valorDado);
                        panel.getVisualizarPregunta().setEnabled(true);
                    }
                    pos = partida.getFicha().getPosicion();

                    panel.getTextTablero().setText(partida.toString());
                    panel.getInfoCasilla().setText(partida.getTablero().getCasillas().get(pos).toString());
                }
                break;
        }
    }
}

package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Modelo.Partida;

public class tableroPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	JLayeredPane layeredPane;
	JPanel tablero;

	public tableroPanel(Partida par) {
		Dimension boardSize = new Dimension(400, 400);

		int tam = par.getTablero().getCasillas().size();
		// Use a Layered Pane for this this application
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);


		
		// Add a chess board to the Layered Pane

		tablero = new JPanel();
		layeredPane.add(tablero, JLayeredPane.DEFAULT_LAYER);

		int rows, cols;

		if (tam == 30) {
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
		
		
	}

	public static void main(String[] args) {
		JFrame frame = new tableroPanel(new Partida("PartidaPrueba"));
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
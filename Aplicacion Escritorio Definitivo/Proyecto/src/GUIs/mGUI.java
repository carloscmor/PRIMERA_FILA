package GUIs;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Modelo.Casilla;
import Modelo.Dado;
import java.awt.Frame;
import java.awt.Color;

public class mGUI {

	public JFrame frame;
	private boolean modo = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mGUI window = new mGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean isSelected() {
		return modo;
	}
	
	/**
	 * Create the application.
	 */
	public mGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Seleccion de modo");
		frame.setExtendedState(Frame.MAXIMIZED_HORIZ);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBounds(new Rectangle(0,0,1920,1080));
		Dado d = new Dado();
		
		
		Casilla cas = new Casilla("Sports",1,"hard");
		
		JLabel lblRespuesta = new JLabel("");
		lblRespuesta.setBounds(205, 56, 359, 14);
		frame.getContentPane().add(lblRespuesta);
		
		JLabel lbl1 = new JLabel("Respuesta: ");
		lbl1.setBounds(128, 56, 70, 14);
		frame.getContentPane().add(lbl1);
		
		JButton opcionA = new JButton("");
		opcionA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRespuesta.setText(opcionA.getText());
				modo = true;
			}
		});
		opcionA.setBounds(96, 105, 143, 29);
		frame.getContentPane().add(opcionA);
		
		JButton opcionB = new JButton("");
		opcionB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRespuesta.setText(opcionB.getText());
			}
		});
		opcionB.setBounds(361, 105, 143, 29);
		frame.getContentPane().add(opcionB);
		
		JButton opcionC = new JButton("");
		opcionC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRespuesta.setText(opcionC.getText());
			}
		});
		opcionC.setBounds(96, 167, 143, 29);
		frame.getContentPane().add(opcionC);
		
		JButton opcionD = new JButton("");
		opcionD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRespuesta.setText(opcionD.getText());
			}
		});
		opcionD.setBounds(361, 167, 189, 29);
		frame.getContentPane().add(opcionD);
		
		
		JLabel lblPregunta = new JLabel("");
		lblPregunta.setBounds(160, 15, 264, 19);
		frame.getContentPane().add(lblPregunta);

		JButton btnInic = new JButton("Generar pregunta");
		btnInic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPregunta.setText(cas.getPregunta().getPregunta());
				List<String> lista = cas.getPregunta().getOpciones();
				opcionA.setText(lista.get(0));
				opcionB.setText(lista.get(1));
				opcionC.setText(lista.get(2));
				opcionD.setText(lista.get(3));
			}
		});
		btnInic.setBounds(10, 11, 140, 23);
		frame.getContentPane().add(btnInic);
		
		
		JLabel lblDado = new JLabel("");
		lblDado.setBounds(10, 85, 46, 14);
		frame.getContentPane().add(lblDado);

		JButton dado = new JButton("Dado");
		dado.setForeground(Color.BLACK);
		dado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = d.tirar();
				if (res < 3) {
					dado.setIcon(new ImageIcon("1.png"));
				} else {
					dado.setIcon(new ImageIcon("5.png"));
				}
				lblDado.setText(String.valueOf(res));
			}
		});
		dado.setIcon(new ImageIcon("C:\\Users\\javih\\Documents\\workspaceJava\\GUI\\descarga.png"));
		dado.setSelectedIcon(null);
		dado.setBounds(144, 218, 300, 300);
		frame.getContentPane().add(dado);
	}
}

package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

public class App {

	private JFrame frmSabelotodo;
	private JTextField textField;

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
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(1164, 584, 89, 23);
		frmSabelotodo.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DESAFÍO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(939, 69, 89, 23);
		frmSabelotodo.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RÁPIDA");
		btnNewButton_2.setBounds(1038, 69, 89, 23);
		frmSabelotodo.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\static\\archivos\\logo\\logo_oscuro_chico.png"));
		lblNewLabel.setBounds(10, 11, 133, 139);
		frmSabelotodo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SABELOTODO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 46));
		lblNewLabel_1.setBounds(153, 33, 332, 67);
		frmSabelotodo.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EL JUEGO QUE PONE A PRUEBA TUS CONOCIMIENTOS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(144, 93, 360, 14);
		frmSabelotodo.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Selección del modo de partida:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel_3.setBounds(933, 44, 199, 14);
		frmSabelotodo.getContentPane().add(lblNewLabel_3);
		
		JPanel panel_partida = new JPanel();
		panel_partida.setBackground(Color.WHITE);
		panel_partida.setBounds(10, 143, 1243, 431);
		frmSabelotodo.getContentPane().add(panel_partida);
		
		textField = new JTextField();
		textField.setBounds(627, 70, 147, 20);
		frmSabelotodo.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre del jugador:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(627, 46, 165, 14);
		frmSabelotodo.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("validar");
		btnNewButton_3.setBounds(784, 69, 89, 23);
		frmSabelotodo.getContentPane().add(btnNewButton_3);
		
		JPanel panel_interno = new JPanel();
	}
}

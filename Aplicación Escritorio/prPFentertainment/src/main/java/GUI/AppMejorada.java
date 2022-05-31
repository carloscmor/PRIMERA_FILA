package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class AppMejorada {

	private JFrame frmSabelotodo;
	private PanelInterno panel_interno;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMejorada window = new AppMejorada();
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
	public AppMejorada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel_interno = new PanelInterno();
		
		frmSabelotodo = new JFrame();
		frmSabelotodo.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\static\\archivos\\logo\\logo_oscuro.png"));
		frmSabelotodo.setTitle("SABELOTODO");
		frmSabelotodo.setBounds(100, 100, 1277, 655);
		
		frmSabelotodo.setLocationRelativeTo(null);
		frmSabelotodo.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSabelotodo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmSabelotodo.setContentPane((JPanel) panel_interno);
		
		panel_interno.addController(new Controlador(panel_interno));
	}
}

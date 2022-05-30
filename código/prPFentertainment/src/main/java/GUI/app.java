package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class app {

	private JFrame frmSabelotodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
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
	public app() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSabelotodo = new JFrame();
		frmSabelotodo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\carlo\\Documents\\GitHub\\PRIMERA_FILA\\código\\prPFentertainment\\src\\main\\resources\\static\\archivos\\logo\\logo_oscuro.png"));
		frmSabelotodo.setTitle("SABELOTODO");
		frmSabelotodo.setBounds(100, 100, 1277, 655);
		frmSabelotodo.setLocationRelativeTo(null);
		frmSabelotodo.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSabelotodo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSabelotodo.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1243, 596);
		frmSabelotodo.getContentPane().add(panel);
	}
}

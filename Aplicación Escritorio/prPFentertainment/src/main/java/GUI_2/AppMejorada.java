package GUI_2;

import javax.swing.*;
import java.awt.*;

public class AppMejorada {

	private JFrame frmSabelotodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				AppMejorada window = new AppMejorada();
				window.frmSabelotodo.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	private AppMejorada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PanelInterno panel_interno = new PanelInterno();
		
		frmSabelotodo = new JFrame();
		frmSabelotodo.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\static\\archivos\\logo\\logo_oscuro.png"));
		frmSabelotodo.setTitle("SABELOTODO");
		frmSabelotodo.setBounds(100, 100, 1277, 655);
		
		frmSabelotodo.setLocationRelativeTo(null);
		frmSabelotodo.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSabelotodo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmSabelotodo.setContentPane(panel_interno);
		
		panel_interno.addController(new Controlador(panel_interno));
	}
}

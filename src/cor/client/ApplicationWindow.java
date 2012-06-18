package cor.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cor.helpsystem.HelpHandler;

/**
 * An application that shows a dialogue with a help system.
 * 
 * @author Patrick Schwab
 */
public class ApplicationWindow implements HelpHandler {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new ContactDialogue(this);
		frame.setTitle("Dialog Fenster");
		frame.setBounds(800, 600, 250, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * The application is the last HelpHandler in the Chain Of Responsibility, it will always handle a request.
	 */
	@Override
	public void handleHelp() {
		System.out.println("The " + this.getClass().getName() + " responded to the help request.");
		
		JOptionPane.showMessageDialog(frame, "The application can always help you.");
	}
}

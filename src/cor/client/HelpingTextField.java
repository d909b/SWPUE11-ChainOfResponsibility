package cor.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import cor.helpsystem.HelpHandler;


/**
 * A Text Field with a Chain of Responsibility based help system.
 * 
 * @author Patrick Schwab
 */
public class HelpingTextField extends JTextField implements HelpHandler, KeyListener {
	HelpHandler successor;

	/**
	 * Constructs a HelpingTextField with its __parent__ in the Chain of Responsibility.
	 * 
	 * @param parent
	 */
	public HelpingTextField(HelpHandler parent) {
		super();
		successor = parent;
		
		addKeyListener(this);
	}
	
	/**
	 * No specific help window has been implemented for the generic text field.
	 */
	@Override
	public void handleHelp() {
		System.out.println("The " + this.getClass().getName() + " passed the help request up to its successor.");
		successor.handleHelp();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// NOP
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_F2) {
			handleHelp();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// NOP
	}
}

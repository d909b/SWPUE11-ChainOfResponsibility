package cor.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import cor.helpsystem.HelpHandler;

/**
 * A Contact edit dialogue with a Chain of Responsibility based help system.
 * 
 * @author Patrick Schwab
 */
public class ContactDialogue extends JFrame implements HelpHandler, KeyListener, ActionListener {
	HelpHandler successor;

	/**
	 * Constructs a ContactDialogue with its __parent__ in the Chain of Responsibility.
	 * 
	 * @param parent
	 */
	public ContactDialogue(HelpHandler parent) {
		successor = parent;
		
		addKeyListener(this);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		JButton btnSave = new JButton("Speichern");
		btnSave.setActionCommand("SAVE");
		btnSave.addActionListener(this);
		
		JButton btnCancel  = new JButton("Abbrechen");
		btnCancel.setActionCommand("CANCEL");
		btnCancel.addActionListener(this);
		
		buttons.add(btnCancel);
		buttons.add(btnSave);
		
		JLabel name, adress, email, phone;
		
		name = new JLabel("Name: ");
		adress = new JLabel("Adresse: ");
		email = new JLabel("E-mail: ");
		phone = new JLabel("Telefon: ");
		
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		
		labels.add(name);
		labels.add(adress);
		labels.add(email);
		labels.add(phone);
		
		ArrayList<HelpingTextField> texts = new ArrayList<HelpingTextField>();
		for(int i = 0; i < labels.size(); ++i) {
			texts.add(new HelpingTextField(this));
		}
		
		add(new GenericAddEditFormView(buttons, labels, texts));
	}
	
	/**
	 * The contact dialogue has a help screen and thus can handle help requests.
	 */
	@Override
	public void handleHelp() {
		System.out.println("The " + this.getClass().getName() + " responded to the help request.");
		JOptionPane.showMessageDialog(null, "The contact dialogue's help window.");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// NOP
	}

	/**
	 * Issue a help request every time F2 is pressed.
	 */
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("SAVE") || e.getActionCommand().equals("CANCEL")) {
			System.exit(0);
		}
	}

}

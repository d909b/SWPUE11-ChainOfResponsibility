package cor.client;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class GenericAddEditFormView extends JPanel {
	public GenericAddEditFormView(ArrayList<JButton> buttons, ArrayList<JLabel> labels, ArrayList<HelpingTextField> texte) {
		setBackground(SystemColor.control);
		JPanel springLayout = new JPanel(new SpringLayout());
		
		int numLabels = labels.size();
		
		//Create and populate the panel.
		for (int i = 0; i < numLabels; i++) {
		    springLayout.add(labels.get(i));
		    springLayout.add(texte.get(i));
		}

		for(JButton button : buttons) {
			springLayout.add(button);
		}
		
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(springLayout,
		                                numLabels+1, 2, //rows +1 because of button row, cols
		                                6, 6,        //initX, initY
		                                6, 6);       //xPad, yPad
		this.add(springLayout);
	}
}

package cor.helpsystem;

/**
 * The HelpHandler interface defines the method a widget must respond to after a help request has been issued.
 * 
 * @author Patrick Schwab
 */
public interface HelpHandler {
	/**
	 * Called whenever a help request is issued.
	 */
	void handleHelp();
}

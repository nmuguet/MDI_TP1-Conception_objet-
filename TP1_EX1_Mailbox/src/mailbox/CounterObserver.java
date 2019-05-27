package mailbox;

import javax.swing.JLabel;

public class CounterObserver extends JLabel implements Observer {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void update(Subject subject) {
		int nbr = ((MailBox)subject).getNbreMail(); 
		this.setText("N° :"+nbr);	
	}

}

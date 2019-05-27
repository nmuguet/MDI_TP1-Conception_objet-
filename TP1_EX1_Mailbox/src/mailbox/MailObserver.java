package mailbox;

import javax.swing.JLabel;

public class MailObserver extends JLabel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void update(Subject subject) {
		String str = ((MailBox)subject).getLastMail().getSubject(); 
		this.setText("Sujet :"+str);
		
	}

}

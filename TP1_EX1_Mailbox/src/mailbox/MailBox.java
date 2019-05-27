package mailbox;

import java.util.ArrayList;
import java.util.List;

public class MailBox extends Subject {

	
	private MailBox() {
		observers= new ArrayList<Observer>();
	}

	private static MailBox instance = null;

	public static MailBox getInstance() {
		if (instance == null)
			instance = new MailBox();
		return instance;
	}

	List<Mail> mail = new ArrayList<Mail>();

	// new message
	public void addMail(Mail m) {

		this.mail.add(m);
		this.notifyObservers();
	}

	public Mail getLastMail() {
		return this.mail.get(mail.size() - 1);
	}

	public Integer getNbreMail() {
		return mail.size();
	}
	
	public boolean isEmpty() {
		return mail.size()==0;
	}

	@Override
	public void attach(Observer ob) {
		this.observers.add(ob);
	}

	@Override
	public void detach(Observer ob) {
		this.observers.remove(ob);
	}

	@Override
	public void notifyObservers() {
		for (Observer ob : this.observers) {
			ob.update(this);
		}
	}

}

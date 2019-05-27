package mailbox;

import java.util.ArrayList;

public abstract class Subject{
	
	public ArrayList<Observer> observers ;
	
	public abstract void attach(Observer ob);
	
	public abstract void detach(Observer ob);
	
	public abstract void notifyObservers();
	
}

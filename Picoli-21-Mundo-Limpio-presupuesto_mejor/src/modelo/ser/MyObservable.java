package modelo.ser;

import java.util.Observable;

public class MyObservable extends Observable {
	public void notifica(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}
}

package ensayos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import modelo.ser.Ser;

public class EstadoEnsayo {
	public ArrayList<Ser> seres = new ArrayList<>();
	public ArrayList<Ser> menores = new ArrayList<>();
	public ArrayList<Ser> adultos = new ArrayList<>();
	public ArrayList<Ser> ancianos = new ArrayList<>();

	private Observer adultoObserver = new Observer() {
		@Override
		public void update(Observable o, Object arg) {
			adultos.add(menores.remove(menores.indexOf(arg)));
		}

	};
	private Observer ancianoObserver = new Observer() {

		@Override
		public void update(Observable o, Object arg) {
			ancianos.add(adultos.remove(adultos.indexOf(arg)));
		}
	};

	public EstadoEnsayo() {
		super();
		Ser ser = new Ser();
		addSer(ser);
		ser.addAdultoObserver(adultoObserver);
		ser.addAncianoObserver(ancianoObserver);
	}

	private void addSer(Ser ser) {
		menores.add(ser);
		seres.add(ser);
	}

	public void envejecer() {
		for (Iterator iterator = seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			ser.envejecer();
		}
	}

}

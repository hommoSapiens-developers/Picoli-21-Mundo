package modelo.estado;

import java.util.ArrayList;

import modelo.ser.Adulto;
import modelo.ser.Comportamiento;
import modelo.ser.Ser;

//Se encarga de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial {
	

	public MinisterioSocial(ArrayList<Ser> seres, ArrayList<Ser> menores, 
	ArrayList<Ser> ancianos, ArrayList<Ser> parados) {
		super();
		envejecer(seres);
	}

	public void envejecer(ArrayList<Ser> seres) {
		for (Ser ser : seres) {
			ser.envejecer();
//			si yo añado el mismo ser a dos listas, si cambia en una, lo hara en la otra.
		}
		
	}
}

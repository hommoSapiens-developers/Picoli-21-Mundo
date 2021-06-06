package modelo.estado;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.ser.Menor;
import modelo.ser.Ser;

//Se encarga de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial {
	ArrayList<Menor> menores = new ArrayList<Menor>(); 
	ArrayList<Ser> ancianos = new ArrayList<Ser>();
	
	public MinisterioSocial() {
		super();
		alimentarSeresSocial();
	}

	public void alimentarSeresSocial() {
		alimentarMenores();
		alimentarAncianos();
	}
//	public void envejecerParados() {
//		if (!(this.parados.isEmpty())) {
//			Ser[] arrayParados=(Ser[]) pasarArray();
//			for (int i = 0; i <arrayParados.length ; i++) {
//				arrayParados[i].envejecer();
//			}
//		}
//	}
	
	private void alimentarMenores() {
		if (!menores.isEmpty()) {
			
		for (Iterator<Menor> iterator = menores.iterator(); iterator.hasNext();) {
			Menor ser = iterator.next();
			 ser.alimentar(ser.getSueldo(), ser.getEsperanzaVida());
			}
		}
	}
	private void alimentarAncianos() {
		if (!(this.ancianos.isEmpty())) {
			for (Ser ser : ancianos) {
				ser.comportamiento.alimentar(ser.getSueldo(), ser.getEsperanzaVida());
			}
		}
	}

	public long getSizeMenores() {
		
		return (long)this.menores.size();
	}
	
	public long getSizeAncianos() {
		
		return (long)this.ancianos.size();
	}
	

	
	public ArrayList<Menor> getListaMenores() {
		return this.menores;
	}
	public ArrayList<Ser> getListaAncianos() {
		return this.ancianos;
	}



}

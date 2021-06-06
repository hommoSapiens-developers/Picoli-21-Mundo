package modelo.estado;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.ser.Adulto;
import modelo.ser.Menor;
import modelo.ser.Ser;
import presentador.Estado;

//Se encarga de los trabajadores y parados
//porque se encarga de contratar y despedir
public class MinisterioIndustria {
	private ArrayDeque<Adulto> trabajadores = new ArrayDeque<Adulto>();	
	private ArrayDeque<Adulto> parados = new ArrayDeque<Adulto>();
	
	public void envejecer() {
		//	TODO	
		//no le entra nada por que tenemos en esta clase la lista de los trabajadores.
		Adulto trabajador=trabajadores.getFirst();
		
	}
	public void contratar(ArrayList<Ser> trabajadores, ArrayList<Ser> parados) {
		//		TODO
//		teneis los metodos para la lista de parados y el de trabajadores esta hecho,
//		por si lo necesitamos en otra clase o en el propio estado.
	}
	public long getSizeTrabajadores() {
		return (long)this.trabajadores.size();
	}
	public long getSizeParados() {
		return (long)this.parados.size();
	}
	public ArrayDeque<Adulto> getListaParados() {	
		return this.parados;
	}
	
	public ArrayDeque<Adulto> getListaTrabajadores(){
		return this.trabajadores;
	}
	
//	public void establecerSueldoTrabajador(ArrayList<Ser>seres) {
//		Estado estado;
//			seres.get(0).setSueldo();
//		
//	}
	
	public float getPotenciaTrabajador() {
		return trabajadores.getFirst().getPotenciaTrabajador();
	}
}
	
	


package presentador;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.estado.MinisterioHacienda;
import modelo.estado.MinisterioIndustria;
import modelo.estado.MinisterioSocial;
import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import modelo.ser.Menor;
import modelo.ser.Ser;

public class Estado {
	private int periodo = 0;
	// Lo que le piden al estado que fabrique
	private long demanda = 0;
	private Stack<Long>demandasPeriodo = new Stack<Long>();
	//tambien a parte de la demanda tenemos un coste	
	
	// el aumento de produccion en este periodo
	private float porcentajeAumento;
	
	// lo cantidad que puede producir el estado
	private long produccionPotencial = 0;
	// lo que realmente produce el estado
	private long produccion;
	
	// dinero que tiene el estado o deuda
	private long capital = 0;
	private int seresMuertos = 0;
	private final ArrayList<Ser> seres = new ArrayList<>();
	
	private MinisterioSocial social = new MinisterioSocial();
	private MinisterioIndustria industria = new MinisterioIndustria();
	private MinisterioHacienda hacienda = new MinisterioHacienda();
	public Estado(long demanda) {
		for (int i = 0; i < demanda / getPotenciaTrabajador(); i++) {
			naceSer();
		}
		// Esto es la historia
//		int historia = 0;
		do {
			terminarPeriodo();
			comenzarPeriodo();
			periodo++;
		} while (periodo < 120);
	}

	private void comenzarPeriodo() {
		// TODO Auto-generated method stub
		incrementoDemanda(periodo);
		agregarDemanda();
		long trabajadoresNecesarios=demanda-getProduccionPotencial();
		contratar(trabajadoresNecesarios);
		long trabajadoresFaltantes=trabajadoresNecesarios-industria.getSizeTrabajadores();
		establecerNacimientos(trabajadoresFaltantes);
	}

	private void terminarPeriodo() {
		// TODO Auto-generated method stub
		capital+=calculamosProduccionPeriodica();
		capital-=pagarCostesFabricacion();
		Presupuesto presupuesto=new Presupuesto(social.getSizeMenores(), social.getSizeAncianos(),
		industria.getSizeTrabajadores(), getListaParados());
		presupuesto.establecerPorcentajes(capital);
		capital-=presupuesto.getTotal();
		social.alimentarSeresSocial();
		envejecerSeres();
	}
	
	private void establecerNacimientos(long trabajadoresFaltantes) {
		if (this.demanda>this.produccion) {
			contratar(trabajadoresFaltantes);
//				contratar esta aun por hacer.
				
			}else if(this.demanda>this.getProduccionPotencial()){
					contratar(trabajadoresFaltantes);
//					contratar esta aun por hacer.
					trabajadoresFaltantes+=nacimientosPorProduccion();
			}else {
				contratar(trabajadoresFaltantes);
				
			trabajadoresFaltantes=reduccionNacimientos();
			}
		}
	
	private long mediaDemanda() {
		int nPeriodos=5;
		int totalDemanda=0;
		for (int i = 0; i < nPeriodos; i++) {
			totalDemanda+=this.demandasPeriodo.indexOf((long)i);
		}
		return (long)totalDemanda/nPeriodos;
	}
	
	
	private int nacimientosPorProduccion() {
		long necesidad=mediaDemanda()-produccionPotencial;
		float seresAnacer=necesidad/getPotenciaTrabajador();
		if (seresAnacer<1) {
			return 0;
		}return Math.round(seresAnacer);
//		si la produccion potencial supera a la demanda hay que reducir los nacimientos.
	}
	
	
	private int calculaNumeroFallecimientos() {
//		no esta acabado, ya que habria que hacer que los seres murieran, no solo borrarlos.
		this.seresMuertos=0;
		for (Iterator<Ser> iterator = seres.iterator(); iterator.hasNext();) {
				Ser ser = (Ser) iterator.next();
				if (!ser.isAlive()) {
					iterator.remove();
					seresMuertos++;
				}	
		}
		return this.seresMuertos;
	}
	private int reduccionNacimientos() {
//		TODO
//		esta reduccion debe ser drástica, tanto como n/2 periodos.
//		los valores sobre los periodos de calculo podrian ser definidos por el usuario
		return calculaNumeroFallecimientos()/2;
		
		
	}

	private long getProduccionPotencial() {		
	return this.produccionPotencial=industria.getSizeTrabajadores()+industria.getSizeParados()*getPotenciaTrabajador();
	}

	private void contratar(long trabajadoresNecesarios) {
		// TODO Auto-generated method stub
		// creo que es del ministerio de hacienda
//		en el caso de que se deban de contratar mas, necesitaremos saber cuantos trabajadores tenemos en cada
//		factoria y decidir si hay que reorganizar el número y tamaño de estas.
//		los nuevos tabajadores seran adjudicados por el estado a las factorias.
		
//		en el caso de despidos, seleccionamos a los trabajadores por ell que menos tiempo lleve 
//		y sacarlos de su factoria. es probable que el estado se vea obligado a cerrar agunas factorias,
//		en este caso los trbajadores que aun le queden la factoria por cerrar deben ser movidos a otras factorias,
//		entraran en la misma con los mas nuevos.
		
//		el cierra de las factorias requiere que los trbajadores sean reubicados a otra factoria por que, 
//		siempre sebemos de saber cuales don los trabajadores que hay en cadda factoria
		
	}



	private void envejecerSeres() {
		for (Ser ser :seres) {
			ser.envejecer();
		}
		
	}

	private ArrayDeque<Adulto> getListaParados() {
		return industria.getListaParados();
	}
	
	private ArrayDeque<Adulto> getListaTrabajadores() {
		return industria.getListaTrabajadores();
	}
	
	private ArrayList<Menor> getListaMenores() {
		return social.getListaMenores();
	}

	private long pagarCostesFabricacion() {
		// TODO Auto-generated method stub		
		return -1;
	}

	private long calculamosProduccionPeriodica() {
		// TODO Auto-generated method stub
		return -1;
	}

	private void naceSer() {
		for (Iterator<Ser> iterator = seres.iterator(); iterator.hasNext();) {
			Ser ser= (Ser) iterator.next();
			seres.add(ser);
			getListaMenores().add((Menor)iterator);
		}
	}
	
	
	private long incrementoDemanda(int incremento) {
		return this.demanda+=((demanda*incremento)/100);
	}
	private void agregarDemanda() {
		this.demandasPeriodo.push(this.demanda);
	}

	public int getPotenciaTrabajador() {
		return (int)industria.getPotenciaTrabajador();
	}
	
}

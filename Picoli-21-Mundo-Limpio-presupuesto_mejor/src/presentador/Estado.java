package presentador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.estado.MinisterioSocial;
import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import modelo.ser.Ser;

public class Estado {
	private int periodo = 0;
//	seria mejor tener una lista de demandas para poder tener las ultimas n demandas.
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
	// La cantidad que cada trabajador produce por periodo
	private int potenciaTrabajador = 450;
	// dinero que tiene el estado o deuda
	private long capital = 0;	
	private final ArrayList<Ser> seres = new ArrayList<>();
	private final ArrayList<Ser> menores = new ArrayList<>();
	private final ArrayList<Ser> ancianos = new ArrayList<>();
	private final ArrayList<Ser> trabajadores = new ArrayList<>();
	private final ArrayList<Ser> parados = new ArrayList<>();
	
//	private MinisterioSocial social = new MinisterioSocial(seres, menores, ancianos, trabajadores, parados);

	public Estado(long demanda) {
		for (int i = 0; i < demanda / potenciaTrabajador; i++) {
			naceSer();
//			deberia de estar envejecer en este constructor? ya que ministerio social 
//			se encarga de la gestion de los seres, pero hasta que punto.
		}
		// Esto es la historia
//		int historia = 0;
		do {
//			los ministerios los instanciamos aqui. en el social nada mas que entran los menores y los ancianos.
			comenzarPeriodo();
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
		long trabajadoresFaltantes=trabajadoresNecesarios-trabajadores.size();
		establecerNacimientos(trabajadoresFaltantes);
	}

	private int establecerNacimientos(long trabajadoresFaltantes) {
		//	TODO	
		//	la produccion supera la demanda, los seres sobrantes iran al paro.
		if (this.produccion>this.demanda) {
			 contratar(trabajadoresFaltantes);
			 reduccionNacimientos();
		}
		int total=numeroFallecimientos()+nacimientosPorProduccion();
		
		return -1;
		}
	
	private long mediaDemanda() {
		int nPeriodos=18;
		int totalDemanda=0;
		long ultimosPeriodos=0;
		for (int i = 0; i < nPeriodos; i++) {
			totalDemanda+=this.demandasPeriodo.indexOf(i);
		}
		return totalDemanda/nPeriodos;
	}
	
	
	private int nacimientosPorProduccion() {
		long necesidad=mediaDemanda()-produccionPotencial;
		float seresAnacer=necesidad/potenciaTrabajador;
		if (seresAnacer<1) {
			return 0;
		}return Math.round(seresAnacer);
//		si la produccion potencial supera a la demanda hay que reducir los nacimientos.
	}
	
	
	private int numeroFallecimientos() {
//		no esta acabado, ya que habria que hacer que los seres murieran, no solo borrarlos.
		int seresMuertos=0;
		for (Iterator iterator = seres.iterator(); iterator.hasNext();) {
				Ser ser = (Ser) iterator.next();
				if (!ser.isAlive()) {
					iterator.remove();
					seresMuertos++;
				}	
		}
		return seresMuertos;
	}
	private void reduccionNacimientos() {
//		TODO
//		esta reduccion debe ser drástica, tanto como n/2 periodos.
//		los valores sobre los periodos de calculo podrian ser definidos por el usuario
		
	}

	private long getProduccionPotencial() {		
		return this.produccionPotencial=trabajadores.size()*potenciaTrabajador;
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

	private void terminarPeriodo() {
		// TODO Auto-generated method stub
		capital+=calculamosProduccionPeriodica();
		capital-=pagarCostesFabricacion();
		Presupuesto presupuesto=new Presupuesto(menores.size(), ancianos.size(), trabajadores.size(), 
				getParados());
		presupuesto.establecerPorcentajes(capital);
		capital-=presupuesto.getTotal();
//		ministerio social solo envejece.
		new MinisterioSocial(seres, menores, ancianos, parados);
	}


	private ArrayList<Adulto> getParados() {
		// TODO Auto-generated method stub
		//	Ministerio de industria	
		return null;
	}

	private long pagarCostesFabricacion() {
		// TODO Auto-generated method stub
		// no se si hacienda o industria		
		return 0;
	}

	private long calculamosProduccionPeriodica() {
		// TODO Auto-generated method stub
		// no se si hacienda o industria
		return 0;
	}

	private void naceSer() {
		Ser ser = new Ser();
		seres.add(ser);
		menores.add(ser);	
	}
	
	private long incrementoDemanda(int incremento) {
//		incremento de la demanda a traves del valor que nos entra como porcentaje.
		return this.demanda+=((demanda*incremento)/100);
	}
	private void agregarDemanda() {
//		es una pila
		this.demandasPeriodo.push(this.demanda);
	}
	
}

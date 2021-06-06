package modelo.estado;

import java.util.ArrayDeque;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import presentador.Estado;

//Elabora el presupuesto y decide sobre capital y deuda 
public class MinisterioHacienda {
	private Estado estado;
	private Presupuesto presupuestoHacienda;

	// El ministerio de hacienda va a calcular un capital

	private long capital;

	public MinisterioHacienda(Estado estado, Presupuesto presupuestoHacienda, long capital) {
		super();
		this.estado = estado;
		this.presupuestoHacienda = new Presupuesto(0, 0, 0, new ArrayDeque<Adulto>());
		this.capital = capital;
	}
	


	public long obtieneProduccionPeriodica() {
		long totalProduccion = 0;
		for (int i = 0; i < estado.getCantidadTrabajadores(); i++) {
			totalProduccion += estado.getPotenciaTrabajador(); 
			
		}
		return totalProduccion;
		
		
	}
	
	public void calculaCapital() {
		 long costesFabricacion = 0;
		 capital+=obtieneProduccionPeriodica();
		 capital -= costesFabricacion;
		 presupuestoHacienda.establecerPorcentajes(capital);
		 capital-= presupuestoHacienda.getTotal();
		
		
	}


}

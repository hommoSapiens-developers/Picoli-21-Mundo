package presentador;

import java.util.ArrayList;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;
import modelo.ser.Ser;

public class Estado {
	// Lo que le piden al estado que fabrique
	private long demanda = 0;
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

	public Estado(long demanda) {
		for (int i = 0; i < demanda / potenciaTrabajador; i++) {
			naceSer();
		}
		// Esto es la historia
		int historia = 0;
		do {
			terminarPeriodo();
			comenzarPeriodo();
			historia++;
		} while (historia < 120);
	}

	private void comenzarPeriodo() {
		// TODO Auto-generated method stub
		long trabajadoresNecesarios=demanda-getProduccionPotencial();
		contratar(trabajadoresNecesarios);
		long trabajadoresFaltantes=trabajadoresNecesarios-trabajadores.size();
		establecerNacimientos(trabajadoresFaltantes);
	}

	private void establecerNacimientos(long trabajadoresFaltantes) {
		// TODO Auto-generated method stub
		
	}

	private long getProduccionPotencial() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void contratar(long trabajadoresNecesarios) {
		// TODO Auto-generated method stub
		
	}

	private void terminarPeriodo() {
		// TODO Auto-generated method stub
		capital+=calculamosProduccionPeriodica();
		capital-=pagarCostesFabricacion();
		Presupuesto presupuesto=new Presupuesto(menores.size(), ancianos.size(), trabajadores.size(), 
				getParados());
		presupuesto.establecerPorcentajes(capital);
		capital-=presupuesto.getTotal();
		envejecer();
	}

	private void envejecer() {
		// TODO Auto-generated method stub
		
	}

	private ArrayList<Adulto> getParados() {
		// TODO Auto-generated method stub
		return null;
	}

	private long pagarCostesFabricacion() {
		// TODO Auto-generated method stub
		return 0;
	}

	private long calculamosProduccionPeriodica() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void naceSer() {
		// TODO Auto-generated method stub

	}
}

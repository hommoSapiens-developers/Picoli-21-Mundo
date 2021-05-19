package modelo.ser;

public class Menor implements Comportamiento{
	public float factorDesarrollo;

	@Override
	public float alimentar(int sueldo,float esperanzaVida) {
		// TODO
		System.out.println("soy un menor");
		return esperanzaVida;
	}

	
}

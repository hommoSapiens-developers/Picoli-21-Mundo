package modelo.ser;



public class Menor implements Comportamiento{
	public float factorDesarrollo = 5.5f;

	@Override
	public float alimentar(int sueldo,float esperanzaVida) {
		// TODO ESTO ES CRECER EN EL MENOR
		int necesidadVital=Edades.menor.getNecesidadVital();
		if (sueldo<necesidadVital) {
			factorDesarrollo=(factorDesarrollo*sueldo)/necesidadVital;
		}
		return this.factorDesarrollo;
		}
	public boolean viabilidadMenor() {
		int minimoVieable=55;
		
		return this.factorDesarrollo>minimoVieable ;
		
	}
		
}

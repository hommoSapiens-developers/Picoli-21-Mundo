package modelo.ser;



public class Menor implements Comportamiento{
	public float incrementoFactorDesarrollo = 5.5f;
	private float factorDesarrollo = 55f;
	Ser ser;

	@Override
	public float alimentar(int sueldo,float esperanzaVida) {
		int necesidadVital=Edades.menor.getNecesidadVital();
		if (sueldo<necesidadVital) {
			incrementoFactorDesarrollo=(incrementoFactorDesarrollo*sueldo)/necesidadVital;
			this.factorDesarrollo+=incrementoFactorDesarrollo;
		}
		return esperanzaVida;
		}
	public boolean viabilidadMenor() {
		int minimoVieable=55;
		
		return this.factorDesarrollo>minimoVieable ;
		
	}
	public int getSueldo() {
		
		return ser.getSueldo();
	}
	public float getEsperanzaVida() {
		
		return ser.getEsperanzaVida();
	}
		
}

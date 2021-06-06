package modelo.ser;

public class Adulto implements Comportamiento{
	private long ahorro;
	private float produccionPotencial=450f;	
	
	Ser ser;
	
	
	public long getAhorro() {
		return ahorro;
	}

	public void setAhorro(long ahorro) {
		this.ahorro = ahorro;
	}

	@Override
	public float alimentar(int sueldo,float esperanzaVida) {
		int necesidadVitalSatisfecha = 0;
		int resto = sueldo - Edades.adulto.getNecesidadVital();
			// resto sera -20
			this.ahorro += resto;
			// ahorros -10
			if (ahorro < 0) {
				necesidadVitalSatisfecha = (int) (Edades.adulto.getNecesidadVital() - ahorro);
				this.ahorro = 0;
			}
			
		return recalcularEsperanzaDeVida(sueldo,esperanzaVida);
	}

	private float recalcularEsperanzaDeVida(int sueldo, float esperanzaVida) {
		if (sueldo>=Edades.adulto.getNecesidadVital()) {
			return esperanzaVida;
		}	
		return esperanzaVida-=(float)sueldo/100;	
		
	}

	public long getNecesidad() {
		if(this.ahorro<Edades.adulto.getNecesidadVital()) {
			return Edades.adulto.getNecesidadVital()-this.ahorro;
		}
		return 0;
	}
	
	public float getPotenciaTrabajador() {
		return this.produccionPotencial;
	}
	public int getSueldo() {
		return ser.getSueldo();
	}
	public float getEsperanzaVida() {
		return ser.getEsperanzaVida();
	}
	
}
	

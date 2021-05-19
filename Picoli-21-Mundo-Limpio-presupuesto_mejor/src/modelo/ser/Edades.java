package modelo.ser;

public enum Edades {
	menor(100, 18), adulto(100, 65), anciano(50, 120);

	private int necesidadVital;
	private int edadMaxima;

	private Edades(int necesidadVital, int edadMaxima) {
		this.necesidadVital = necesidadVital;
		this.edadMaxima = edadMaxima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public int getNecesidadVital() {
		return necesidadVital;
	}

}

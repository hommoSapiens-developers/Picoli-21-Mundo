package modelo.presupuesto;

import modelo.ser.Edades;

public class Sector {
	private float porcentajeMinimo;
	private float porcentajeReal;
	private long cantidad;
	private Edades edad;

	public Sector(float porcentajeMinimo, float porcentajeReal, long cantidad, Edades edad) {
		this.porcentajeMinimo = porcentajeMinimo;
		this.cantidad = cantidad;
		this.porcentajeReal = porcentajeReal;
		this.edad=edad;
	}

	public float getPorcentajeMinimo() {
		return porcentajeMinimo;
	}

	public void setPorcentajeMinimo(float porcentajeMinimo) {
		this.porcentajeMinimo = porcentajeMinimo;
	}

	public float getPorcentajeReal() {
		return porcentajeReal;
	}


	public void setPorcentajeReal(long cantidadReal) {
		this.porcentajeReal = cantidadReal*porcentajeMinimo/getCantidadMinima();
		
	}

	public long getCantidadMinima() {
		return (long) (edad.getNecesidadVital()*cantidad *porcentajeMinimo);
	}
	
	public long getCantidadCorregida() {
		return (long) (edad.getNecesidadVital()*cantidad * porcentajeReal);
	}

	public long getCantidadPresupuestada() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

}

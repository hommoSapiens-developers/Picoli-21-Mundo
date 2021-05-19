package modelo.ser;

public class Coordenada {
	private float posX,posY;

	public Coordenada(float posX, float posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	@Override
	public int hashCode() {
		final float prime = 31;
		float result = 1;
		result = prime * result + posX;
		result = prime * result + posY;
		return (int) result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		return true;
	}
	
	public boolean isInToLimits(float ancho, float alto) {
		return posX >= 0 && posY >= 0 && posX < alto && posY < ancho;
	}

}

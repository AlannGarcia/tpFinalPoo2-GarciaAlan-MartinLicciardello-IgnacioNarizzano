package tpFinal.poo2;

public class Area {
	private int latitud;
	private int longitud;
	private int radio;
	
	public Area(int latitud, int longitud, int radio) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.radio = radio;
	}

	public int getLatitud() {
		return latitud;
	}

	public int getLongitud() {
		return longitud;
	}
	
	public int getRadio() {
		return radio;
	}
	
}

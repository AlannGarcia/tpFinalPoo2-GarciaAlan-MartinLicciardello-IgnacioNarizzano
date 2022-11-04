package tpFinal.poo2;

public class Area {
	Ubicacion ubicacion;
	double radio;
	
	
	
	public Area(Ubicacion ubicacion, double radio) {
		super();
		this.ubicacion = ubicacion;
		this.radio = radio;
	}



	public boolean ubicacionPerteneceAArea(Ubicacion ubicacion2) {
		return this.ubicacion.distanciaDeHasta(ubicacion2) <= radio;
	}
	
}

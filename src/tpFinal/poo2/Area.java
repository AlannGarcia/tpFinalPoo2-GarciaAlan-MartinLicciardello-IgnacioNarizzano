package tpFinal.poo2;

public class Area {
	Ubicacion ubicacion;
	double radio;
	
	public boolean ubicacionPerteneceAArea(Ubicacion ubicacion2) {
		return this.ubicacion.distanciaDeHasta(ubicacion2) <= radio;
	}
	
}

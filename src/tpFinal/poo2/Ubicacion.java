package tpFinal.poo2;

public class Ubicacion {
	int x;
	int y;
	
	public Ubicacion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double distanciaDeHasta(Ubicacion ubi) {
		return Math.sqrt((this.x - ubi.x)*(this.x - ubi.x) - ((this.y - ubi.y)*(this.y - ubi.y)));
	}
	
}

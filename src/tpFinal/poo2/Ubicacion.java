package tpFinal.poo2;

public class Ubicacion {
	private int x;
	private int y;
	
	
	public Ubicacion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double distanciaDeHasta(Ubicacion ubi) {
		return Math.sqrt((this.x - ubi.x)*(this.x - ubi.x) + ((this.y - ubi.y)*(this.y - ubi.y)));
	}
}


//d=√((x_2-x_1)²+(y_2-y_1)²) 
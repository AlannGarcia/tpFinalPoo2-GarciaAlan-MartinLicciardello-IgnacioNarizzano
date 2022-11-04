package tpFinal.poo2;

public class Preferencia {
	int cantidadDeMuestras;
	NivelDificultad nivelDif;
	int recompernsasPref;
	
	
	public Preferencia(int cantidadDeMuestras, NivelDificultad nivelDif, int recompernsasPref) {
		super();
		this.cantidadDeMuestras = cantidadDeMuestras;
		this.nivelDif = nivelDif;
		this.recompernsasPref = recompernsasPref;
	}
	
	public Integer cumpleDesafio(Desafio d) {
		return Math.abs(this.cantidadDeMuestras - d.cantidadMuestras);
	}
	
}

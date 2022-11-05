package tpFinal.poo2;

public class Preferencia {
	int cantidadDeMuestras;
	NivelDificultad nivelDif;
	int recompensasPref;
	
	
	public Preferencia(int cantidadDeMuestras, NivelDificultad nivelDif, int recompernsasPref) {
		super();
		this.cantidadDeMuestras = cantidadDeMuestras;
		this.nivelDif = nivelDif;
		this.recompensasPref = recompernsasPref;
	}
	
	public Integer cumpleDesafio(Desafio d) {
		return Math.abs(this.cantidadDeMuestras - d.cantidadMuestras);
	}
	
}

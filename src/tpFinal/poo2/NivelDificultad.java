package tpFinal.poo2;

public enum NivelDificultad {
	MuyFacil, Facil, Intermedio, Dificil, MuyDificil; //se arranca en 0 el ordinal y el enum en 1
	
	public int nivelDificultad() {
		return this.ordinal()+1;
	}

}

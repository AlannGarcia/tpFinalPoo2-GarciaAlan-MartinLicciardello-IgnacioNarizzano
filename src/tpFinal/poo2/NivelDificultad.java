package tpFinal.poo2;

public enum NivelDificultad {
	MUY_FACIL, FACIL, INTERMEDIO, DIFICIL, MUY_DIFICIL; //se arranca en 0 el ordinal y el enum en 1
	
	public int nivelDificultad() {
		return this.ordinal()+1;
	}

}

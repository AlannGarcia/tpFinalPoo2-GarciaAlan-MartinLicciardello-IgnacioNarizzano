package tpFinal.poo2;

import java.util.ArrayList;

public class MisPreferenciasEnJuego implements EstadoRecomendacion{
	
	@Override
	public ArrayList<Desafio> buscarMatchDesafios(Usuario usuario, ArrayList<Desafio> desafios) {
		return usuario.buscarMatchPorPreferencias(desafios);
	}
}

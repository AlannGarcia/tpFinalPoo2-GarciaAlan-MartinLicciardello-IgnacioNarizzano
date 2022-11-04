package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaPreferenciasEnJuego implements EstrategiaRecomedacion{

	@Override
	public List<Desafio> buscarMatchDesafios(Usuario usuario, ArrayList<Desafio> desafios) {
		return usuario.buscarMatchPorPreferencias(desafios);
	}

}

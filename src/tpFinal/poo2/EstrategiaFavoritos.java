package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaFavoritos implements EstrategiaRecomedacion{
    
	@Override
	public List<Desafio> buscarMatchDesafios(Usuario usuario, ArrayList<Desafio> desafios) {
		return usuario.buscarMatchPorFavoritos(desafios);
	}
	
}

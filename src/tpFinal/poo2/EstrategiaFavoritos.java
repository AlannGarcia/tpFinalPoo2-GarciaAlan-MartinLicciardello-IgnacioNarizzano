package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public class EstrategiaFavoritos implements EstrategiaRecomendacion{
    
	@Override
	public List<Desafio> buscarMatchDesafios(Usuario usuario, List<Desafio> desafios) {
		return usuario.buscarMatchPorFavorito(desafios);
	}
	
}

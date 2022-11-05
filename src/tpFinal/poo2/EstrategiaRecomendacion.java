package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public interface EstrategiaRecomendacion {
    
	public List<Desafio> buscarMatchDesafios(Usuario usuario, List<Desafio> desafios);
	
}

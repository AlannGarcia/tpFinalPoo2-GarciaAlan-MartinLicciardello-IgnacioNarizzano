package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public interface EstrategiaRecomedacion {
    
	public List<Desafio> buscarMatchDesafios(Usuario usuario, ArrayList<Desafio> desafios);
	
}

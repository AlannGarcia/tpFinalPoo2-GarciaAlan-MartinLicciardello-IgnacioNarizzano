package tpFinal.poo2.EstrategiaRecomendacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tpFinal.poo2.Desafio;
import tpFinal.poo2.DesafioDeUsuario;
import tpFinal.poo2.Preferencia;

public abstract class EstrategiaRecomendacion {
    
	public abstract List<Desafio> buscarMatchDesafios( List<Desafio> desafios, List<DesafioDeUsuario> desafiosDeUsuario, Preferencia preferencia);
	
	protected List<Desafio> matchPorPreferencia(List<Desafio> desafios, List<DesafioDeUsuario> desafiosDeUsuario, Preferencia preferencia){
		List<Desafio> desafiosTomados = desafiosDeUsuario.stream().map(d -> d.getDesafio()).toList();//tranformo los desafiosDeUsuario en los desafios que ya estuvo
		List<Desafio> desafiosNoTomados = new ArrayList<Desafio>(desafios);
		desafiosNoTomados.removeAll(desafiosTomados);// desafios no tomados
		return desafiosNoTomados.stream().
				sorted((d1,d2) -> preferencia.cumpleDesafio(d2).// ordeno por preferencia de menor a mayor entre el valor de la suma de todos los valores
						compareTo(preferencia.cumpleDesafio(d1))).//ordeno por el valor abs de 
				collect(Collectors.toList());
	}
}

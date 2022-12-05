package tpFinal.poo2.EstrategiaRecomendacion;

import java.util.List;

import tpFinal.poo2.Desafio;
import tpFinal.poo2.DesafioDeUsuario;
import tpFinal.poo2.Preferencia;

public class EstrategiaFavoritos extends EstrategiaRecomendacion{

	@Override
	public List<Desafio> buscarMatchDesafios(List<Desafio> desafios, List<DesafioDeUsuario> desafiosDeUsuario,
			Preferencia preferencia) {
		
		
		Desafio desafioQueMasGusto = desafiosDeUsuario.stream().max((d1,d2) -> d1.getVoto().compareTo(d2.getVoto())).get().getDesafio();//buscamos el desafio que mmas le gusto al usuario
		List<Desafio> desafioDeMayorCoincidencia = matchPorPreferencia(desafios, desafiosDeUsuario,preferencia).stream().limit(20).//Ordenamos por preferencia y lo limitamos a primeros 20
				sorted((d1,d2)-> this.promedioEntreDistanciasDeValoresDeCoincidencia(d2, desafioQueMasGusto)
						.compareTo(this.promedioEntreDistanciasDeValoresDeCoincidencia(d1, desafioQueMasGusto))).limit(5).toList();
		return desafioDeMayorCoincidencia;// se ordena de menor a mayor;
	}
    
	private Integer promedioEntreDistanciasDeValoresDeCoincidencia(Desafio a, Desafio b) {
		return Math.abs(a.valorDeCoincidencia() - b.valorDeCoincidencia()) / 3;
	}
	
}

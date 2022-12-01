package tpFinal.poo2;

import java.util.List;

public class EstrategiaPreferenciasEnJuego extends EstrategiaRecomendacion{

	@Override
	public List<Desafio> buscarMatchDesafios(List<Desafio> desafios, List<DesafioDeUsuario> desafiosDeUsuario,
			Preferencia preferencia) {
		return this.matchPorPreferencia(desafios, desafiosDeUsuario, preferencia).subList(0, 5);
	}



}

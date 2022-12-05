package tpFinal.poo2.EstrategiaRecomendacion;

import java.util.List;

import tpFinal.poo2.Desafio;
import tpFinal.poo2.DesafioDeUsuario;
import tpFinal.poo2.Preferencia;

public class EstrategiaPreferenciasEnJuego extends EstrategiaRecomendacion{

	@Override
	public List<Desafio> buscarMatchDesafios(List<Desafio> desafios, List<DesafioDeUsuario> desafiosDeUsuario,
			Preferencia preferencia) {
		return this.matchPorPreferencia(desafios, desafiosDeUsuario, preferencia).subList(0, 5);
	}



}

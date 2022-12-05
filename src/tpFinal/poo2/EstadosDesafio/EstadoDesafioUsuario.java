package tpFinal.poo2.EstadosDesafio;

import tpFinal.poo2.DesafioDeUsuario;
import tpFinal.poo2.Muestra;

public abstract class EstadoDesafioUsuario {

	public abstract String evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) ;

	public boolean completoDesafio() {
		return false;
	}

	public String fechaCompletado(DesafioDeUsuario desafioDeUsuario) {
		return "Desafio no fue completado";
	};
}

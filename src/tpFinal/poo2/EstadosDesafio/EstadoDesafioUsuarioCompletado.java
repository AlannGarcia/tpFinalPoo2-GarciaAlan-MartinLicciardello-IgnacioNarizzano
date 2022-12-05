package tpFinal.poo2.EstadosDesafio;

import tpFinal.poo2.DesafioDeUsuario;
import tpFinal.poo2.Muestra;

public class EstadoDesafioUsuarioCompletado extends EstadoDesafioUsuario{

	@Override
	public String evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) {
		return ("El desafio se encuentra completado, no se puede evaluar muestra.");
		
	}
	
	@Override 
	public boolean completoDesafio() {
		return true;
	}

	@Override
	
	public String fechaCompletado(DesafioDeUsuario desafioDeUsuario) {
		return desafioDeUsuario.getFecha().toString();
	}

}

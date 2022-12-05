package tpFinal.poo2.EstadosDesafio;

import tpFinal.poo2.DesafioDeUsuario;
import tpFinal.poo2.Muestra;

public class EstadoDesafioUsuarioInactivo extends EstadoDesafioUsuario{

	@Override
	public String evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) {
		return ("El desafio esta inactivo");
		
	}

}

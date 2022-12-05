package tpFinal.poo2.EstadosDesafio;

import tpFinal.poo2.DesafioDeUsuario;
import tpFinal.poo2.Muestra;

public class EstadoDesafioUsuarioActivo extends EstadoDesafioUsuario{

	@Override
	public String evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) {
		return defUs.evaluarMuestraEnEstadoActivo(muestra);	}
	
}

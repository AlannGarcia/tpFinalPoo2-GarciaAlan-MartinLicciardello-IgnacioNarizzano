package tpFinal.poo2;

public class EstadoDesafioUsuarioActivo extends EstadoDesafioUsuario{

	@Override
	public String evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) {
		return defUs.evaluarMuestraEnEstadoActivo(muestra);	}
	
}

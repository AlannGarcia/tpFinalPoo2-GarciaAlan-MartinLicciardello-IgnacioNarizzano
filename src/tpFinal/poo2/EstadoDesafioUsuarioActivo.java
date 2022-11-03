package tpFinal.poo2;

public class EstadoDesafioUsuarioActivo extends EstadoDesafioUsuario{

	@Override
	public void evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) {
		defUs.evaluarMuestra(muestra);
	}
	
}

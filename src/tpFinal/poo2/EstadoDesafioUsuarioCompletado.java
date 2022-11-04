package tpFinal.poo2;

public class EstadoDesafioUsuarioCompletado extends EstadoDesafioUsuario{

	@Override
	public void evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) throws Exception{
		throw new Exception("El desafio se encuentra completado, no se puede evaluar muestra.");
		
	}

}

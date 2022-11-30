package tpFinal.poo2;

public class EstadoDesafioUsuarioCompletado extends EstadoDesafioUsuario{

	@Override
	public String evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) {
		return ("El desafio se encuentra completado, no se puede evaluar muestra.");
		
	}
	
	@Override 
	protected boolean completoDesafio() {
		return true;
	}

	@Override
	
	protected String fechaCompletado(DesafioDeUsuario desafioDeUsuario) {
		return desafioDeUsuario.getFecha().toString();
	}

}

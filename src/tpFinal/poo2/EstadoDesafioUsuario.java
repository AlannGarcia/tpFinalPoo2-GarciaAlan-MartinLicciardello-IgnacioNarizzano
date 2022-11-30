package tpFinal.poo2;

public abstract class EstadoDesafioUsuario {

	public abstract String evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) ;

	protected  boolean completoDesafio() {
		return false;
	}

	protected  String fechaCompletado(DesafioDeUsuario desafioDeUsuario) {
		return "Desafio no fue completado";
	};
}

package tpFinal.poo2;

public class EstadoDesafioUsuarioInactivo extends EstadoDesafioUsuario{

	@Override
	public void evaluarMuestra(Muestra muestra, DesafioDeUsuario defUs) throws Exception{
		throw new Exception("El desafio esta inactivo");
		
	}

}

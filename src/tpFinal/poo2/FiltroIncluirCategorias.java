package tpFinal.poo2;

import java.util.List;

public class FiltroIncluirCategorias extends FiltroCategorias{

	public FiltroIncluirCategorias(List<Categoria> categorias) {
		super(categorias);
	}

	@Override
	protected boolean condicionDeFiltro(Boolean b, Proyecto p) {
		// TODO Auto-generated method stub
		return !filtroPorProyecto(p);
	}
	
	

}

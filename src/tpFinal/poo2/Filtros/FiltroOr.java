package tpFinal.poo2.Filtros;

import java.util.List;

import tpFinal.poo2.Proyecto;

public class FiltroOr extends FiltroComposite{
	
	public FiltroOr(Filtro a, Filtro b) {
		super(a,b);
		
	}
	
	

	@Override
	protected void filtradoEspecifico(List<Proyecto> ps, List<Proyecto> proyectosFiltrados) {
		// TODO Auto-generated method stub
		ps.addAll(proyectosFiltrados);
	}

}

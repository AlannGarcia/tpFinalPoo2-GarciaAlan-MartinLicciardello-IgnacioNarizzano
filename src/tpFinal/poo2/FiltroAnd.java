package tpFinal.poo2;

import java.util.List;

public class FiltroAnd extends FiltroComposite{

	
	
	public FiltroAnd(Filtro a, Filtro b) {
		super(a,b);
	
	}
	
	@Override
	protected void filtradoEspecifico(List<Proyecto> ps, List<Proyecto> proyectosFiltrados) {
		// TODO Auto-generated method stub
		ps.retainAll(proyectosFiltrados);
	}
	
}

package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

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

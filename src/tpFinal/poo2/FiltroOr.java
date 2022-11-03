package tpFinal.poo2;

import java.util.List;

public class FiltroOr implements Filtro{

	Filtro a;
	Filtro b;
	
	public FiltroOr(Filtro a, Filtro b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		List<Proyecto> proyectoX = a.filtrar(proyectos);
		proyectoX.addAll(b.filtrar(proyectos));
		return proyectoX;
		
	}

}

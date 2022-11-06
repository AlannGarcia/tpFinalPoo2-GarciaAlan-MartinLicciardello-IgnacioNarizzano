package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public class FiltroAnd implements Filtro{
	Filtro a;
	Filtro b;
	
	
	public FiltroAnd(Filtro a, Filtro b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public List<Proyecto> filtrar(List<Proyecto> proyectos){
		List<Proyecto> proyectoX = a.filtrar(proyectos);
		List<Proyecto> ps = new ArrayList<Proyecto>();
		ps.addAll(proyectoX);
		ps.retainAll(b.filtrar(proyectos)); //retainAll hace una interseccion 
		return ps;
	}
	
}

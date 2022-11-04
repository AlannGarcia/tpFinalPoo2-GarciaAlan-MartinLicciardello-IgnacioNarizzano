package tpFinal.poo2;

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
		proyectoX.retainAll(b.filtrar(proyectos)); //rainAll hace una interseccion 
		return proyectoX;
	}
	
}

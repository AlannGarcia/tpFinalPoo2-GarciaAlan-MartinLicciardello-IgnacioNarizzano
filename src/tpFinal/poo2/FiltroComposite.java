package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public abstract class FiltroComposite implements Filtro{

	private Filtro a;
	private Filtro b;
	
	public FiltroComposite(Filtro a, Filtro b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	
public final List<Proyecto> filtrar(List<Proyecto> proyectos) {
    List<Proyecto> proyectosCopiados = new ArrayList<Proyecto>(proyectos);
	List<Proyecto> proyectosFiltrados = b.filtrar(proyectosCopiados);
	List<Proyecto> proyectoX = a.filtrar(proyectosCopiados);
	this.filtradoEspecifico(proyectoX,proyectosFiltrados);
	return proyectoX;

}	
	


protected abstract void filtradoEspecifico(List<Proyecto> ps, List<Proyecto> proyectosFiltrados);


}

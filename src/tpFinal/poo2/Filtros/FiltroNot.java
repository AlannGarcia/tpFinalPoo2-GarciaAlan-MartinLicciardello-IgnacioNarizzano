package tpFinal.poo2.Filtros;

import java.util.ArrayList;
import java.util.List;

import tpFinal.poo2.Proyecto;

public class FiltroNot implements Filtro{
	private Filtro filtro;

	public FiltroNot(Filtro filtro) {
		super();
		this.filtro = filtro;
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		List<Proyecto> proyectosCopiados = new ArrayList<Proyecto>(proyectos);
		proyectosCopiados.removeAll(filtro.filtrar(proyectos));
		return proyectosCopiados;
	}
	
	//resta de conjuntos a los proyectos dos, le resto proyectos filtrados
	
		//ej en titulo me va a traer algo que no incluya en el titulo
}

package tpFinal.poo2;

import java.util.List;

public class FiltroNot implements Filtro{
	Filtro filtro;

	public FiltroNot(Filtro filtro) {
		super();
		this.filtro = filtro;
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		List<Proyecto> proyectoDos = proyectos;
		proyectoDos.removeAll(filtro.filtrar(proyectos));
		return proyectoDos;
	}
	
	
}

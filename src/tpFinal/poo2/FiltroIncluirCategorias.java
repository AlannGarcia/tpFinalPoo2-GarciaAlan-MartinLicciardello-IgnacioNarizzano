package tpFinal.poo2;

import java.util.Collections;
import java.util.List;

public class FiltroIncluirCategorias implements Filtro{
	List<Categoria> categorias;

	public FiltroIncluirCategorias(List<Categoria> categorias) {
		super();
		this.categorias = categorias;
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		List<String> filtroNombres = categorias.stream().map(n -> n.getNombre()).toList();
		return proyectos.stream().filter(d -> !Collections.disjoint((d.categorias.stream().map( n -> n.getNombre()).toList()), filtroNombres)).toList();
	
	}
	
	

}

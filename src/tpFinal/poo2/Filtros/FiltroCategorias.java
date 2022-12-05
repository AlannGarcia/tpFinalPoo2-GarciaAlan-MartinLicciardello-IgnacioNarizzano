package tpFinal.poo2.Filtros;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import tpFinal.poo2.Categoria;
import tpFinal.poo2.Proyecto;

public abstract class FiltroCategorias implements Filtro {
    
	private List<Categoria> categorias;

	public FiltroCategorias(List<Categoria> categorias) {
		super();
		this.categorias = categorias;
	}

	public final List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		return proyectos.stream().filter(p ->condicionDeFiltro(p)).collect(Collectors.toList());
	}
	
	
	private List<String> nombresDeCategorias() {
		return categorias.stream().map(n -> n.getNombre()).toList();
	}
	
    protected abstract boolean condicionDeFiltro(Proyecto p);
    
    protected boolean filtroPorProyecto(Proyecto p) {
    	return Collections.disjoint((p.getCategorias().stream().map(n -> n.getNombre()).toList()), nombresDeCategorias());
    }
}


package tpFinal.poo2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FiltroCategorias implements Filtro {
    
	private List<Categoria> categorias;

	public FiltroCategorias(List<Categoria> categorias) {
		super();
		this.categorias = categorias;
	}

	public final List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		return proyectos.stream().filter(p ->condicionDeFiltro(filtroPorProyecto(p), p)).collect(Collectors.toList());
	}
	
	
	private List<String> nombresDeCategorias() {
		return categorias.stream().map(n -> n.getNombre()).toList();
	}
	
    protected boolean condicionDeFiltro(Boolean b, Proyecto p) {
    	return b;
    }
     
    
    protected boolean filtroPorProyecto(Proyecto p) {
    	return Collections.disjoint((p.categorias.stream().map(n -> n.getNombre()).toList()), nombresDeCategorias());
    }
}


package tpFinal.poo2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FiltroExcluirCategorias implements Filtro{
	
	private List<Categoria> categorias;

		public FiltroExcluirCategorias(List<Categoria> categorias) {
			super();
			this.categorias = categorias;
		}

		@Override
		public List<Proyecto> filtrar(List<Proyecto> proyectos) {
			List<String> filtroNombres = categorias.stream().map(n -> n.getNombre()).toList();
			
			return proyectos.stream().filter(d ->Collections.disjoint((d.categorias.stream().map(n -> n.getNombre()).toList()), filtroNombres)).collect(Collectors.toList());
		}//si el proyecto no contiene ninguna de las categorias que me interesa, me las devuelve
}

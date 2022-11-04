package tpFinal.poo2;

import java.util.Collections;
import java.util.List;


import java.util.Collections;
import java.util.List;

public class FiltroExcluirCategorias implements Filtro{
	
		List<Categorias> categorias;

		public FiltroExcluirCategorias(List<Categorias> categorias) {
			super();
			this.categorias = categorias;
		}

		@Override
		public List<Proyecto> filtrar(List<Proyecto> proyectos) {
			List<String> filtroNombres = categorias.stream().map(n -> n.getNombre()).toList();
			
			return proyectos.stream().filter(d ->Collections.disjoint((d.categorias.stream().map(n -> n.getNombre()).toList()), filtroNombres)).toList();
		}//si el proyecto no contiene ninguna de las categorias que me interesa, me las devuelve
}

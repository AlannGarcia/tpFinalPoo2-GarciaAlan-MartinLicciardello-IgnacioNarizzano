package tpFinal.poo2.Filtros;

import java.util.List;

import tpFinal.poo2.Categoria;
import tpFinal.poo2.Proyecto;


public class FiltroExcluirCategorias extends FiltroCategorias{
	

		public FiltroExcluirCategorias(List<Categoria> categorias) {
			super(categorias);
		}		
		
		@Override
		protected boolean condicionDeFiltro(Proyecto p) {
			// TODO Auto-generated method stub
			return filtroPorProyecto(p);
		}
}

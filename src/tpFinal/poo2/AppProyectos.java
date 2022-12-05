package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

import tpFinal.poo2.Filtros.Filtro;

public class AppProyectos {
    private List<Proyecto> proyectos = new ArrayList<Proyecto>();
    
    public void agregarProyecto(Proyecto p) {
    	proyectos.add(p);
    }

	public List<Proyecto> getProyectos() {
		return proyectos;
	}
    
    /**
     * Realiza una busqueda entre los proyectos registrados
     * con el filtro dado por parametro
     * @param f filtro para realizar la busqueda
     * @return Lista de proyectos que cumple con los requerimientos del filtro
     */
    public List<Proyecto> buscarProyectosConFiltro(Filtro f) {
    	return f.filtrar(proyectos);
    }
    
    
}

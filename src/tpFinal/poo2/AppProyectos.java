package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public class AppProyectos {
    List<Proyecto> proyectos = new ArrayList<Proyecto>();
    
    public void agregarProyecto(Proyecto p) {
    	proyectos.add(p);
    }

	public List<Proyecto> getProyectos() {
		return proyectos;
	}
    
    public List<Proyecto> buscarProyectosConFiltro(Filtro f) {
    	return f.filtrar(proyectos);
    }
    
    
}

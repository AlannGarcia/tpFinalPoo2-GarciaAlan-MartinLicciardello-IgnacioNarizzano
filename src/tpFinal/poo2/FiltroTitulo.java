package tpFinal.poo2;

import java.util.List;

public class FiltroTitulo implements Filtro{
	private String titulo;

	public FiltroTitulo(String titulo) {
		super();
		this.titulo = titulo;
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		// TODO Auto-generated method stub
		return proyectos.stream().filter(t ->t.nombre.contains(titulo)).toList();
	}
	
	
}

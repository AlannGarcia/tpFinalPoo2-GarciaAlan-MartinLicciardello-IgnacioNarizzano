package tpFinal.poo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario {
	String nombre;
	List<Muestra> muestras = Arrays.asList();
	List<Proyecto> proyectos = Arrays.asList();
    Preferencia preferencias;
	List<DesafioDeUsuario> desafiosDeUsuario = Arrays.asList();
	EstrategiaRecomendacion estadoRecomendacion = new EstrategiaFavoritos();
	
	
	public Usuario(String nombre, Preferencia preferencias) {
		this.nombre = nombre;
		this.preferencias = preferencias;
	}

	private List<DesafioDeUsuario> getGustosDesafios() {
		return gustosDesafios;
	}

	private void setGustosDesafios(List<DesafioDeUsuario> gustosDesafios) {
		this.gustosDesafios = gustosDesafios;
	}
	
	public List<Desafio> desafiosCompletos() {
		
		return desafiosDeUsuario.stream().filter(d -> d.completoDesafio()).map(d -> d.getDesafio()).toList(); 
	}
	
	public int porcentajeCompletitud(Desafio d) {
		
	}
	
	public int porcentajeCompletitudGeneral() {
		
	}

	public ArrayList<Desafio> buscarMatchDesafios(ArrayList<Desafio> d) {
		
		return estadoRecomendacion.buscarMatchDesafios(this, d);
	}
	
	public void agregarDesafio(Desafio d) {
		// crear instancia desafioDeUsuario y agregar a desafios
	}
	
	public ArrayList<Desafio> buscarMatchPorFavoritos(ArrayList<Desafio> d) {
	}
	
	public ArrayList<Desafio> buscarMatchPorPreferencias(ArrayList<Desafio> d) {
	}
}



// Composite
/*PARA LA PARTE DE FILTROS DE LA APLICACION, EL OR, EL AND U LAS CATEGORIAS QUE EXCLUYA Y INCLUYA *
 * 
 * NECESITAMOS UN METODO FILTRAR/
 */
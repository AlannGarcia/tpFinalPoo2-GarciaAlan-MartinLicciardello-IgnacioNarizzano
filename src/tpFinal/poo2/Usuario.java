package tpFinal.poo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario {
	String nombre;
	List<Muestra> muestras = Arrays.asList();
	List<Proyecto> proyectos = Arrays.asList();
    Preferencias preferencias;
	List<DesafioDeUsuario> desafios = Arrays.asList();
	List<DesafioDeUsuario> gustosDesafios = Arrays.asList();
	EstadoRecomendacion estadoRecomendacion = new EstadoFavoritos();
	
	// map de usurario con un int 0 a 5
	
	public Usuario(String nombre, Preferencias preferencias, List<DesafioDeUsuario> desafiosDeUsuario) {
		this.nombre = nombre;
		this.preferencias = preferencias;
		this.desafios = desafiosDeUsuario;
	}

	private List<DesafioDeUsuario> getGustosDesafios() {
		return gustosDesafios;
	}

	private void setGustosDesafios(List<DesafioDeUsuario> gustosDesafios) {
		this.gustosDesafios = gustosDesafios;
	}
	
	public List<Desafio> desafiosCompletos() {
		
		return desafios.stream().filter(d -> d.completoDesafio()).map(d -> d.getDesafio()).toList(); 
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
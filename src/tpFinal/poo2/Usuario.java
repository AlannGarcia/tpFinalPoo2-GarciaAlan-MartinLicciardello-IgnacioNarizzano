package tpFinal.poo2;

import java.util.ArrayList;

public class Usuario {
	String nombre;
	ArrayList<Muestra> muestras;
	ArrayList<Proyecto> proyectos;
	ArrayList<String> gustos;
	ArrayList<String> preferencias;
	ArrayList<String> comportamientos;
	// map de usurario con un int 0 a 5
	
	public Usuario(String nombre, ArrayList<String> gustos,ArrayList<String> preferencias, 
				   ArrayList<String> comportamientos) {
		this.nombre = nombre;
		this.gustos = gustos;
		this.preferencias = preferencias;
		this.comportamientos = comportamientos;
	}
	
}



// Composite
/*PARA LA PARTE DE FILTROS DE LA APLICACION, EL OR, EL AND U LAS CATEGORIAS QUE EXCLUYA Y INCLUYA *
 * 
 * NECESITAMOS UN METODO FILTRAR/
 */
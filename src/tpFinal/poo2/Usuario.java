package tpFinal.poo2;

import java.util.ArrayList;

public class Usuario {
	String nombre;
	ArrayList<Muestra> muestras;
	ArrayList<Proyecto> proyectos;
	ArrayList<String> gustos;
	ArrayList<String> preferencias;
	ArrayList<String> comportamientos;
	
	public Usuario(String nombre, ArrayList<String> gustos,ArrayList<String> preferencias, 
				   ArrayList<String> comportamientos) {
		this.nombre = nombre;
		this.gustos = gustos;
		this.preferencias = preferencias;
		this.comportamientos = comportamientos;
	}
	
}

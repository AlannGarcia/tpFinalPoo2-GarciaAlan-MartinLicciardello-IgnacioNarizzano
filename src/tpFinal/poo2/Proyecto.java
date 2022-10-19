package tpFinal.poo2;

import java.util.ArrayList;

public class Proyecto {
	String nombre;
	String descripcion;
	ArrayList<Muestra> muestras;
	ArrayList<String>  categorias;
	ArrayList<Desafio> desafios;
	
	public Proyecto(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.muestras = new ArrayList<Muestra>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public ArrayList<Muestra> getMuestras() {
		return muestras;
	}

	public void agregarMuestra(Muestra muestra) {
		muestras.add(muestra);
	}
	
	public void buscarMatch(ArrayList<Desafio> desafios) {
	/*
	 * compara la lista de desafios que recibe como parametro con la 
	 * lista de desafios que ya tiene, y genera una nueva lista de 
	 * desafíos para que sean los compatibles con ese proyecto para 
	 * pasarle en limpio la lista la usario y que ahi haga el 
	 * match el usuario
	 * */
		
	}
}

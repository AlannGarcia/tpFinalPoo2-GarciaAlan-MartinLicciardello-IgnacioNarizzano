package tpFinal.poo2;

import java.util.ArrayList;

public class Proyecto {
	String nombre;
	String descripcion;
	//arrayList de enum de categorias
	ArrayList<Muestra> muestras;
	
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
}

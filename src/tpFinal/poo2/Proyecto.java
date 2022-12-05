package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private String nombre;
	private String descripcion;
	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Desafio> desafios = new ArrayList<Desafio>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Proyecto(String nombre, String descripcion, List<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categorias = categorias;
	}

	
	public List<Categoria> getCategorias() {
		return categorias;
	}


	public String getNombre() {
		return nombre;
	}


	public void agregarMuestra(Muestra muestra) {
		muestras.add(muestra);
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}


	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
		usuario.agregarProyecto(this);
	}

	public List<Desafio> getDesafios() {
		return this.desafios;
	}
	
	public void agregarDesafio(Desafio desafio) {
		desafios.add(desafio);
	}
	
	
}

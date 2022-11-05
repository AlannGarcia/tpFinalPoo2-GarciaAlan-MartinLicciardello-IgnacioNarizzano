package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	String nombre;
	String descripcion;
	List<Muestra> muestras = new ArrayList<Muestra>();
	List<Categoria> categorias = new ArrayList<Categoria>();
	List<Desafio> desafios = new ArrayList<Desafio>();
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Proyecto(String nombre, String descripcion, List<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categorias = categorias;
	}

	
	public void agregarMuestra(Muestra muestra) {
		muestras.add(muestra);
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

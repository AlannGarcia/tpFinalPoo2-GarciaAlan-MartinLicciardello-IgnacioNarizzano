package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	String nombre;
	String descripcion;
	List<Muestra> muestras;
	List<Categorias>  categorias;
	List<Desafio> desafios;
	List<Usuario> usuarios;
	
	public Proyecto(String nombre, String descripcion, List<Categorias> categorias) {
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
		return desafios;
	}
	
	
}

package tpFinal.poo2;

import java.util.ArrayList;
import java.util.List;

import tpFinal.poo2.EstrategiaRecomendacion.EstrategiaFavoritos;
import tpFinal.poo2.EstrategiaRecomendacion.EstrategiaRecomendacion;


public class Usuario {
	private String nombre;
	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	private Preferencia preferencias;
	private List<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
	private EstrategiaRecomendacion estadoRecomendacion = new EstrategiaFavoritos() ;
	
	
	public Usuario(String nombre, Preferencia preferencias) {
		super();
		this.nombre = nombre;
		this.preferencias = preferencias;
	}

	
	
	public List<Desafio> desafiosCompletos() {
		
		return desafiosDeUsuario.stream().filter(d -> d.completoDesafio()).map(d -> d.getDesafio()).toList(); 
	}
	
	public int porcentajeCompletitud(Desafio desafio) {
		return desafiosDeUsuario.stream().filter(d -> d.getDesafio() == desafio).findAny().get().porcentajeDeCompletitud();

	}
	
	public double porcentajeCompletitudGeneral() {
		
		return desafiosDeUsuario.stream().mapToInt(d -> d.porcentajeDeCompletitud()).average().getAsDouble();
		
	}

	
	public List<DesafioDeUsuario> getDesafiosDeUsuario() {
		return desafiosDeUsuario;
	}



	public List<Desafio> buscarMatchDesafio(List<Desafio> desafios) {
		
		return estadoRecomendacion.buscarMatchDesafios( desafios, desafiosDeUsuario, preferencias); 
	}
	
	public void enviarMuestra(Proyecto proyectos, Muestra muestra) {
	    List<DesafioDeUsuario> proyectosDesafios = desafiosDeUsuario.stream().filter(n -> proyectos.getDesafios().contains(n.getDesafio())).toList();
		proyectosDesafios.stream().forEach(n -> {
			System.out.println(n.evaluarMuestra(muestra));
		});
		proyectos.agregarMuestra(muestra);
	}
	
	public void agregarProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
	}
	
	public void agregarDesafio(Desafio desafio) {
		if(!desafiosDeUsuario.stream().map(d -> d.getDesafio()).toList().contains(desafio)) {
			desafiosDeUsuario.add(new DesafioDeUsuario(desafio));
		}
		// Si no acepto este desafio, lo acepta.
	}
	
	public void setEstadoRecomendacion(EstrategiaRecomendacion estadoRecomendacion) {
		this.estadoRecomendacion = estadoRecomendacion;
	}



	
	
	
	
	
	
}
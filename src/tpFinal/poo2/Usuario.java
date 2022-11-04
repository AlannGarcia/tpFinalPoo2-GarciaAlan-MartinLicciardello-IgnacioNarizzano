package tpFinal.poo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import martinLucastp.Desafio;
import martinLucastp.DesafioDeUsuario;
import martinLucastp.EstrategiaFavoritos;
import martinLucastp.EstrategiaRecomendacion;
import martinLucastp.Muestras;
import martinLucastp.Proyecto;

public class Usuario {
	String nombre;
	List<Muestra> muestras = Arrays.asList();
	List<Proyecto> proyectos = Arrays.asList();
    Preferencia preferencias;
	List<DesafioDeUsuario> desafiosDeUsuario = Arrays.asList();
	EstrategiaRecomendacion estadoRecomendacion = new EstrategiaFavoritos() ;
	
	
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

	public List<Desafio> buscarMatchPorFavoritos(ArrayList<Desafio> desafios) {
		Desafio desafioQueMasGusto = desafiosDeUsuario.stream().max((d1,d2) -> d1.voto.compareTo(d2.voto)).get().getDesafio();//buscamos el desafio que mmas le gusto al usuario
		List<Desafio> desafioDeMayorCoincidencia = matchPorPreferencia(desafios).stream().limit(20).//Ordenamos por preferencia y lo limitimas a primeros 20
				sorted((d1,d2)-> this.promedioEntreDistanciasDeValoresDeCoincidencia(d2, desafioQueMasGusto)
						.compareTo(this.promedioEntreDistanciasDeValoresDeCoincidencia(d1, desafioQueMasGusto))).limit(5).toList();
		return desafioDeMayorCoincidencia;// se ordena de menor a mayot

	}
	
	
	
	private Integer promedioEntreDistanciasDeValoresDeCoincidencia(Desafio a, Desafio b) {
		return Math.abs(a.valorDeCoincidencia() - b.valorDeCoincidencia());
	}
	
	public ArrayList<Desafio> buscarMatchPorPreferencias(ArrayList<Desafio> desafios) {
		this.matchPorPreferencia(desafios).subList(0, 5);
	}
	
	
	
	private List<Desafio> matchPorPreferencia(List<Desafio> desafios){
		List<Desafio> desafiosTomados = desafiosDeUsuario.stream().map(d -> d.getDesafio()).toList();//tranformo los desafiosDeUsuario en los desafios que ya estuvo
		List<Desafio> desafiosNoTomados = new ArrayList<Desafio>(desafios);
		desafiosNoTomados.removeAll(desafiosNoTomados);// desafios no tomados
		return desafiosNoTomados.stream().
				sorted((d1,d2) -> this.preferencias.cumpleDesafio(d2).// ordeno por preferencia de menor a mayor entre el valor de la suma de todos los valores
						compareTo(this.preferencias.cumpleDesafio(d1))).//ordeno por el valor abs de 
				collect(Collectors.toList());
	}
	
	
	
	
	public void enviarMuestra(Proyecto proyectos, Muestra muestra) throws Exception{
	    desafiosDeUsuario.stream().forEach(n ->{
			try {
				n.evaluarMuestra(muestra);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	}
	
	
	
	
	public void setEstadoRecomendacion(EstrategiaRecomendacion estadoRecomendacion) {
		this.estadoRecomendacion = estadoRecomendacion;
	}



	public ArrayList<Desafio> buscarMatchDesafios(ArrayList<Desafio> desafios) {
		
		return estadoRecomendacion.buscarMatchDesafios(this, desafios);
	}
	
	
	
	
	
	
}



// Composite
/*PARA LA PARTE DE FILTROS DE LA APLICACION, EL OR, EL AND U LAS CATEGORIAS QUE EXCLUYA Y INCLUYA *
 * 
 * NECESITAMOS UN METODO FILTRAR/
 */
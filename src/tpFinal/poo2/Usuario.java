package tpFinal.poo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Usuario {
	String nombre;
	List<Muestra> muestras = new ArrayList<Muestra>();
	List<Proyecto> proyectos = new ArrayList<Proyecto>();
    Preferencia preferencias;
	List<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();
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

	public List<Desafio> buscarMatchPorFavorito(List<Desafio> desafios) {
		Desafio desafioQueMasGusto = desafiosDeUsuario.stream().max((d1,d2) -> d1.voto.compareTo(d2.voto)).get().getDesafio();//buscamos el desafio que mmas le gusto al usuario
		List<Desafio> desafioDeMayorCoincidencia = matchPorPreferencia(desafios).stream().limit(20).//Ordenamos por preferencia y lo limitamos a primeros 20
				sorted((d1,d2)-> this.promedioEntreDistanciasDeValoresDeCoincidencia(d2, desafioQueMasGusto)
						.compareTo(this.promedioEntreDistanciasDeValoresDeCoincidencia(d1, desafioQueMasGusto))).limit(5).toList();
		return desafioDeMayorCoincidencia;// se ordena de menor a mayor

	}
	
	
	private Integer promedioEntreDistanciasDeValoresDeCoincidencia(Desafio a, Desafio b) {
		return Math.abs(a.valorDeCoincidencia() - b.valorDeCoincidencia()) / 3;
	}
	
	private List<Desafio> matchPorPreferencia(List<Desafio> desafios){
		List<Desafio> desafiosTomados = desafiosDeUsuario.stream().map(d -> d.getDesafio()).toList();//tranformo los desafiosDeUsuario en los desafios que ya estuvo
		List<Desafio> desafiosNoTomados = new ArrayList<Desafio>(desafios);
		desafiosNoTomados.removeAll(desafiosTomados);// desafios no tomados
		return desafiosNoTomados.stream().
				sorted((d1,d2) -> this.preferencias.cumpleDesafio(d2).// ordeno por preferencia de menor a mayor entre el valor de la suma de todos los valores
						compareTo(this.preferencias.cumpleDesafio(d1))).//ordeno por el valor abs de 
				collect(Collectors.toList());
	}
	
	public List<Desafio> buscarMatchPorPreferencias(List<Desafio> desafios) {
		return this.matchPorPreferencia(desafios).subList(0, 5);
	}
	
	public List<Desafio> buscarMatchDesafio(List<Desafio> desafios) {
		
		return estadoRecomendacion.buscarMatchDesafios(this, desafios); 
	}
	
	public void enviarMuestra(Proyecto proyectos, Muestra muestra) {
	    List<DesafioDeUsuario> proyectosDesafios = desafiosDeUsuario.stream().filter(n -> proyectos.getDesafios().contains(n.getDesafio())).toList();
		proyectosDesafios.stream().forEach(n -> {
			try {
				n.evaluarMuestra(muestra);
			}catch (Exception e) {
				// TODO: handle exception
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
		// Si no acepto este desafio, lo acepta.
	}
	
	public void setEstadoRecomendacion(EstrategiaRecomendacion estadoRecomendacion) {
		this.estadoRecomendacion = estadoRecomendacion;
	}



	
	
	
	
	
	
}



// Composite
/*PARA LA PARTE DE FILTROS DE LA APLICACION, EL OR, EL AND U LAS CATEGORIAS QUE EXCLUYA Y INCLUYA *
 * 
 * NECESITAMOS UN METODO FILTRAR/
 */
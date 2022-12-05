package tpFinal.poo2;

import java.time.LocalDate;

public class Desafio {
	private Area area;
	private RestriccionTemporal restriccionTemporal;
    private int cantidadMuestras;
	private NivelDificultad dificultad;
	private int recompensa;
	
	
	public Desafio(Area area, int cantidadMuestras, NivelDificultad dificultad, int recompensa, RestriccionTemporal restriccionTemporal) {
		super();
		this.area = area;
		this.cantidadMuestras = cantidadMuestras;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
		this.restriccionTemporal = restriccionTemporal;
	}
	
	public RestriccionTemporal getRestriccionTemporal() {
		return restriccionTemporal;
	}

	public void setRestriccionTemporal(RestriccionTemporal restriccionTemporal) {
		this.restriccionTemporal = restriccionTemporal;
	}

	public boolean desafioExpirado() {
		return !restriccionTemporal.cumpleConFecha(LocalDate.now()); //no cumple con la fecha
	}
	
	public Integer valorDeCoincidencia() {
		return cantidadMuestras + dificultad.nivelDificultad() + recompensa;
	}

	public Area getArea() {
		return area;
	}

	public int getCantidadMuestras() {
		return cantidadMuestras;
	}
	
	
	
	
	
}

package tpFinal.poo2;

import java.time.LocalDate;

public class Desafio {
	Area area;
	RestriccionTemporal restriccionTemporal;
    int cantidadMuestras;
	NivelDificultad dificultad;
	int recompensa;
	
	
	public Desafio(Area area, int cantidadMuestras, NivelDificultad dificultad, int recompensa) {
		super();
		this.area = area;
		this.cantidadMuestras = cantidadMuestras;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
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
	
	
	
	
	
}

package tpFinal.poo2;

import java.time.LocalDate;

public class Desafio {
	Area area;
	RestriccionTemporal restriccionTemporal;
    int cantidadMuestras;
	NivelDificultad dificultad;
	int recompensa;
	
	
	public Desafio(Area area, RestriccionTemporal restriccionTemporal, int cantidadMuestras, NivelDificultad dificultad,
			int recompensa) {
		super();
		this.area = area;
		this.restriccionTemporal = restriccionTemporal;
		this.cantidadMuestras = cantidadMuestras;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
	}
	
	public boolean desafioExpirado() {
			return !restriccionTemporal.cumpleConFecha(LocalDate.now()); //no cumple con la fecha
	}
	
	public Integer valorDeCoincidencia() {
		return cantidadMuestras + dificultad.nivelDificultad() + recompensa;
	}
	
	
	
	
	
}

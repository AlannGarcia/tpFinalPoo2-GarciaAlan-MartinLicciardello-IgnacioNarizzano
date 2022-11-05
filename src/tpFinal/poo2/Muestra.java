package tpFinal.poo2;

import java.time.LocalDate;

public class Muestra {
	Usuario usuario;
	LocalDate fecha;
	Ubicacion ubicacion;
	
	public Muestra(Usuario usuario, LocalDate fecha, Ubicacion ubicacion) {
		this.usuario = usuario;
		this.fecha = fecha;
		this.ubicacion = ubicacion;
	}
	
	public boolean perteneceAlArea(Area a) {
		return a.ubicacionPerteneceAArea(this.ubicacion);
	}
	
}

package tpFinal.poo2;

import java.time.LocalDate;

import tpFinal.poo2.EstrategiaSemanal.EstrategiaSemanal;

public class RestriccionTemporal {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private EstrategiaSemanal estrategiaSemanal;
	
	
	public RestriccionTemporal(LocalDate fechaInicio, LocalDate fechaFin, EstrategiaSemanal estrategiaSemanal) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estrategiaSemanal = estrategiaSemanal;
	}
	
	public boolean cumpleConFecha(LocalDate fecha) {
		return (fecha.isBefore(this.fechaFin) && fecha.isAfter(this.fechaInicio) && estrategiaSemanal.cumpleCon(fecha)); // Si cumple con una fecha
	}
	
	public void setEstrategiaSemanal(EstrategiaSemanal estrategiaSemanal) {
		this.estrategiaSemanal = estrategiaSemanal;
	}
	
}

package tpFinal.poo2;

import java.time.LocalDate;

import tpFinal.poo2.EstadosDesafio.*;

public class DesafioDeUsuario {
	private Desafio desafio;
	private int cantidadMuestras = 0;
	private Voto voto = Voto.V;
	private EstadoDesafioUsuario estadoUsuario;
	private LocalDate fecha = null;
	
	public DesafioDeUsuario(Desafio desafio) {
		this.desafio = desafio;
		if(!desafio.desafioExpirado()) {
			estadoUsuario = new EstadoDesafioUsuarioActivo();
		}else {
			estadoUsuario = new EstadoDesafioUsuarioInactivo();
		}
	}
	
	
	public int getCantidadMuestras() {
		return cantidadMuestras;
	}


	public boolean completoDesafio() {
		return estadoUsuario.completoDesafio();
	}
		
	public int porcentajeDeCompletitud() {
	
		return ((cantidadMuestras * 100) / desafio.getCantidadMuestras());       			
	}
		
	public String evaluarMuestra(Muestra muestra) {
		if(muestra.perteneceAlArea(desafio.getArea()) 
				&& desafio.getRestriccionTemporal().cumpleConFecha(muestra.getFecha())) {
			return estadoUsuario.evaluarMuestra(muestra, this);
		}else {
			return "No pertenece al area";
		}
	}
	     
	public String evaluarMuestraEnEstadoActivo(Muestra muestra) {
		String resultado;
			
		if(this.desafio.desafioExpirado()) {
			resultado = "Desafio inactivo";
			estadoUsuario = new EstadoDesafioUsuarioInactivo();
		}else if(this.desafio.getCantidadMuestras() == cantidadMuestras + 1){
			resultado = "Desafio completado";
			estadoUsuario = new EstadoDesafioUsuarioCompletado();
			cantidadMuestras++;
			fecha = LocalDate.now();
		}else {
			resultado = "Muestra evaluada";
			cantidadMuestras++;
		}
		return resultado;
	}
		
	public Desafio getDesafio() {
		return desafio;
	}
		
	public String getFechaCompletado() throws Exception{
			
			return estadoUsuario.fechaCompletado(this);
			
	}
		
	public void votar(Voto v) {
		voto = v;
	}
		
	public Voto getVoto() {
		return this.voto;
	}


	public LocalDate getFecha() {
		// TODO Auto-generated method stub
		return fecha;
	}
}


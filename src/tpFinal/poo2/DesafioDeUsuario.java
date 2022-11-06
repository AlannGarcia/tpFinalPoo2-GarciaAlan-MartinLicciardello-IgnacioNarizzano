package tpFinal.poo2;

import java.time.LocalDate;
import java.util.ArrayList;

public class DesafioDeUsuario {
	Desafio desafio;
	int cantidadMuestras = 0;
	Voto voto = Voto.v;
	EstadoDesafioUsuario estadoUsuario;
	LocalDate fecha = null;
	
	
	public DesafioDeUsuario(Desafio desafio) {
		this.desafio = desafio;
		if(!desafio.desafioExpirado()) {
			estadoUsuario = new EstadoDesafioUsuarioActivo();
		}else {
			estadoUsuario = new EstadoDesafioUsuarioInactivo();
		}
	}
	
	
		public boolean completoDesafio() {
			return estadoUsuario.getClass() == EstadoDesafioUsuarioCompletado.class;
	 	}
		
		public int porcentajeDeCompletitud() {
			return ((cantidadMuestras * 100) / desafio.cantidadMuestras);       
					
		}
		
		public void evaluarMuestra(Muestra muestra) throws Exception{
			if(muestra.perteneceAlArea(desafio.area)) {
				estadoUsuario.evaluarMuestra(muestra, this);
			}
		}
	     
		public void evaluarMuestraEnEstadoActivo(Muestra muestra) {
			if(this.desafio.desafioExpirado()) {
				estadoUsuario = new EstadoDesafioUsuarioInactivo();
			}else if(this.desafio.cantidadMuestras == cantidadMuestras + 1){
				estadoUsuario = new EstadoDesafioUsuarioCompletado();
				cantidadMuestras++;
				fecha = LocalDate.now();
			}else {
				cantidadMuestras++;
			}
		}
		
		public Desafio getDesafio() {
			return desafio;
		}
		
		public LocalDate getFechaCompletado() throws Exception{
			try {
				return fecha;
			}catch(NullPointerException e) {
				throw new Exception("El desafio no ha sido completado");
			}
		}
		
		public void votar(Voto v) {
			voto = v;
		}
		
		public Voto getVoto() {
			return this.voto;
		}
}


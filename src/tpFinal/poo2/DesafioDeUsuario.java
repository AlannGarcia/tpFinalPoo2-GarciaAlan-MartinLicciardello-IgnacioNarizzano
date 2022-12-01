package tpFinal.poo2;

import java.time.LocalDate;

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
			return estadoUsuario.completoDesafio();
	 	}
		
		public int porcentajeDeCompletitud() {
			return ((cantidadMuestras * 100) / desafio.cantidadMuestras);       
					
		}
		
		public String evaluarMuestra(Muestra muestra) {
			if(muestra.perteneceAlArea(desafio.area)) {
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
			}else if(this.desafio.cantidadMuestras == cantidadMuestras + 1){
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


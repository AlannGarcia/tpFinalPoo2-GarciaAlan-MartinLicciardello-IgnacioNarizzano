package tpFinal.poo2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesafioUsuarioTest {

	    Usuario usuarioA;
	    Usuario usuarioB;
	    Usuario usuarioC;
	    Desafio desafio;
	    Desafio desafioA;
	    Desafio desafioB;
	    Proyecto proyecto;
	    Muestra muestra;
	    Ubicacion ubicacionDesafio;
	    Area areaDesafio;
	    Categoria categorias1;
	    Categoria categorias2;
	    List<Categoria> categorias;
	    RestriccionTemporal restriccionTemporal; 
	    RestriccionTemporal restriccionTemporal2; 
	
	    @BeforeEach
	    public void setUp() {   //despues de 2026 rompe la restriccion
	        restriccionTemporal = new RestriccionTemporal(LocalDate.of(2020,12, 02), LocalDate.of(2026,02, 02),new EstrategiaSemanalSemCompleta());
	        restriccionTemporal2 = new RestriccionTemporal(LocalDate.of(2022,04, 02), LocalDate.of(2022,04, 02),new EstrategiaSemanalDia());
	        categorias1 = new Categoria("Primera");
	        categorias2 = new Categoria("Segunda");
	        categorias = Arrays.asList(categorias1,categorias2);
	        usuarioA = new Usuario("Martin",new Preferencia(1,NivelDificultad.Facil,3));
	        usuarioB = new Usuario("Lucas",new Preferencia(2,NivelDificultad.Intermedio,2));
	        usuarioC = new Usuario("Diego",new Preferencia(1,NivelDificultad.MuyDificil,3));
	        ubicacionDesafio = new Ubicacion(1,2); 
	        areaDesafio = new Area(ubicacionDesafio,3);
	        desafio = new Desafio(areaDesafio,2 , NivelDificultad.Dificil,2 , restriccionTemporal);
	        desafio.setRestriccionTemporal(restriccionTemporal);
	        desafioB = new Desafio(areaDesafio, 2, NivelDificultad.Facil,2 , restriccionTemporal2);
	        proyecto = new Proyecto("Plantas", "las plantas bla bla bla", categorias);
	        muestra = new Muestra(usuarioA, LocalDate.of(2022,02, 02), ubicacionDesafio);
	        proyecto.agregarDesafio(desafio);
	        proyecto.agregarUsuario(usuarioA);
	        desafioA = new Desafio(areaDesafio, 4, NivelDificultad.Intermedio,2 , restriccionTemporal);
	        
	    }
    
	    
	    @Test
	    void fechaCuandoSeCumpleDesafioTest() throws Exception {
	        usuarioA.agregarDesafio(desafio);
	        proyecto.agregarDesafio(desafio);
	        usuarioA.enviarMuestra(proyecto, muestra);
	        usuarioA.enviarMuestra(proyecto, muestra);
	        
	        
	        usuarioA.enviarMuestra(proyecto, muestra);
	        assertEquals(2, usuarioA.desafiosDeUsuario.get(0).cantidadMuestras);
	        assertTrue(usuarioA.desafiosDeUsuario.get(0).completoDesafio());
	        
	        assertEquals(usuarioA.desafiosDeUsuario.get(0).getFechaCompletado(), LocalDate.now());
	    }
	    
	    @Test
	    void noCompletoDesafioPorRestriccionTemporalDia() {
	    	usuarioB.agregarDesafio(desafioB);
	    	proyecto.agregarDesafio(desafioB);
	    	usuarioB.enviarMuestra(proyecto, muestra);
	    	// no toma la muestra ya que esta fuera de fecha
	    	assertEquals(0,  usuarioB.desafiosDeUsuario.get(0).cantidadMuestras);
	    	assertFalse(restriccionTemporal2.cumpleConFecha(muestra.fecha));
	    }

	    @Test
	    void noCompletoDesafioPorRestriccionTemporalDia2() {
	    	assertFalse(desafioB.getRestriccionTemporal().cumpleConFecha(muestra.fecha));
	    }
	    
	    @Test
	    void cambioDeRestriccionEnDesafioTest() {
	    	RestriccionTemporal rt = new RestriccionTemporal(LocalDate.of(2022,04, 02), LocalDate.of(2022,04, 02),new EstrategiaSemanalDia());
	    	EstrategiaSemanal estrategiaSemCom = new EstrategiaSemanalSemCompleta(); 
	    	restriccionTemporal2.setEstrategiaSemanal(estrategiaSemCom);
	    	desafio.setRestriccionTemporal(restriccionTemporal2);
	    	
	    	assertFalse(desafio.getRestriccionTemporal() == rt);
	    }
	    
	    @Test 
	    void votoTest() {
	    	usuarioB.agregarDesafio(desafioB);
	    	
	    	usuarioB.desafiosDeUsuario.get(0).votar(Voto.v3);
	    	
	    	assertEquals(usuarioB.desafiosDeUsuario.get(0).getVoto(), Voto.v3);
	    }
	    
}

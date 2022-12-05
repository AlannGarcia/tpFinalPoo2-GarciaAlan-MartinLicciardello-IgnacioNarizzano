package tpFinal.poo2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinal.poo2.EstrategiaSemanal.EstrategiaSemanal;
import tpFinal.poo2.EstrategiaSemanal.EstrategiaSemanalDuranteLaSemana;
import tpFinal.poo2.EstrategiaSemanal.EstrategiaSemanalFinDeSem;
import tpFinal.poo2.EstrategiaSemanal.EstrategiaSemanalNinguna;

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
	    
	    RestriccionTemporal restTempFinDeSemana;
	    Desafio desafioFinDeSemana;
	    Muestra muestraFinDeSemana;
	    Muestra muestraDiaHabil;
	    
	    @BeforeEach
	    public void setUp() {   //despues de 2026 rompe la restriccion
	        restriccionTemporal = new RestriccionTemporal(LocalDate.of(2020,12, 02), LocalDate.of(2026,02, 02),new EstrategiaSemanalNinguna());
	        restriccionTemporal2 = new RestriccionTemporal(LocalDate.of(2022,04, 02), LocalDate.of(2022,04, 02),new EstrategiaSemanalDuranteLaSemana());
	       
	        categorias1 = new Categoria("Primera");
	        categorias2 = new Categoria("Segunda");
	        categorias = Arrays.asList(categorias1,categorias2);
	        usuarioA = new Usuario("Martin",new Preferencia(1,NivelDificultad.FACIL,3));
	        usuarioB = new Usuario("Lucas",new Preferencia(2,NivelDificultad.INTERMEDIO,2));
	        usuarioC = new Usuario("Diego",new Preferencia(1,NivelDificultad.MUY_DIFICIL,3));
	        ubicacionDesafio = new Ubicacion(1,2); 
	        areaDesafio = new Area(ubicacionDesafio,3);
	        desafio = new Desafio(areaDesafio,2 , NivelDificultad.DIFICIL,2 , restriccionTemporal);
	        desafio.setRestriccionTemporal(restriccionTemporal);
	        desafioB = new Desafio(areaDesafio, 2, NivelDificultad.FACIL,2 , restriccionTemporal2);
	        proyecto = new Proyecto("Plantas", "las plantas bla bla bla", categorias);
	        muestra = new Muestra(usuarioA, LocalDate.of(2022,02, 02), ubicacionDesafio);
	        proyecto.agregarDesafio(desafio);
	        proyecto.agregarUsuario(usuarioA);
	        desafioA = new Desafio(areaDesafio, 4, NivelDificultad.INTERMEDIO,2 , restriccionTemporal);
	        
	        restTempFinDeSemana = new RestriccionTemporal(LocalDate.of(2022,10,01), LocalDate.of(2023,01,31),new EstrategiaSemanalFinDeSem());
	    	desafioFinDeSemana = new Desafio(areaDesafio, 1, NivelDificultad.MUY_DIFICIL, 2, restTempFinDeSemana);
	    	muestraFinDeSemana =  new Muestra(usuarioB, LocalDate.of(2022,12,31), ubicacionDesafio);
	    	muestraDiaHabil =  new Muestra(usuarioB, LocalDate.of(2022,12,23), ubicacionDesafio);
	    	
	    	
	    }
    
	    
	    @Test
	    void fechaCuandoSeCumpleDesafioTest() throws Exception {
	        usuarioA.agregarDesafio(desafio);
	        proyecto.agregarDesafio(desafio);
	        usuarioA.enviarMuestra(proyecto, muestra);
	        usuarioA.enviarMuestra(proyecto, muestra);
	        
	        
	        usuarioA.enviarMuestra(proyecto, muestra);
	        assertEquals(2, usuarioA.getDesafiosDeUsuario().get(0).getCantidadMuestras());
	        assertTrue(usuarioA.getDesafiosDeUsuario().get(0).completoDesafio());
	        
	        assertEquals(usuarioA.getDesafiosDeUsuario().get(0).getFechaCompletado(), LocalDate.now().toString());
	    }
	    
	    @Test
	    void noCompletoDesafioPorRestriccionTemporalDia() {
	    	usuarioB.agregarDesafio(desafioB);
	    	proyecto.agregarDesafio(desafioB);
	    	usuarioB.enviarMuestra(proyecto, muestra);
	    	// no toma la muestra ya que esta fuera de fecha
	    	assertEquals(0,  usuarioB.getDesafiosDeUsuario().get(0).getCantidadMuestras());
	    	assertFalse(restriccionTemporal2.cumpleConFecha(muestra.getFecha()));
	    }
	    

	    @Test
	    void noCompletoDesafioPorRestriccionTemporalDia2() {
	    	assertFalse(desafioB.getRestriccionTemporal().cumpleConFecha(muestra.getFecha()));
	    }
	    
	    @Test
	    void cambioDeRestriccionEnDesafioTest() {
	    	RestriccionTemporal rt = new RestriccionTemporal(LocalDate.of(2022,04, 02), LocalDate.of(2022,04, 02),new EstrategiaSemanalDuranteLaSemana());
	    	EstrategiaSemanal estrategiaSemCom = new EstrategiaSemanalNinguna(); 
	    	restriccionTemporal2.setEstrategiaSemanal(estrategiaSemCom);
	    	desafio.setRestriccionTemporal(restriccionTemporal2);
	    	
	    	assertFalse(desafio.getRestriccionTemporal() == rt);
	    }
	    
	    @Test 
	    void votoTest() {
	    	usuarioB.agregarDesafio(desafioB);
	    	
	    	usuarioB.getDesafiosDeUsuario().get(0).votar(Voto.V3);
	    	
	    	assertEquals(usuarioB.getDesafiosDeUsuario().get(0).getVoto(), Voto.V3);
	    }
	    
	    
	    @Test
	    void completoDesafioConRestriccionFinDeSemanaTest() {
	    	
	    	//exercise    	
	    	usuarioB.agregarDesafio(desafioFinDeSemana);
	    	proyecto.agregarDesafio(desafioFinDeSemana);
	    	usuarioB.enviarMuestra(proyecto, muestraFinDeSemana);
	    	
	    	//verify
	    	assertEquals(1, usuarioB.getDesafiosDeUsuario().get(0).getCantidadMuestras());
	    	assertTrue(usuarioB.getDesafiosDeUsuario().get(0).completoDesafio());
	    }

	    @Test
	    void noCompletoDesafioConRestriccionFinDeSemanaTest() {
	    	//exercise
	    	usuarioB.agregarDesafio(desafioFinDeSemana);
	    	proyecto.agregarDesafio(desafioFinDeSemana);
	    	usuarioB.enviarMuestra(proyecto, muestraDiaHabil);
	    	
	    	//verify
	    	assertEquals(0, usuarioB.getDesafiosDeUsuario().get(0).getCantidadMuestras());
	    	assertFalse(usuarioB.getDesafiosDeUsuario().get(0).completoDesafio());
	    }
	    
}

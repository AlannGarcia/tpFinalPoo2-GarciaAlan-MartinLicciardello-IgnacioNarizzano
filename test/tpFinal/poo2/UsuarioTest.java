package tpFinal.poo2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinal.poo2.EstrategiaRecomendacion.EstrategiaFavoritos;
import tpFinal.poo2.EstrategiaSemanal.EstrategiaSemanalFinDeSem;
import tpFinal.poo2.EstrategiaSemanal.EstrategiaSemanalNinguna;

class UsuarioTest {

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
	
    @BeforeEach
    public void setUp() {   //despues de 2026 rompe la restriccion
        restriccionTemporal = new RestriccionTemporal(LocalDate.of(2020,12, 02), LocalDate.of(2026,02, 02),new EstrategiaSemanalNinguna());
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
        desafioB = new Desafio(areaDesafio, 1, NivelDificultad.FACIL,2 , restriccionTemporal);
        proyecto = new Proyecto("Plantas", "las plantas bla bla bla", categorias);
        muestra = new Muestra(usuarioA, LocalDate.of(2022,02, 02), ubicacionDesafio );
        proyecto.agregarDesafio(desafio);
        proyecto.agregarUsuario(usuarioA);
        desafioA = new Desafio(areaDesafio, 4,  NivelDificultad.INTERMEDIO,2 , restriccionTemporal);
        
    }
    
    
	@Test
	void agregarDesafioTest() {
        usuarioA.agregarDesafio(desafio);
        
        assertTrue(usuarioA.getDesafiosDeUsuario().stream().map(n -> n.getDesafio()).toList().contains(desafio));
	}
	
	@Test
	public void enviarMuestraTest() throws Exception {
        usuarioA.agregarDesafio(desafio);
        usuarioA.enviarMuestra(proyecto, muestra);
        
        assertTrue(proyecto.getMuestras().contains(muestra));
        assertEquals(usuarioA.getDesafiosDeUsuario().get(0).getCantidadMuestras(),1);
    } 
	@Test
	public void porcentajeCompletitudTest() throws Exception{
        usuarioA.agregarDesafio(desafio);
        usuarioA.enviarMuestra(proyecto, muestra);
        
        assertEquals(usuarioA.porcentajeCompletitud(desafio), 50);
    }	
	
	@Test
	public void porcentajeCompletitudGeneral() throws Exception{
        usuarioA.agregarDesafio(desafio);
        usuarioA.enviarMuestra(proyecto, muestra);
        proyecto.agregarDesafio(desafioA);
        usuarioA.agregarDesafio(desafioA);
        usuarioA.enviarMuestra(proyecto, muestra);

        assertEquals(usuarioA.porcentajeCompletitudGeneral(), 62.5, 0);
    }

	@Test
	public void desafiosCompletosTest() throws Exception{
        usuarioA.agregarDesafio(desafio);
        assertEquals(usuarioA.desafiosCompletos(), Arrays.asList());
        
        usuarioA.enviarMuestra(proyecto, muestra);
        usuarioA.enviarMuestra(proyecto, muestra);
        
        assertEquals(usuarioA.desafiosCompletos(), Arrays.asList(desafio));
        
    }
	
	@Test
	public void buscarMatchDesafioTest() {
        usuarioA.setEstadoRecomendacion(new EstrategiaFavoritos());
        
        
        
        Desafio desafioC = new Desafio(areaDesafio, 6, NivelDificultad.FACIL,1 , restriccionTemporal);
        Desafio desafioD = new Desafio(areaDesafio, 4, NivelDificultad.INTERMEDIO,2 , restriccionTemporal);
        Desafio desafioE = new Desafio(areaDesafio, 8, NivelDificultad.MUY_DIFICIL,3 , restriccionTemporal);
        usuarioA.agregarDesafio(desafio);
        
        
        
        List<Desafio> desafios = Arrays.asList(desafio, desafioC, desafioD, desafioE, desafioA, desafioB);

        List<Desafio> desafioDeUsuarioA = usuarioA.buscarMatchDesafio(desafios);
        
        List<Desafio> resultadoDesafio = Arrays.asList(desafioC, desafioD, desafioE, desafioA, desafioB);
        
        assertEquals(desafioDeUsuarioA.size(), 5);
        assertTrue(desafioDeUsuarioA.containsAll(resultadoDesafio));
    }
	
    @Test
    
    public void  buscarMatchPorPreferenciasTest() {
        usuarioA.setEstadoRecomendacion(new EstrategiaFavoritos());
        
        Desafio desafioC = new Desafio(areaDesafio, 6, NivelDificultad.FACIL,1 , restriccionTemporal);
        Desafio desafioD = new Desafio(areaDesafio, 4, NivelDificultad.INTERMEDIO,2 , restriccionTemporal);
        Desafio desafioE = new Desafio(areaDesafio, 8, NivelDificultad.MUY_DIFICIL,3 , restriccionTemporal);
        usuarioA.agregarDesafio(desafio);
        
        
        
        List<Desafio> desafios = Arrays.asList(desafio, desafioC, desafioD, desafioE, desafioA, desafioB);

        List<Desafio> desafioDeUsuarioA = usuarioA.buscarMatchDesafio(desafios);
        
        List<Desafio> resultadoDesafio = Arrays.asList(desafioC, desafioD, desafioE, desafioA, desafioB);
        
        assertEquals(desafioDeUsuarioA.size(), 5);
        desafioDeUsuarioA.stream().forEach(d -> System.out.println(d.getCantidadMuestras()));
        assertTrue(desafioDeUsuarioA.containsAll(resultadoDesafio));
        
    }
    
    @Test
    public void enviarMuestraEnDesafioInactivo() {
        RestriccionTemporal restrTemp = new RestriccionTemporal(LocalDate.of(2020,12, 02), LocalDate.of(2021,02, 02), new EstrategiaSemanalFinDeSem());
        Desafio desafioF = new Desafio(areaDesafio,7,NivelDificultad.INTERMEDIO, 2,restrTemp);
        usuarioA.agregarDesafio(desafioF);
        proyecto.agregarDesafio(desafioF);
        usuarioA.enviarMuestra(proyecto, muestra);
        assertEquals(0,usuarioA.getDesafiosDeUsuario().get(0).getCantidadMuestras());
        assertEquals(proyecto.getMuestras().size(),1);
        
    }

}

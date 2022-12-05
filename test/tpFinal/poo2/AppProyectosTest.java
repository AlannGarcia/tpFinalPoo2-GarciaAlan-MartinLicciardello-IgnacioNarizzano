package tpFinal.poo2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpFinal.poo2.Filtros.*;
import tpFinal.poo2.Filtros.FiltroIncluirCategorias;

class AppProyectosTest {

	AppProyectos app;
	Proyecto proyectoPlantas;
	Proyecto proyectoAves;
	Proyecto proyectoAnfibios;
	Proyecto proyectoArboles;
	Categoria plantas;
	Categoria aves;
	Categoria anfibios;
	Categoria arboles;
	List<Categoria> categoriasPlantas;
	List<Categoria> categoriasAves;
	List<Categoria> categoriasAnfibios;
	List<Categoria> categoriasArboles;
	Filtro filtroSiAnfibios;
	Filtro filtroNoAves;
	Filtro filtroSiPlantas;
	
	// Para mockito
	Proyecto dummyProyArboles;
	Filtro filtroPlantas;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		app = new AppProyectos();
		plantas = new Categoria("Plantas");
		aves = new Categoria("Aves");
		anfibios = new Categoria("Anfibios");
		arboles = new Categoria("Arboles");
		categoriasPlantas = Arrays.asList(plantas);
		categoriasAves = Arrays.asList(aves);
		categoriasAnfibios = Arrays.asList(anfibios);
		categoriasArboles = Arrays.asList(arboles);
		proyectoPlantas = new Proyecto("Plantas", "Proyecto plantas", categoriasPlantas);
		proyectoAves = new Proyecto("Aves", "Proyecto aves", categoriasAves);
		proyectoAnfibios = new Proyecto("Anfibios", "Proyecto anfibios", categoriasAnfibios);
		app.agregarProyecto(proyectoPlantas);
		app.agregarProyecto(proyectoAnfibios);
		app.agregarProyecto(proyectoAves);
		filtroSiAnfibios = new FiltroIncluirCategorias(categoriasAnfibios);
		filtroNoAves = new FiltroExcluirCategorias(categoriasAves);
		filtroSiPlantas = new FiltroIncluirCategorias(categoriasPlantas);
		
		// Para mockito
		dummyProyArboles = mock(Proyecto.class);
		filtroPlantas = mock(FiltroIncluirCategorias.class);
		
		
	}

	
	
	@Test
	void agregarProyectoTest() {
//		proyectoArboles = new Proyecto("Arboles", "Proyecto arboles", categoriasArboles);
//		List<Proyecto> spyProyectos = spy(app.getProyectos());
	    
	    app.agregarProyecto(dummyProyArboles);
	    

	    assertTrue(app.getProyectos().contains(dummyProyArboles));
	    
//        verify(spyProyectos, times(0)).add(dummyProyArboles);
//        verifyNoInteractions(dummyProyArboles);
	}
	
	@Test
	void buscarConFiltroAndTest() { // Se prueba filtro And 
		
		
		Filtro filtro = new FiltroAnd(filtroSiAnfibios, filtroNoAves);
		
		assertTrue(app.buscarProyectosConFiltro(filtro).contains(proyectoAnfibios));
		assertFalse(app.buscarProyectosConFiltro(filtro).contains(proyectoAves));
		assertFalse(app.buscarProyectosConFiltro(filtro).contains(proyectoPlantas));
	}
    
	@Test
	void buscarConFiltroOrTest() { // Se prueba filtro Or
		
		Filtro filtro = new FiltroOr(filtroSiAnfibios, filtroSiPlantas);
		
		assertTrue(app.buscarProyectosConFiltro(filtro).contains(proyectoAnfibios));
		assertFalse(app.buscarProyectosConFiltro(filtro).contains(proyectoAves));
		assertTrue(app.buscarProyectosConFiltro(filtro).contains(proyectoPlantas));
	}

	@Test
	void buscarConFiltroNotTest() { // Se prueba filtro Not
		
		Filtro filtro = new FiltroOr(filtroSiAnfibios, filtroSiPlantas);
		Filtro fNot = new FiltroNot(filtro);
		
		assertTrue(app.buscarProyectosConFiltro(fNot).contains(proyectoAves));
		assertFalse(app.buscarProyectosConFiltro(fNot).contains(proyectoAnfibios));
		assertFalse(app.buscarProyectosConFiltro(fNot).contains(proyectoPlantas));
	}

	@Test
	void buscarConFiltroTituloTest() { // Se prueba filtro Titulo
		
		Filtro filtroT = new FiltroTitulo("Plantas");
		
		assertTrue(app.buscarProyectosConFiltro(filtroT).contains(proyectoPlantas));
		assertFalse(app.buscarProyectosConFiltro(filtroT).contains(proyectoAnfibios));
		assertFalse(app.buscarProyectosConFiltro(filtroT).contains(proyectoAves));
	}
     
	@Test  
    void buscarConFiltrosCombinados() { // Se prueban filtros combinados con mocks
		
		//setUp
		Categoria c1 = mock(Categoria.class);
		Categoria c2 = mock(Categoria.class);
		List<Categoria> cs = Arrays.asList(c1,c2);
		Proyecto p1 = mock(Proyecto.class);
		
		Filtro fc1 = spy(new FiltroIncluirCategorias(Arrays.asList(c1)));
		
		Filtro filtroT = new FiltroTitulo("Plantas");
		Filtro filtroAnd = new FiltroAnd(filtroSiAnfibios, fc1);
		Filtro filtro = new FiltroOr(filtroAnd, filtroT);

		when(p1.getCategorias()).thenReturn(cs);
		when(p1.getNombre()).thenReturn("p1");
		when(c1.getNombre()).thenReturn("c1");
		when(c2.getNombre()).thenReturn("c2");
		
		//exercise
		app.agregarProyecto(p1);
		
		
		//verify
		assertTrue(app.buscarProyectosConFiltro(filtro).contains(proyectoPlantas));
		assertFalse(app.buscarProyectosConFiltro(filtro).contains(proyectoAnfibios));
		assertFalse(app.buscarProyectosConFiltro(filtro).contains(p1));
		
		verify(p1, times(3)).getNombre();
		verify(p1, times(6)).getCategorias();
		verify(fc1, times(3)).filtrar(app.getProyectos());
	}
}

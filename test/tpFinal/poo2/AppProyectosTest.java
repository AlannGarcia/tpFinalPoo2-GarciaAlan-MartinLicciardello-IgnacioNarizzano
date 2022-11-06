package tpFinal.poo2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	}

	
	
	@Test
	void agregarProyectoTest() {
		proyectoArboles = new Proyecto("Arboles", "Proyecto arboles", categoriasArboles);
        app.agregarProyecto(proyectoArboles);
	    
        assertTrue(app.getProyectos().contains(proyectoArboles));
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


}

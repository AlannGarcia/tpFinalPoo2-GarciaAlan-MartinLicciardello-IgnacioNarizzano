package tpFinal.poo2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaTest {
     
    Ubicacion a;
    Ubicacion b;
    Area area;
    
	@BeforeEach
	void setUp() throws Exception {
	    a = new Ubicacion(1, 1);
        area = new Area(a, 9);	
	}

	@Test
	void perteneceUbicacionAAreaTest() {
        b = new Ubicacion(2, 2);
        assertTrue(area.ubicacionPerteneceAArea(b));
	}
	
	@Test
    void testNoPerteneceUbicacionAArea() {
		b = new Ubicacion(29, 31);
		assertFalse(area.ubicacionPerteneceAArea(b));
	}

}

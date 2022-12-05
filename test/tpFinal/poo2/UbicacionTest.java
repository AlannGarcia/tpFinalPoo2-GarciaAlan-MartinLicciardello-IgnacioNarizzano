package tpFinal.poo2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UbicacionTest {

   
	@Test
	void distanciaDeHastaTest() {
        Ubicacion a = new Ubicacion(3, 4);
        Ubicacion b = new Ubicacion(0, 0);
        assertEquals(5, a.distanciaDeHasta(b));
        
	}

}

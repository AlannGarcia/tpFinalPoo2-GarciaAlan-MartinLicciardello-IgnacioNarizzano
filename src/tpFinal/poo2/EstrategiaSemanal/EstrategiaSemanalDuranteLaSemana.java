package tpFinal.poo2.EstrategiaSemanal;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class EstrategiaSemanalDuranteLaSemana extends EstrategiaSemanal{

	@Override
	public boolean cumpleCon(LocalDate fecha) {
		return fecha.get(ChronoField.DAY_OF_WEEK) <= 5;
	}

}

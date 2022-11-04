package tpFinal.poo2;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class EstrategiaSemanalDia extends EstrategiaSemanal{

	@Override
	public boolean cumpleCon(LocalDate fecha) {
		// TODO Auto-generated method stub
		return fecha.get(ChronoField.DAY_OF_WEEK) <= 5;
	}

}

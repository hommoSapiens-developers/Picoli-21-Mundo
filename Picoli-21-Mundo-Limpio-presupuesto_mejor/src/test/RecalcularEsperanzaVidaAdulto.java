package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import modelo.ser.Adulto;
import modelo.ser.Comportamiento;

class RecalcularEsperanzaVidaAdulto {

	@Test
	void test() {
		Comportamiento comportamiento=new Adulto();

		
		float esperanzaVida = 80f;
		int sueldo[] = {50, 15, 0,25};
		float resultado[] = {79.4f, 79f, 78f, 79.2f};
		
		for (int i = 0; i < resultado.length; i++) {
			assertEquals(resultado, comportamiento.alimentar(sueldo[i], esperanzaVida));
		}
	}

}

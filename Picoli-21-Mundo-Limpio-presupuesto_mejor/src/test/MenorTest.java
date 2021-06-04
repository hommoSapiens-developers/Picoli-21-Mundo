package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.ser.Ser;

class MenorTest {
	@Test
	void test() {
		ArrayList<Ser> miLista= new ArrayList<Ser>();
//		hace falta envejecer
		miLista.add(new Ser());
		for (Ser ser : miLista) {
			miLista.get(0).envejecer();
		}
		int sueldoA=100;
		int sueldoB=50;
		assertEquals(5.5f, miLista.get(0).comportamiento.alimentar(sueldoA, 120));
		assertEquals(2.75f, miLista.get(0).comportamiento.alimentar(sueldoB, 120));
	}

}

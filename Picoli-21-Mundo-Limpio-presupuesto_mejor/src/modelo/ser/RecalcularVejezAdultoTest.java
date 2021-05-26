package modelo.ser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class RecalcularVejezAdultoTest {

	@Test
	void test() {
			
			Adulto adulto=new Adulto();
			int sueldoA=100;
			int sueldoB=50;
			assertEquals(120f, adulto.alimentar(sueldoA, 120));
//			alimentar, retorna la esperanza de vida en el adulto
			assertEquals(119.5f, adulto.alimentar(sueldoB, 120));
			
		}

}

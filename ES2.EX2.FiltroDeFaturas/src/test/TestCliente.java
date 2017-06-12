package test;

import org.junit.*;
import static org.junit.Assert.*;
import logic.*;
import java.time.*;

public class TestCliente {

	String nome1 = "Jose";
	String nome2 = "MAria";
	LocalDate date1 = LocalDate.of(2016, Month.JANUARY, 5);
	LocalDate date2 = LocalDate.of(2015, Month.JANUARY, 5);
	Cliente c1 = new Cliente(nome1,date1,ESTADO.SP);
	Cliente c2 = new Cliente(nome2,date2,ESTADO.PR);
	Fatura f1 = new Fatura(nome1);
	Fatura f2 = new Fatura(nome2);
	
	
	@Test
	public void testaNome(){
	assertEquals("Jose",c1.getNome());
	assertNotEquals("Jose",c2.getNome());
	}

	public void testaData() {
		assertEquals(date1,c1.getDataInclusao());
		assertNotEquals(date1,c2.getDataInclusao());
	}
	
	public void testaEstado() {
		assertEquals(ESTADO.SP,c1.getEstado());
		assertNotEquals(ESTADO.SP,c2.getEstado());
	}
	
	public void testaFatura() {
		//fatura vazia
		assertEquals(0,c1.getFaturas().size());
		//adiciona 1 elemento
		c1.addFatura(f1);
		assertEquals(1,c1.getFaturas().size());
		c1.addFatura(f2);
		assertEquals(2,c1.getFaturas().size());
		//elimina elemento
		assertTrue(c1.deleteFatura(f1));
		assertEquals(1,c1.getFaturas().size());
		assertFalse(c1.deleteFatura(f1));
		assertEquals(1,c1.getFaturas().size());
	}
}

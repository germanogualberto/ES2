package test;

import org.junit.*;
import static org.junit.Assert.*;
import logic.*;
import java.time.*;

public class TestCliente {

	String nome1;
	String nome2;
	LocalDate date1;
	LocalDate date2;
	Cliente c1 ;
	Cliente c2 ;
	Fatura f1;
	Fatura f2;
	int cod1;
	int cod2;
	double val1;
	double val2;
	
	@Before
	public void init(){
		nome1 = "Jose";
		nome2 = "MAria";
		date1 = LocalDate.of(2016, Month.JANUARY, 5);
		date2 = LocalDate.of(2015, Month.JANUARY, 5);
		c1 = new Cliente(nome1,date1,ESTADO.SP);
		c2 = new Cliente(nome2,date2,ESTADO.PR);
		cod1=1;
		cod2=2;
		f1 = new Fatura(nome1,cod1,val1,date1);
		f2 = new Fatura(nome2,cod2,val2,date2);
	}
	
	@Test
	public void testaNome(){
	assertEquals("Jose",c1.getNome());
	assertNotEquals("Jose",c2.getNome());
	}
	
	@Test
	public void testaData() {
		assertEquals(date1,c1.getDataInclusao());
		assertNotEquals(date1,c2.getDataInclusao());
	}
	
	@Test
	public void testaEstado() {
		assertEquals(ESTADO.SP,c1.getEstado());
		assertNotEquals(ESTADO.SP,c2.getEstado());
	}
	
	@Test
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

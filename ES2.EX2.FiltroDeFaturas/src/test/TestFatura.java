package test;

import org.junit.*;
import static org.junit.Assert.*;
import logic.*;
import java.time.*;

public class TestFatura {

	String nome1;
	String nome2;
	int cod1;
	int cod2;
	Fatura f1;
	Fatura f2;
	Double val1;
	Double val2;
	LocalDate date1;
	LocalDate date2;
	
	@Before
	public void init(){
		nome1 = "Jose";
		nome2 = "MAria";
		cod1=1;
		cod2=2;
		val1=10.99;
		val2=11.99;
		date1 = LocalDate.of(2016, Month.JANUARY, 5);
		date2 = LocalDate.of(2015, Month.JANUARY, 5);
		f1=new Fatura(nome1,cod1,val1,date1);
		f2=new Fatura(nome2,cod2,val2,date2);
		
	}
	
	@Test
	public void testaCodigo(){
		assertEquals(1, f1.getCodigo());
		assertEquals(2, f2.getCodigo());
		assertNotEquals(2, f1.getCodigo());
	}
	
	@Test
	public void testaValor() {
		assertEquals(10.99, f1.getValor(),0.1);
		assertNotEquals(10.99, f2.getValor(), 0.1);
	}
	
	@Test
	public void testaNomeCliente(){
		assertEquals("Jose",f1.getNomeCliente());
		assertNotEquals("Jose",f2.getNomeCliente());
	}
	
	@Test
	public void testaData(){
		assertEquals(date1,f1.getDate());
		assertNotEquals(date1,f2.getDate());
	}
}

package test;

import org.junit.*;
import static org.junit.Assert.*;
import logic.*;
import java.time.*;
import java.util.ArrayList;

public class TestFiltro {
	String nome1;
	String nome2;
	LocalDate date1;
	LocalDate date2;
	Cliente c1 ;
	Cliente c2 ;
	Fatura f1;
	Fatura f2;
	Fatura f3;
	Fatura f4;
	int cod1;
	int cod2;
	int cod3;
	int cod4;
	double val1;
	double val2;
	double val3;
	double val4;
	ArrayList<Fatura> fats1;
	ArrayList<Fatura> fats2;
	
	@Before
	public void init(){
		date1 = LocalDate.of(2017, Month.MAY, 20);
		date2 = LocalDate.of(2015, Month.JANUARY, 5);
		c1 = new Cliente(nome1,date1,ESTADO.SP);
		c2 = new Cliente(nome2,date2,ESTADO.PR);
		cod1=1;
		cod2=2;
		cod3=3;
		cod4=4;
		val1=1000;
		val2=2000;
		val3=2500;
		val4=4001;
		f1 = new Fatura(c1,cod1,val1,date1);
		f2 = new Fatura(c2,cod2,val2,date1);
		f3 = new Fatura(c1,cod3,val3,date1);
		f4 = new Fatura(c2,cod4,val4,date2);
		fats1 = new ArrayList<Fatura>();
		fats2 = new ArrayList<Fatura>();
		
	}
	
	@Test
	public void testaMenorQue2000(){
		//teste vazio
		assertEquals(true, isTwoArrayListsWithSameValues(Filtro.menorQue2000(c1.getFaturas()),fats1));
		
		fats1.add(f1);
		fats2.add(f1);
		fats2.add(f3);
		
		c1.addFatura(f1);
		c1.addFatura(f2);
		c1.addFatura(f3);
		c1.addFatura(f4);
		
		assertEquals(true, isTwoArrayListsWithSameValues(Filtro.menorQue2000(c1.getFaturas()),fats1));
		assertNotEquals(true, isTwoArrayListsWithSameValues(Filtro.menorQue2000(c1.getFaturas()),fats2));
	}
	
	
	@Test
	public void testaEntre2500e3000(){
		//teste vazio
		assertEquals(true, isTwoArrayListsWithSameValues(Filtro.entre2500e3000(c1.getFaturas()),fats1));
		
		fats1.add(f3);
		fats2.add(f1);
		fats2.add(f3);
		
		c1.addFatura(f1);
		c1.addFatura(f2);
		c1.addFatura(f3);
		c1.addFatura(f4);
		
		assertEquals(true, isTwoArrayListsWithSameValues(Filtro.entre2500e3000(c1.getFaturas()),fats1));
		assertNotEquals(true, isTwoArrayListsWithSameValues(Filtro.entre2500e3000(c1.getFaturas()),fats2));
	}
	
	@Test
	public void testaMaiorQue4000(){
		//teste vazio
		assertEquals(true, isTwoArrayListsWithSameValues(Filtro.maiorQue4000(c1.getFaturas()),fats1));
		
		fats1.add(f3);
		fats2.add(f4);
		
		c1.addFatura(f1);
		c1.addFatura(f2);
		c1.addFatura(f3);
		c1.addFatura(f4);
		
		c2.addFatura(f1);
		c2.addFatura(f2);
		c2.addFatura(f3);
		c2.addFatura(f4);
		
		assertEquals(true, isTwoArrayListsWithSameValues(Filtro.maiorQue4000(c2.getFaturas()),fats2));
		assertNotEquals(true, isTwoArrayListsWithSameValues(Filtro.maiorQue4000(c1.getFaturas()),fats1));
	}
	
	 //the name of the method explains it well...
    public boolean isTwoArrayListsWithSameValues(ArrayList<Fatura> list1, ArrayList<Fatura> list2)
    {
        //null checking
        if(list1==null && list2==null)
            return true;
        if((list1 == null && list2 != null) || (list1 != null && list2 == null))
            return false;

        if(list1.size()!=list2.size())
            return false;
        for(Fatura itemList1: list1)
        {
            if(!list2.contains(itemList1))
                return false;
        }

        return true;
    }
    
    
	
}

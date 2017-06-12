package logic;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Filtro {

/*	
	Se o valor da fatura for menor que 2000;
	
	Se o valor da fatura estiver entre 2000 e 2500 e a data
	 for menor ou igual a de um mês atrás;
	 
	Se o valor da fatura estiver entre 2500 e 3000 e a data
	 de inclusão do cliente for menor ou igual a 2 meses atrás;
	 
	Se o valor da fatura for maior que 4000 e pertencer a
	 algum estado da região Sul do Brasil.
*/
	private static ArrayList<ESTADO> estadosSul = new ArrayList<ESTADO>();
	private static LocalDate hoje = LocalDate.now();
	
	public static ArrayList<Fatura> menorQue2000(ArrayList<Fatura> faturas){
		ArrayList<Fatura> faturasFiltradas = new ArrayList<Fatura>();
		
		for (int i = 0; i < faturas.size(); i++) {
			if (faturas.get(i).getValor() < 2000){
				faturasFiltradas.add(faturas.get(i));
			}
		}
		
		return faturasFiltradas;
	}

	public static ArrayList<Fatura> entre2000e2500(ArrayList<Fatura> faturas) {
		ArrayList<Fatura> faturasFiltradas = new ArrayList<Fatura>();
		
		for (int i = 0; i < faturas.size(); i++) {
			Fatura f=faturas.get(i);
			Period periodo = Period.between(f.getDate(), hoje);
			
			if (f.getValor() >= 2000 && f.getValor()<2500
					&& periodo.getMonths()<=1){
				faturasFiltradas.add(faturas.get(i));
			}
		}
		
		return faturasFiltradas;
	}

	public static ArrayList<Fatura> entre2500e3000(ArrayList<Fatura> faturas) {
		ArrayList<Fatura> faturasFiltradas = new ArrayList<Fatura>();
		
		for (int i = 0; i < faturas.size(); i++) {
			Fatura f=faturas.get(i);
			Period periodo = Period.between(f.getDate(), hoje);
			
			if (f.getValor() >= 2500 && f.getValor()<3000
					&& periodo.getMonths()<=2){
				faturasFiltradas.add(faturas.get(i));
			}
		}
		
		return faturasFiltradas;
	}

	public static ArrayList<Fatura> maiorQue4000(ArrayList<Fatura> faturas) {
		ArrayList<Fatura> faturasFiltradas = new ArrayList<Fatura>();
		estadosSul.add(ESTADO.PR);
		
		for (int i = 0; i < faturas.size(); i++) {
			Fatura f=faturas.get(i);
			
			if (f.getValor() > 4000
					&& estadosSul.contains(f.getCliente().getEstado())){
				faturasFiltradas.add(faturas.get(i));
			}
		}
		
		return faturasFiltradas;
	}
}

package logic;

import java.time.LocalDate;

public class Fatura {

	private String nomeCliente;
	private int codigo;
	private double valor;
	private LocalDate date;
	
	public Fatura(String nomeCliente, int codigo,double valor, LocalDate date) {
		this.nomeCliente = nomeCliente;
		this.codigo = codigo;
		this.valor=valor;
		this.date=date;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj.getClass()==Fatura.class){
			Fatura fat2 = (Fatura) obj;
			return (this.codigo==fat2.getCodigo());
		}
		return false;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public Double getValor() {
		return valor;
	}
	
	public LocalDate getDate() {
		return date;
	}
}

package logic;

import java.time.LocalDate;

public class Fatura {

	private Cliente cliente;
	private int codigo;
	private double valor;
	private LocalDate date;
	
	public Fatura(Cliente cliente, int codigo,double valor, LocalDate date) {
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}
	
	public String getNomeCliente() {
		return cliente.getNome();
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

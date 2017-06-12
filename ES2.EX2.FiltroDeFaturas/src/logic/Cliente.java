package logic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
	private String nome;
	private LocalDate dataInclusao;
	private ESTADO estado;
	private ArrayList<Fatura> faturas;
	
	public Cliente(String nome, LocalDate dataInclusao,ESTADO estado) {
		this.nome=nome;
		this.dataInclusao=dataInclusao;
		this.estado = estado;
	}
	
	public String getNome(){
		return nome;
	}
	public LocalDate getDataInclusao() {
		return dataInclusao;
	}
	
	public ESTADO getEstado() {
		return estado;
	}

	public ArrayList<Fatura> getFaturas() {
		return this.faturas;
	}
	
	public void addFatura(Fatura fatura) {
		faturas.add(fatura);
	}
	
	public boolean deleteFatura(Fatura fatura){
		for (int i = 0; i < faturas.size(); i++) {
			if (faturas.get(i).equals(fatura)){
				faturas.remove(0);
				return true;
			}
		} 
		return false;
	}
}

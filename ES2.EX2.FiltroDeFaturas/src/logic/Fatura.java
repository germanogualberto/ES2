package logic;

public class Fatura {

	private String nomeCliente;
	
	public Fatura(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj.getClass()==Fatura.class){
			Fatura fat2 = (Fatura) obj;
			return (this.nomeCliente==fat2.getNomeCliente());
		}
		return false;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
}

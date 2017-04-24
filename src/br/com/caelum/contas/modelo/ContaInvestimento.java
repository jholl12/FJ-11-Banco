package br.com.caelum.contas.modelo;

public class ContaInvestimento extends Conta{

	public String getTipo() {
		return "Conta Investimento";
	}
	
	@Override
	public boolean sacar(double valor){
		super.sacar(valor + 0.25);
		return true;
	}
	
	@Override 
	public void transferir(Conta destino, double valor) {
		super.transferir(destino, valor + 0.25);
	}
}

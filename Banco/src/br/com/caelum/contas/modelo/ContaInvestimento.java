package br.com.caelum.contas.modelo;

public class ContaInvestimento extends Conta{

	public String getTipo() {
		return "Conta Investimento";
	}
	
	@Override
	public boolean sacar(double valor){
		this.saldo -= (valor + 0.25);
		return true;
	}
}

package br.com.caelum.contas.modelo;

public class SeguroDeVida implements Tributavel {

	private double valor;
	private int numeroApolice;
	private String titular;

	public SeguroDeVida(){
		//VAZIO
	}
	
	public double getValor(){
		return this.valor;
	}
	
	public int getNumeroApolice(){
		return this.numeroApolice;
	}
	
	@Override
	public String getTitular() {
		return this.titular;
	}
		
	@Override
	public double getValorImposto() {
		return 42 + this.valor * 0.02;
	}

	@Override
	public String getTipo() {
		return null;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setNumeroApolice(int numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


}

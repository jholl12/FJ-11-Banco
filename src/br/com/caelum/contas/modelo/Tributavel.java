package br.com.caelum.contas.modelo;

public interface Tributavel {
	public abstract double getValorImposto();
	public abstract String getTitular();
	public abstract String getTipo();
}

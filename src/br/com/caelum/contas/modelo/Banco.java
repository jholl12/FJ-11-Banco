package br.com.caelum.contas.modelo;

public class Banco {
	private String nome;
	private String agencia;
	private String numero;
	private Conta[] contas;
	
	public Banco(String nome, String agencia, String numero){
		this.nome = nome;
		this.agencia = agencia;
		this.numero = numero;
		this.contas = new ContaCorrente[10];
	}

	public String getNome() {
		return nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}
	
	public void adiciona(Conta conta){
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null){
				contas[i] = conta;
				System.out.println("Conta adicionada!");
				break;
			} 
			
//			if(contas != null){
//				System.err.println("Array cheio!");
//			}
		}
	}
}

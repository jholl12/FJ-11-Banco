package br.com.caelum.contas.modelo;

import java.util.Arrays;

public class Banco {
	private String nome;
	private String agencia;
	private String numero;
	private Conta[] contas;
	
	public Banco(String nome, String agencia, String numero){
		this.nome = nome;
		this.agencia = agencia;
		this.numero = numero;
		this.contas = new ContaCorrente[3];
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
	
	public boolean contem(Conta conta) {
		for(Conta c : contas){
			if(conta.getNumero().equals(c.getNumero())){
				System.out.println("Conta já existente!");
				return true;
			}
		}
		return false;
	}
	
	public void mostraContas() {
		for (int i = 0; i < contas.length; i++) {
			System.out.println("Conta na posição: " + i);
			System.out.println(contas[i]);
			System.out.println("#########################");
		}
	}
	
	public void adiciona(Conta conta){
		int x = contas.length - 1;
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null){
				contas[i] = conta;
				System.out.println("Conta adicionada!");
		
				break;
			} 
		}
		System.out.println("#########################");

		
//		for (int j = 0; j < contas.length; j++) {
//			if(contas[j] == null){
//				continue;
//			}
//			
//			if(j == x){
//				System.err.println("Array cheio!");
//			}
//		}
	}
}

package br.com.caelum.contas.modelo;

import java.util.Arrays;

public class Banco {
	private String nome;
	private String agencia;
	private String numero;
	private Conta[] contas;
	private Conta[] contasMax;
	
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
		for(int a = 0; a < contas.length; a ++){
			if(contas[a] == null){
				break;
			}
			
			if(a == contas.length - 1){		
				contasMax = new ContaCorrente[6];
				for(int o = 0; o < contas.length; o++){
					contasMax[o] = contas[o];
				}
			}
		}
		
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null){
				contas[i] = conta;
				System.out.println("Conta adicionada!");
		
				break;
			} 
		}
		System.out.println("#########################");
	}
}

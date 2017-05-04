package br.com.caelum.contas.exercicios;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TesteHashCode {
	public static void main(String[] args) {
		Set<Conta> contas = recuperarContas();
		
		Conta teste = new ContaCorrente();
		teste.setAgencia("1111");
		teste.setNumero("20202020");
		
		boolean existeConta = contas.contains(teste);
		System.out.println("Existe conta? " + existeConta);
	}
	
	public static Set<Conta> recuperarContas(){
		Conta c1 = new ContaCorrente();
		Conta c2 = new ContaCorrente();
		Conta c3 = new ContaCorrente();

		c1.setAgencia("1111");
		c1.setNumero("20202020");
		c2.setAgencia("2222");
		c2.setNumero("40404040");
		c3.setAgencia("3333");
		c3.setNumero("60606060");
		
		Set<Conta> contas = new HashSet<>();
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		
		return contas;
	}
}

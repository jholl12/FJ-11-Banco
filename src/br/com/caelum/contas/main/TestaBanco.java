package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Banco;
import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaBanco {

	public static void main(String[] args) {
		Banco banco = new Banco ("Caelumbank", "3822", "010896249");
		
		Conta c1 = new ContaCorrente();
		c1.setTitular("Jhonata ");
		c1.setNumero("20202020");
		c1.setAgencia("000");
		c1.depositar(500);
		banco.adiciona(c1);
		
		Conta c2 = new ContaCorrente();
		c2.setTitular("Pereira ");
		c2.setNumero("50505050");
		c2.setAgencia("999");
		c2.depositar(300);
		banco.adiciona(c2);
		
		
	}

}

package br.com.caelum.contas.exercicios;

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
		c2.setTitular("Pereira");
		c2.setNumero("50505050");
		c2.setAgencia("999");
		c2.depositar(300);
		banco.adiciona(c2);
		
		Conta c3 = new ContaCorrente();
		c3.setTitular("DetonaFunk");
		c3.setNumero("60506050");
		c3.setAgencia("555");
		c3.depositar(850);
		banco.adiciona(c3);
		
		Conta c4 = new ContaCorrente();
		c4.setTitular("Maike");
		c4.setNumero("69696969");
		c4.setAgencia("333");
		c4.depositar(780);
		banco.adiciona(c4);
		
//		banco.mostraContas();
//		boolean ok = banco.contem(c3);
//		System.out.println(ok);
		
		banco.hashCode();
		Conta teste = banco.buscarTitular("DetonaFunk");
		System.out.println(teste);
	}
}
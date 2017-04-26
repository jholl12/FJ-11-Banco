package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaArrays {

	public static void main(String[] args) {
		Conta[] contas = new Conta[10];
		
		for (int i = 0; i < contas.length; i++) {
			Conta conta = new ContaCorrente();
			conta.depositar((i + 1) * 100);
			contas[i] = conta;
		}
		
		for (int i = 0; i < contas.length; i++) {
			Conta saldo = contas[i];
			//saldo += (saldo.getSaldo() + contas[i].getSaldo())/10;
			System.out.println(saldo.getSaldo());
		}
	}

}

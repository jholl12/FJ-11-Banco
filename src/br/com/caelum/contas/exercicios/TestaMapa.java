package br.com.caelum.contas.exercicios;

import java.util.HashMap;
import java.util.Map;
import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaMapa {

	public static void main(String[] args) {
		Conta c1 = new ContaCorrente();
		c1.depositar(10000);
		
		Conta c2 = new ContaCorrente();
		c2.depositar(3000);
		
		
		Map<String, Conta> mapaDeContas = new HashMap<>();
		mapaDeContas.put("diretor", c1);
		mapaDeContas.put("gerente", c2);
		
		Conta contaDiretor = (Conta) mapaDeContas.get("diretor");
		System.out.println(contaDiretor.getSaldo());
	}
}

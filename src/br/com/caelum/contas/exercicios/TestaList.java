package br.com.caelum.contas.exercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaList {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Sergio");
		lista.add("Paulo");
		lista.add("Guilherme");
		
		System.out.println(lista);
		
		Collections.sort(lista);
		
		System.out.println(lista);
		
		System.out.println("#####################");
		
//		ContaCorrente c1 = new ContaCorrente();
//		ContaCorrente c2 = new ContaCorrente();
//		ContaCorrente c3 = new ContaCorrente();
//		
//		c1.depositar(500);
//		c2.depositar(200);
//		c3.depositar(150);
//		
//		List<ContaCorrente> contas = new ArrayList<>();
//		contas.add(c1);
//		contas.add(c2);
//		contas.add(c3);
//		
//		Collections.sort(contas);
//		
//		System.out.println(contas);
		
		System.out.println("######################");
		
		List<Conta> listaContas = new LinkedList<>();
		
		for(int i = 0; i < 5; i++){
			Random r = new Random();
			Conta conta = new ContaCorrente();
			conta.setTitular(" "+ i);
			conta.depositar(r.nextInt(5));
			listaContas.add(conta);
		}
		
		System.out.println(listaContas);
	}
}

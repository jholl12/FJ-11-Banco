package br.com.caelum.contas.exercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Desafio2_1516 {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();
		
		for (int i = 0; i < 1000; i++) {
			numeros.add(i);
		}
		
		Collections.reverse(numeros);
		
		Iterator<Integer> iterator = numeros.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}

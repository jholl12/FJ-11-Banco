package br.com.caelum.contas.exercicios;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Desafio1_1516 {
	static Set<Integer> numeros;
	
	public static void main(String[] args) {
		numeros = new TreeSet<Integer>();
		
		for (int i = 0; i <= 1000; i++) {
			numeros.add(i);
		}
		
		numeros = ((TreeSet<Integer>) numeros).descendingSet();
		
		Iterator<Integer> iterator = numeros.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}

package br.com.caelum.contas.exercicios;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Desafio1516 implements Comparable<Integer>{
	static Set<Integer> numeros;
	
	public static void main(String[] args) {
		numeros = new TreeSet<>();
		
		for (int i = 0; i <= 1000; i++) {
			numeros.add(i);
		}
		
		//Collections.sort(numeros);
		
		Iterator<Integer> iterator = numeros.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	@Override
	public int compareTo(Integer o) {
//		if(){
//			return -1;
//		}
//		
//		if(){
//			return 1;
//		}
		
		return 0;
	}

}

package br.com.caelum.contas.main;

import java.util.ArrayList;
import java.util.List;

public class Overhead {

	public static void main(String[] args) {
		boolean loop = true; 
		List<Integer> lista = new ArrayList<Integer>();
		System.out.println(Runtime.getRuntime().freeMemory());
		while (loop){
			try{
				lista.add(new Integer(33));
				System.out.println(lista);
			}catch(OutOfMemoryError err){
				System.out.println(Runtime.getRuntime().freeMemory());
			}
		}		
	}
}

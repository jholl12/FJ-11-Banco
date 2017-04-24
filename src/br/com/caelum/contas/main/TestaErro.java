package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaErro {

	public static void main(String[] args) {
		System.out.println("Inicio do main");
		metodo1();
		System.out.println("Fim do main");
	}

	static void metodo1(){
		System.out.println("Inicio do metodo 1");
		metodo2();
		System.out.println("Fim do metodo 1");
	}
	
	static void metodo2(){
		System.out.println("Inicio do metodo 2");
		ContaCorrente cc = new ContaCorrente();
		
		try {
			for (int i = 0; i <15; i++) {
				cc.depositar(i + 1000);
				System.out.println(cc.getSaldo());
				if(i == 5){
					cc = null;
				}
			}	
		} catch (NullPointerException e) {
			System.out.println("erro: " + e);
		}
		
		System.out.println("Fim do metodo 2");
	}
}

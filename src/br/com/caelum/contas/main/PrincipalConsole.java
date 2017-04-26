//---
//Pacote
//----------
package br.com.caelum.contas.main;

import java.io.OutputStream;
import java.io.PrintStream;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;

/**
 * @description Classe responsável por fazer as chamadas dos métodos criados na
 *              classe conta e manipular a troca de mensagem dos objetos no
 *              console
 * @author Jhonata Santos
 * @version 1.0
 *
 */
public class PrincipalConsole extends Object{
	public static void main(String[] args) {
		/*System.out.println("");
		System.out.println("============ CONTA 1 ============");
		Conta c1 = new Conta("Jhonata Santos", "3822", "01089624-9", 500);
		c1.sacar(100);
		c1.depositar(10);
		System.out.println(c1.toString());
		System.out.println("Rendimento: R$" + c1.getRendimentos());

		System.out.println("");
		System.out.println("============ CONTA 2 ============");
		Conta c2 = new Conta("2238", "6589478-2");
		c2.depositar(10);
		c2.sacar(5);
		System.out.println(c2.toString());
		System.out.println("Rendimento: R$" + c2.getRendimentos());

		System.out.println("");
		System.out.println("============ CONTA 3 ============");
		Conta c3 = new Conta();
		c3.depositar(50);
		c3.sacar(5);
		System.out.println(c3.toString());
		System.out.println("Rendimento: R$" + c3.getRendimentos());

		System.out.println("");
		System.out.println("--------------------------------");
		System.out.println("Quantidade de contas criadas :" + Conta.getContador());
		System.out.println("--------------------------------");*/
		
		String s = "fj-11";
		s = s.replaceAll("1", "2");
		System.out.println(s);
		
		StringBuilder teste = new StringBuilder("Teste ");
		
		for(int i = teste.length() - 1; i >= 0; i--){
			System.out.print(teste.charAt(i));
		}
		
	}
}

package br.com.caelum.contas.exercicios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {
		System.out.println("Iniciando...");

		Collection<Integer> teste = new ArrayList<>();

		//long inicio = System.currentTimeMillis();
		int total = 100000;

		long insercao = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			teste.add(i);
		}
		long endInsercao = System.currentTimeMillis();
		
		long pesquisa = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}
		long endPesquisa = System.currentTimeMillis();
		
		//long fim = System.currentTimeMillis();
		long tempoInsercao = endInsercao - insercao;
		long tempoPesquisando = endPesquisa - pesquisa;
		System.out.println("Tempo gasto inserindo: " + tempoInsercao);
		System.out.println("Tempo gasto pesquisando: " + tempoPesquisando);
		
		System.out.println("Fim...");
	}
}

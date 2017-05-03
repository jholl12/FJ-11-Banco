package br.com.caelum.contas.exercicios;

import java.util.LinkedList;
import java.util.List;

public class TestaPerformanceDeAdicionarNaPrimeiraPosicao {

	public static void main(String[] args) {
		System.out.println("Iniciando...");
		List<Integer> teste = new LinkedList<>();

		long insercao = System.currentTimeMillis();
		for (int i = 0; i < 30000; i++) {
			teste.add(i);
		}
		long endInsercao = System.currentTimeMillis();

		long pesquisa = System.currentTimeMillis();
		for (int i = 0; i < 30000; i++) {
			teste.contains(i);
		}
		long endPesquisa = System.currentTimeMillis();

		double tempoInsercao = (endInsercao - insercao) / 1000.0;
		double tempoPesquisa = (endPesquisa - pesquisa) / 1000.0;
		
		System.out.println("Tempo gasto inserindo: " + tempoInsercao);
		System.out.println("Tempo gasto pesquisando: " + tempoPesquisa);

		System.out.println("Fim...");
	}
}

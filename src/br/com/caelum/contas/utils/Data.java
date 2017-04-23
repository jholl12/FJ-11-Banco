//---
//Pacote
//----------
package br.com.caelum.contas.utils;

public class Data {

	/**
	 * Atributos da classe
	 */
	int dia;
	int mes;
	int ano;

	/**
	 * Construtor Principal Completo
	 * 
	 * @param d
	 * @param m
	 * @param a
	 */
	public Data(int d, int m, int a) {
		dia = d;
		mes = m;
		ano = a;
	}

	public String formatarData() {
		return dia + "/" + mes + "/" + ano;
	}
}

//---
//Pacote
//----------
package br.com.caelum.contas;

//---
//Imports
//----------
import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

/**
 * @description Classe responsável por fazer a ligação da Interface e a classe
 *              Conta modelada
 * @author Jhonata Santos
 * @version 1.0
 *
 */
public class ManipuladorDeContas {
	// ---
	// Atributos
	// ----------
	private Conta conta;

	/**
	 * @description Método responsável por criar uma nova conta obtendo o valor
	 *              que o usuário informar e verificar o tipo de conta que está
	 *              sendo criada
	 * @param evento
	 */
	public void criaConta(Evento evento) {
		String tipo = evento.getSelecionadoNoRadio("tipo");

		//Verifica se é conta corrente ou poupança
		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else if (tipo.equals("Conta Poupan�a")) {
			this.conta = new ContaPoupanca();
		}

		//Realiza os sets de valores
		this.conta.setTitular(evento.getString("titular"));
		this.conta.setNumero(evento.getString("numero"));
		this.conta.setAgencia(evento.getString("agencia"));
	}

	/**
	 * @description Método responsável por depositar um valor em conta com base
	 *              no que foi informado pelo usuário
	 * @param evento
	 */
	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.depositar(valorDigitado);
	}

	/**
	 * @description Método responsável por realizar um saque na conta com base
	 * 				no que foi informado pelo usuário
	 * @param evento
	 */
	public void saca(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.sacar(valorDigitado);
	}
	
	public void transfere(Evento evento){
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
		conta.transferir(destino, evento.getDouble("valorTransferencia"));
	}
}
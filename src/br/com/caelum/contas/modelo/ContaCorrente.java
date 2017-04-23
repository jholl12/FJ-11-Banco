//---
//Pacote
//----------
package br.com.caelum.contas.modelo;

/**
 * @description
 * @author Jhonata Santos
 * @version 1.0
 */
public class ContaCorrente extends Conta implements Tributavel {

	/**
	 * @description Get Tipo da Conta
	 * @author Jhonata Santos
	 */
	public String getTipo() {
		return "Conta Corrente";
	}

	/**
	 * @description Método que realiza o saque da conta com uma taxa de juros
	 *              caso a conta seja do tipo "Conta Corrente"
	 * @author Jhonata Santos
	 */
	@Override
	public boolean sacar(double valor) {
		this.saldo -= (valor + 0.10);
		return true;
	}

	@Override
	public double getValorImposto() {
		return this.getSaldo() * 0.01;
	}
}

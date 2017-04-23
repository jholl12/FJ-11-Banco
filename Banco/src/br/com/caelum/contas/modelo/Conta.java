//---
//Pacote
//----------
package br.com.caelum.contas.modelo;

/**
 * @description Classe responsavel por realizar as açoes de uma conta, contendo
 *              suas devidas regras de negocio
 *              
 * @author Jhonata Santos
 * @version 1.0
 */
public abstract class Conta { //Classe abstrata genérica servindo como modelo para as classes filhas de especializacao
	// ---
	// Atributos
	// ----------
	private String nome;
	private String agencia;
	private String numero;
	protected double saldo;
	private int indentificador = 1;
	private static int contador;

	/**
	 * @description Construtor Principal Completo
	 * 
	 * @param nome
	 * @param agencia
	 * @param numero
	 * @param saldo
	 * 
	 * @author Jhonata Santos
	 */
	public Conta(String nome, String agencia, String numero, double saldo) {
		this.nome = nome;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;

		// Realiza a contagem de quantas contas foram instanciadas pela classe
		indentificador += contador++;
	}

	/**
	 * @description Construtor Secundario Resumido
	 * 
	 * @param agencia
	 * @param numero
	 * 
	 * @author Jhonata Santos
	 */
	public Conta(String agencia, String numero) {
		// This referencia o construtor principal
		this("", agencia, numero, 0);
	}

	/**
	 * @description Construtor Vazio realizando apenas o contador de contas
	 * 
	 * @author Jhonata Santos
	 */
	public Conta() {
		indentificador += contador++;
	}

	/**
	 * @description GET Nome
	 * 
	 * @return o nome do titular
	 * 
	 * @author Jhonata Santos
	 */
	public String getTitular() {
		return nome;
	}

	/**
	 * @description GET Agencia
	 * 
	 * @return o numero da agencia
	 * 
	 * @author Jhonata Santos
	 */
	public String getAgencia() {
		return agencia;
	}

	/**
	 * @description GET Numero
	 * 
	 * @return o numero da conta
	 * 
	 * @author Jhonata Santos
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @description GET Saldo
	 * 
	 * @return o saldo bancario
	 * 
	 * @author Jhonata Santos
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @description GET Indentificador
	 * 
	 * @return o indentificador da conta (ID da conta)
	 * 
	 * @author Jhonata Santos
	 */
	public int getIndentificador() {
		return indentificador;
	}

	/**
	 * @description GET Tipo da Conta
	 * 
	 * @return o tipo da conta
	 * 
	 * @author Jhonata Santos
	 */
	public abstract String getTipo(); //Método abstrato generico sendo obrigatorio a implementacao dele nas classes filhas de acordo com a regra de negocio

	/**
	 * @description SET Nome
	 * 
	 * @param nome
	 * 
	 * @author Jhonata Santos
	 */
	public void setTitular(String nome) {
		this.nome = nome;
	}

	/**
	 * @description SET Agencia
	 * 
	 * @param agencia
	 * 
	 * @author Jhonata Santos
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	/**
	 * @description SET Numero
	 * 
	 * @param numero
	 * 
	 * @author Jhonata Santos
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @description Obtem os dados do estado atual da conta
	 * 
	 * @author Jhonata Santos
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\nAgÃªncia: " + agencia + "\nNumero: " + numero + "\nSaldo: " + saldo
				+ "\nIndentificador: " + indentificador + "\nTipo: " + getTipo();
	}

	/**
	 * @description Realiza uma operacao de saque do saldo da conta
	 * 
	 * @param valor a ser sacado
	 * @return true se a operacao foi realizada com sucesso
	 * 
	 * @author Jhonata Santos
	 */
	public boolean sacar(double valor) {
		if (this.saldo > 0 && valor <= this.saldo) {
			this.saldo -= valor;
			return true;
		} else {
			System.out.println("Saldo insuficiente para saque!");
			return false;
		}
	}

	/**
	 * @description Realiza um deposito incluindo um valor no saldo da conta
	 * 
	 * @param valor que sera inserido na conta
	 * @return true se a operacao foi realizada com sucesso
	 * 
	 * @author Jhonata Santos
	 */
	public boolean depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			return true;
		} else {
			System.out.println("Valor insuficiente para deposito!");
			return false;
		}
	}

	/**
	 * @description Realiza uma transferencia bancaria
	 * 
	 * @param destino que recebera o valor
	 * @param valor que sera transferido
	 * @return true se a operacaoo foi realizada com sucesso
	 * 
	 * @author Jhonata Santos
	 */
	public boolean transferir(Conta destino, double valor) {
		if (destino != null && valor != 0) {
			boolean retirada = this.sacar(valor);
			if (retirada) {
				destino.depositar(valor);
				return true;
			}

			System.out.println("Impossivel realizar a transferencia!");
			return false;
		} else {
			System.out.println("Por favor informe um saldo maior que 0 e um destino!");
			return false;
		}
	}
	
	/**
	 * @description Realiza o calculo de  rendimentos com base no saldo
	 * 
	 * @return o valor do calculo de rendimentos
	 * 
	 * @author Jhonata Santos
	 */
	public double calcularRendimentos() {
		return this.saldo *= 0.1;
	}
}

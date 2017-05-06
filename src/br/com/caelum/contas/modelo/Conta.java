//---
//Pacote
//----------
package br.com.caelum.contas.modelo;

//---
//Imports
//----------
import br.com.caelum.contas.exceptions.SaldoInsuficienteException;

/**
 *  Classe responsavel por realizar as açoes de uma conta, contendo
 *              suas devidas regras de negocio
 * 
 * @author Jhonata Santos
 * @version 1.0
 */
public abstract class Conta implements Comparable<Conta>{ // Classe abstrata genérica servindo como modelo
								// para as classes filhas de especializacao
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
	 *  Construtor Principal Completo
	 * 
	 * @param nome
	 * @param agencia
	 * @param numero
	 * @param saldo
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
	 * Construtor Secundario Resumido
	 * 
	 * @param agencia
	 * @param numero
	 * @author Jhonata Santos
	 */
	public Conta(String agencia, String numero) {
		// This referencia o construtor principal
		this("", agencia, numero, 0);
	}

	/**
	 * Construtor Vazio realizando apenas o contador de contas
	 * 
	 * @author Jhonata Santos
	 */
	public Conta() {
		indentificador += contador++;
	}

	/**
	 * GET Nome
	 * 
	 * @return o nome do titular
	 * @author Jhonata Santos
	 */
	public String getTitular() {
		return nome;
	}

	/**
	 * GET Agencia
	 * 
	 * @return o numero da agencia
	 * @author Jhonata Santos
	 */
	public String getAgencia() {
		return agencia;
	}

	/**
	 * GET Numero
	 * 
	 * @return o numero da conta
	 * @author Jhonata Santos
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * GET Saldo
	 * 
	 * @return o saldo bancario
	 * @author Jhonata Santos
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * GET Indentificador
	 * 
	 * @return o indentificador da conta (ID da conta) 
	 * @author Jhonata Santos
	 */
	public int getIndentificador() {
		return indentificador;
	}

	/**
	 * GET Tipo da Conta
	 * 
	 * @return o tipo da conta 
	 * @author Jhonata Santos
	 */
	public abstract String getTipo(); // Método abstrato generico sendo
										// obrigatorio a implementacao dele nas
										// classes filhas de acordo com a regra
										// de negocio

	/**
	 * SET Nome
	 * 
	 * @param nome
	 * @author Jhonata Santos
	 */
	public void setTitular(String nome) {
		this.nome = nome;
	}

	/**
	 * SET Agencia
	 * 
	 * @param agencia
	 * @author Jhonata Santos
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	/**
	 * SET Numero
	 * 
	 * @param numero
	 * @author Jhonata Santos
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 *  Realiza uma operacao de saque do saldo da conta
	 * 
	 * @param valor a ser sacado
	 * @return true se a operacao foi realizada com sucesso
	 * @author Jhonata Santos
	 */
	public boolean sacar(double valor) {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException(valor);
		}

		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		}

		this.saldo -= valor;
		return true;
	}

	/**
	 *  Realiza um deposito incluindo um valor no saldo da conta
	 * 
	 * @param valor que sera inserido na conta
	 * @return true se a operacao foi realizada com sucesso
	 * @author Jhonata Santos
	 */
	public boolean depositar(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		}

		if (valor == 0) {
			throw new IllegalArgumentException("Impossivel depositar R$" + valor);
		}

		this.saldo += valor;
		return true;
	}

	/**
	 * Realiza uma transferencia bancaria
	 * 
	 * @param destino que recebera o valor
	 * @param valor que sera transferido
	 * @return true se a operacaoo foi realizada com sucesso
	 * @author Jhonata Santos
	 */
	public void transferir(Conta destino, double valor) {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException(valor);
		}

		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou transferir um valor negativo");
		}

		if (valor == 0) {
			throw new IllegalArgumentException("Impossivel transferir R$" + valor);
		}

		if (destino == null) {
			throw new IllegalArgumentException("Conta de destino vazio!");
		}

		this.saldo -= valor;
		destino.depositar(valor);
	}

	/**
	 * Realiza o calculo de rendimentos com base no saldo
	 * 
	 * @return o valor do calculo de rendimentos
	 * @author Jhonata Santos
	 */
	public double calcularRendimentos() {
		return this.saldo *= 0.1;
	}
	
	//OVERRIDES
	
	/**
	 * Obtem os dados do estado atual da conta
	 * 
	 * @author Jhonata Santos
	 */
	@Override
	public String toString() {
		if(nome != null){
			nome = nome.toUpperCase();	
		}
		
		return "Titular: " + this.nome + "\nAgência: " + agencia + "\nNumero: " + numero;
	}
	
	/**
	 * Compara se já existe um titular cadastrado
	 * 
	 * @author Jhonata Santos
	 */
	@Override
	public int compareTo(Conta outraConta) {
		if(outraConta == null){
			throw new NullPointerException("Objeto vazio!");
		}
		
		return this.getTitular().compareTo(outraConta.getTitular());
	}
	
//	/**
//	 * Cria um hashCode com base na agência e número
//	 * 
//	 * @author Jhonata Santos
//	 */
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
//		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Conta other = (Conta) obj;
//		if (agencia == null) {
//			if (other.agencia != null)
//				return false;
//		} else if (!agencia.equals(other.agencia))
//			return false;
//		if (numero == null) {
//			if (other.numero != null)
//				return false;
//		} else if (!numero.equals(other.numero))
//			return false;
//		return true;
//	}
}

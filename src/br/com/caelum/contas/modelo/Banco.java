package br.com.caelum.contas.modelo;

import java.util.HashMap;
import java.util.Map;

public class Banco {
	private String nome;
	private String agencia;
	private String numero;
	private Map<String, Conta> mapContas;
	
	private Conta[] contas;
	private Conta[] contasMax;
	
	public Banco(String nome, String agencia, String numero){
		setNome(nome);
		setAgencia(agencia);
		setNumero(numero);
		this.contas = new ContaCorrente[3];
		this.mapContas = new HashMap<>();
	}

	//GET
	
	public String getNome() {
		return nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}
	
	//SET
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	//CUSTOM
	
	/**
	 * Verifica se já existe um conta cadastrada
	 * 
	 * @param conta
	 * @return true se já existir uma conta
	 * @author Jhonata Santos
	 */
	public boolean contem(Conta conta) {
		for(Conta c : contas){
			if(conta.getNumero().equals(c.getNumero())){
				System.out.println("Conta já existente!");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Exibe os dados de todas as contas no console
	 * 
	 * @author Jhonata Santos
	 */
	public void mostraContas() {
		for (int i = 0; i < contas.length; i++) {
			System.out.println("Conta na posição: " + i);
			System.out.println(contas[i]);
			System.out.println("======================");
		}
	}
	
	/**
	 * Realiza a busca do titular com base no nome
	 * 
	 * @param nome
	 * @return a conta do titular
	 * @author Jhonata Santos
	 */
	public Conta buscarTitular(String nome){
		Conta c = mapContas.get(nome);
		return c;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void adiciona(Conta conta){
		for(int a = 0; a < contas.length; a ++){
			if(contas[a] == null){
				break;
			}
			
			if(a == contas.length - 1){		
				contasMax = new ContaCorrente[6];
				for(int o = 0; o < contas.length; o++){
					contasMax[o] = contas[o];
				}
			}
		}
		
		for (int i = 0; i < contas.length; i++) {
			if(contas[i] == null){
				contas[i] = conta;
				mapContas.put(conta.getTitular(), conta);
				System.out.println("Conta adicionada!");
		
				break;
			} 
		}
		System.out.println("#########################");
	}
}

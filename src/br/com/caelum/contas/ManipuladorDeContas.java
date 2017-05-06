//---
//Pacote
//----------
package br.com.caelum.contas;

import java.io.FileNotFoundException;
//---
//Imports
//----------
import java.util.Collections;
import java.util.List;

//---
//Imports
//----------
import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

/**
 * Classe responsável por fazer a ligação da Interface e a classe Conta modelada
 * 
 * @author Jhonata Santos
 * @version 1.0
 */
public class ManipuladorDeContas {
	// ---
	// Atributos
	// ----------
	private Conta conta;

	/**
	 * Métodos responsável por criar uma nova conta obtendo o valor que o
	 * usuário informar e verificar o tipo de conta que está¡ sendo criada
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void criaConta(Evento evento) {
		String tipo = evento.getSelecionadoNoRadio("tipo");

		// Verifica se é conta corrente ou poupança
		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else if (tipo.equals("Conta Poupança")) {
			this.conta = new ContaPoupanca();
		}

		// Realiza os sets de valores
		this.conta.setTitular(evento.getString("titular"));
		this.conta.setNumero(evento.getString("numero"));
		this.conta.setAgencia(evento.getString("agencia"));
	}

	/**
	 * Método responsável por depositar um valor em conta com base no que foi
	 * informado pelo usuário
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.depositar(valorDigitado);
	}

	/**
	 * Método responsável por realizar um saque na conta com base no que foi
	 * informado pelo usuário
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void saca(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.sacar(valorDigitado);
	}

	/**
	 * Método responsável por realizar uma transferência de valores entre contas
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void transfere(Evento evento) {
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
		conta.transferir(destino, evento.getDouble("valorTransferencia"));
	}

	/**
	 * Método responsável por ordenar a lista apresentada no combobox "Destino"
	 * ao realizar uma transferência
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void ordenaLista(Evento evento) {
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas); // Ordena crescente titular
		Collections.reverse(contas); // Inverte ordenação titular
		Collections.shuffle(contas); // Ordena aleatóriamente titular

	}

	/**
	 * Método responsável por salvar todas as contas criadas na aplicação em um
	 * arquivo TXT
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void salvaDados(Evento evento) {
		List<Conta> contas = evento.getLista("listaContas");
		RepositorioDeContas repositorio = new RepositorioDeContas();
		repositorio.salvar(contas);
	}

	/**
	 * Método responsável por carregar todas as contas salvas no arquivo TXT e
	 * apresentar na aplicação
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 * @throws FileNotFoundException 
	 */
	public List<Conta> carregaDados() throws FileNotFoundException {
		RepositorioDeContas repositorio = new RepositorioDeContas();
		return repositorio.carregarDados();
	}
}
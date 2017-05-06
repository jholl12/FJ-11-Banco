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
 * Classe respons�vel por fazer a liga��o da Interface e a classe Conta modelada
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
	 * M�todos respons�vel por criar uma nova conta obtendo o valor que o
	 * usu�rio informar e verificar o tipo de conta que est� sendo criada
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void criaConta(Evento evento) {
		String tipo = evento.getSelecionadoNoRadio("tipo");

		// Verifica se � conta corrente ou poupan�a
		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else if (tipo.equals("Conta Poupan�a")) {
			this.conta = new ContaPoupanca();
		}

		// Realiza os sets de valores
		this.conta.setTitular(evento.getString("titular"));
		this.conta.setNumero(evento.getString("numero"));
		this.conta.setAgencia(evento.getString("agencia"));
	}

	/**
	 * M�todo respons�vel por depositar um valor em conta com base no que foi
	 * informado pelo usu�rio
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.depositar(valorDigitado);
	}

	/**
	 * M�todo respons�vel por realizar um saque na conta com base no que foi
	 * informado pelo usu�rio
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void saca(Evento evento) {
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.sacar(valorDigitado);
	}

	/**
	 * M�todo respons�vel por realizar uma transfer�ncia de valores entre contas
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void transfere(Evento evento) {
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
		conta.transferir(destino, evento.getDouble("valorTransferencia"));
	}

	/**
	 * M�todo respons�vel por ordenar a lista apresentada no combobox "Destino"
	 * ao realizar uma transfer�ncia
	 * 
	 * @param evento
	 * @author Jhonata Santos
	 */
	public void ordenaLista(Evento evento) {
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas); // Ordena crescente titular
		Collections.reverse(contas); // Inverte ordena��o titular
		Collections.shuffle(contas); // Ordena aleat�riamente titular

	}

	/**
	 * M�todo respons�vel por salvar todas as contas criadas na aplica��o em um
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
	 * M�todo respons�vel por carregar todas as contas salvas no arquivo TXT e
	 * apresentar na aplica��o
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
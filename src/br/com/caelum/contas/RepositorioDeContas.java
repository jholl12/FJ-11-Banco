package br.com.caelum.contas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import javafx.scene.layout.Background;

public class RepositorioDeContas {

	public void salvar(List<Conta> contas) {
		PrintStream stream = null;
		try {
			stream = new PrintStream("contas.txt");

			for (Conta c : contas) {
				stream.println(c.getTipo() + "," + c.getNumero() + "," + c.getAgencia() + "," + c.getTitular() + ","
						+ c.getSaldo());
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Arquivo não encontrado! " + e);
		} finally {
			stream.close();
		}
	}

	public List<Conta> carregarDados() {
		Scanner scanner = null;
		List<Conta> contas = new ArrayList<>();

		try {
			File file = new File("contas.txt");
			scanner = new Scanner(file);
		
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				String[] valores = linha.split(",");

				if(linha.contains("Conta Corrente")){
					Conta cc = new ContaCorrente();
					cc.setNumero(valores[1]);
					cc.setAgencia(valores[2]);
					cc.setTitular(valores[3]);
					
					if(Double.parseDouble(valores[4]) > 0){
						cc.depositar(Double.parseDouble(valores[4]));
					}
						
					contas.add(cc);
				} else {
					Conta cp = new ContaPoupanca();
					cp.setNumero(valores[1]);
					cp.setAgencia(valores[2]);
					cp.setTitular(valores[3]);
					
					if(Double.parseDouble(valores[4]) > 0){
						cp.depositar(Double.parseDouble(valores[4]));
					}
					
					contas.add(cp);
				}
			}
		}  catch (FileNotFoundException e) {
			throw new RuntimeException("Arquivo não encontrado! " + e);
		} finally {
			scanner.close();
		}
		
		return contas;
	}
}

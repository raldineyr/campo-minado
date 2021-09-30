package br.com.raldineyr.campoMinado.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.raldineyr.campoMinado.excessao.ExplosaoException;
import br.com.raldineyr.campoMinado.excessao.sairException;
import br.com.raldineyr.campoMinado.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while (continuar) {
				cicloDoJogo();
				
				System.out.println("Outra partida? (S/n): ");
				
				String resposta = entrada.nextLine();
				
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			}
		}catch (sairException e) {
			System.out.println("ENCERRADO.");
		} finally {
			entrada.close();
		}
	}

	private void cicloDoJogo() {
		
		try {
			while(!tabuleiro.objetivoAlcancado()){
				System.out.printf(tabuleiro.toString());
				
				String digitado = capturarValorDigitado("\nDigite (X, Y): ");
			
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
				.map(e -> Integer.parseInt(e.trim())).iterator();
			
			digitado = capturarValorDigitado(" 1 - Abrir ou 2 - (Des)marcar: ");
			
			if ("1".equals(digitado)) {
				tabuleiro.abrir(xy.next(), xy.next());
				
			} else if("2".equals(digitado)) {
				tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			
			}
			System.out.println(tabuleiro);
			System.out.println("VOCÊ GANHOU!");
			
		}catch(ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("VOCÊ PERDEU!");
		}
		
	}
	private String capturarValorDigitado(String texto) {
		
		System.out.printf(texto);
		String digitado = entrada.nextLine();
		
		if ("sair".equalsIgnoreCase(digitado)) {
			throw new sairException();
		}
		
		return digitado;
	}

}

package br.com.raldineyr.campoMinado;

import br.com.raldineyr.campoMinado.modelo.Tabuleiro;
import br.com.raldineyr.campoMinado.visao.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
		
		new TabuleiroConsole(tabuleiro);

	}
}

package br.com.raldineyr.campoMinado.modelo;

@FunctionalInterface
public interface CampoObservador {
	
	public void eventoOcorreu(Campo campo, CampoEvento evento);

}

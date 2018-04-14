package com.gabriel.selecao.enun;

public enum StatusCurso {
	
	MATRICULADO(1),
	TRANCADO(2),
	JUBILADO(3);

	public int valorStatus;
	
	StatusCurso(int valor) {
		valorStatus = valor;
	}
	
	public int getValor() {
		return this.valorStatus;
	}
}

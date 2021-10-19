package com.eventos.uffs.demo.enums;

public enum CargoIdEnum {
    ADMINISTRADOR(1), GESTOR(2), USUARIO(3);

    private int valor;

	CargoIdEnum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
}

package com.eventos.uffs.demo.exception;

public class UsuarioSemPermissaoException extends Exception {
    
    public UsuarioSemPermissaoException(String mensagem) {
        super(mensagem);
    }
}

package br.com.desafio.restapipagamento.service.exceptions;

public class PagamentoNotFoundException extends RuntimeException{
    public PagamentoNotFoundException(String message) {
        super(message);
    }
}

package br.com.desafio.totalshake.service.exceptions;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException() {
    }

    public InvalidIdException(String message) {
        super(message);
    }
}

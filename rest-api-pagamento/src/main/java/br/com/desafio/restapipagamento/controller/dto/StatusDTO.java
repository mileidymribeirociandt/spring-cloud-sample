package br.com.desafio.restapipagamento.controller.dto;

import br.com.desafio.restapipagamento.domain.entity.enums.Status;

import javax.validation.constraints.NotNull;

public class StatusDTO {

    @NotNull
    private Status status;

    public StatusDTO(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}

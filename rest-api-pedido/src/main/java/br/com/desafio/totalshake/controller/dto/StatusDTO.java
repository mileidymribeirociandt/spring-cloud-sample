package br.com.desafio.totalshake.controller.dto;

import br.com.desafio.totalshake.domain.entity.Status;

public class StatusDTO {
    private Status status;

    private StatusDTO() {
    }

    public StatusDTO(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
package br.com.desafio.restapipagamento.controller.dto;

import br.com.desafio.restapipagamento.domain.entity.enums.FormaDePagamento;
import br.com.desafio.restapipagamento.domain.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PagamentoDTO {

    @NotNull
    @Positive
    private BigDecimal valor;

    @Size(min = 2, max = 100)
    private String nome;

    @Size(min = 2, max = 100)
    private String numero;

    @NotNull
    private String expiracao;

    @Size(min = 3, max = 3)
    private String codigo;

    @NotNull
    private Status status;

    @NotNull
    @JsonProperty("pedido_id")
    private Long pedidoId;

    @NotNull
    @JsonProperty("forma_de_pagamento")
    private FormaDePagamento formaDePagamento;

    private PagamentoDTO(BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, Long pedidoId, FormaDePagamento formaDePagamento) {
        this.valor = valor;
        this.nome = nome;
        this.numero = numero;
        this.expiracao = expiracao;
        this.codigo = codigo;
        this.status = status;
        this.pedidoId = pedidoId;
        this.formaDePagamento = formaDePagamento;
    }

    public static PagamentoDTO of (BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, Long pedidoId, FormaDePagamento formaDePagamento){
        return new PagamentoDTO(valor, nome, numero, expiracao, codigo, status, pedidoId, formaDePagamento);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getExpiracao() {
        return expiracao;
    }

    public String getCodigo() {
        return codigo;
    }

    public Status getStatus() {
        return status;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }
}

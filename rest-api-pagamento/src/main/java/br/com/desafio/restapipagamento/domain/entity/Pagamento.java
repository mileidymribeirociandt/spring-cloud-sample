package br.com.desafio.restapipagamento.domain.entity;

import br.com.desafio.restapipagamento.domain.entity.enums.FormaDePagamento;
import br.com.desafio.restapipagamento.domain.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @Size(min = 2, max = 100)
    @Column(length = 100)
    private String nome;

    @Size(min = 2, max = 100)
    @Column(length = 100)
    private String numero;

    @NotNull
    private String expiracao;

    @Size(min = 3, max = 3)
    @Column(length = 3)
    private String codigo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Column(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_de_pagamento")
    private FormaDePagamento formaDePagamento;

    private Pagamento() {
    }

    private Pagamento (BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, Long pedidoId, FormaDePagamento formaDePagamento) {
        this.valor = valor;
        this.nome = nome;
        this.numero = numero;
        this.expiracao = expiracao;
        this.codigo = codigo;
        this.status = status;
        this.pedidoId = pedidoId;
        this.formaDePagamento = formaDePagamento;
    }

    private Pagamento(Long id, BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, Long pedidoId, FormaDePagamento formaDePagamento) {
        this(valor, nome, numero, expiracao, codigo, status, pedidoId, formaDePagamento);
        this.id = id;
    }

    public static Pagamento of (BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, Long pedidoId, FormaDePagamento formaDePagamento){
        return new Pagamento(valor, nome, numero, expiracao, codigo, status, pedidoId, formaDePagamento);
    }

    public static Pagamento of (Long id, BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, Long pedidoId, FormaDePagamento formaDePagamento){
        return new Pagamento(id, valor, nome, numero, expiracao, codigo, status, pedidoId, formaDePagamento);
    }

    public Long getId() {
        return id;
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

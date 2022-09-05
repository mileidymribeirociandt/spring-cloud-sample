package br.com.desafio.restapipagamento.service;

import br.com.desafio.restapipagamento.controller.dto.PagamentoDTO;

import java.util.List;

public interface PagamentoService {
    PagamentoDTO findById(Long id);

    List<PagamentoDTO> findAll();

    PagamentoDTO save(PagamentoDTO pagamentoDTO);

    PagamentoDTO update(PagamentoDTO pagamentoDTO, Long id);

    void deleteById(Long id);
}

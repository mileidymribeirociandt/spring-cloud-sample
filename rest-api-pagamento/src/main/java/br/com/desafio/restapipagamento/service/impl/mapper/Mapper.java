package br.com.desafio.restapipagamento.service.impl.mapper;

import br.com.desafio.restapipagamento.controller.dto.PagamentoDTO;
import br.com.desafio.restapipagamento.domain.entity.Pagamento;

import java.util.List;

public class Mapper {

    public static List<PagamentoDTO> toPagamentoDTOList(List<Pagamento> pagamentoList){
        return pagamentoList.stream()
                .map(pagamento -> toPagamentoDTO(pagamento))
                .toList();
    }

    public static PagamentoDTO toPagamentoDTO(Pagamento pagamento){
        return PagamentoDTO.of(
                pagamento.getValor(),
                pagamento.getNome(),
                pagamento.getNumero(),
                pagamento.getExpiracao(),
                pagamento.getCodigo(),
                pagamento.getStatus(),
                pagamento.getPedidoId(),
                pagamento.getFormaDePagamento());
    }

    public static Pagamento toPagamento(PagamentoDTO pagamentoDTO){
        return Pagamento.of(
                pagamentoDTO.getValor(),
                pagamentoDTO.getNome(),
                pagamentoDTO.getNumero(),
                pagamentoDTO.getExpiracao(),
                pagamentoDTO.getCodigo(),
                pagamentoDTO.getStatus(),
                pagamentoDTO.getPedidoId(),
                pagamentoDTO.getFormaDePagamento());
    }

    public static Pagamento toPagamento(PagamentoDTO pagamentoDTO, Long id){
        return Pagamento.of(
                id,
                pagamentoDTO.getValor(),
                pagamentoDTO.getNome(),
                pagamentoDTO.getNumero(),
                pagamentoDTO.getExpiracao(),
                pagamentoDTO.getCodigo(),
                pagamentoDTO.getStatus(),
                pagamentoDTO.getPedidoId(),
                pagamentoDTO.getFormaDePagamento());
    }

}

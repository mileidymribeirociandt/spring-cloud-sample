package br.com.desafio.restapipagamento.proxy;

import br.com.desafio.restapipagamento.controller.dto.StatusDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = "rest-api-pedido")
public interface PedidoProxy {

    @PutMapping("/api/v1/pedidos/pedido/{id}/status")
    public ResponseEntity<String> updatePedidoStatus(
            @PathVariable(required = true) Long id,
            @RequestBody @Valid StatusDTO statusDTO);
}

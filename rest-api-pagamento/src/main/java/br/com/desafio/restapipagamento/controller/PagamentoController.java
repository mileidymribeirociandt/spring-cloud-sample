package br.com.desafio.restapipagamento.controller;

import br.com.desafio.restapipagamento.controller.dto.PagamentoDTO;
import br.com.desafio.restapipagamento.controller.dto.StatusDTO;
import br.com.desafio.restapipagamento.domain.entity.enums.Status;
import br.com.desafio.restapipagamento.proxy.PedidoProxy;
import br.com.desafio.restapipagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private PedidoProxy pedidoProxy;

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> getPagamentos(){
        return new ResponseEntity<>(pagamentoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/pagamento/{id}")
    public ResponseEntity<PagamentoDTO> getPagamentoById(@PathVariable Long id){
        return new ResponseEntity<>(pagamentoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> savePagamento(@RequestBody @Valid PagamentoDTO pagamentoDTO){
        if(isPagamentoConfirmado(pagamentoDTO.getStatus())) {
            pedidoProxy.updatePedidoStatus(pagamentoDTO.getPedidoId(), new StatusDTO(pagamentoDTO.getStatus()));
        }
        return new ResponseEntity<>(pagamentoService.save(pagamentoDTO), HttpStatus.OK);
    }

    @PutMapping("/pagamento/{id}")
    public ResponseEntity<PagamentoDTO> updatePagamento(@RequestBody @Valid PagamentoDTO pagamentoDTO, @PathVariable Long id){
        if(isPagamentoConfirmado(pagamentoDTO.getStatus())) {
            pedidoProxy.updatePedidoStatus(pagamentoDTO.getPedidoId(), new StatusDTO(pagamentoDTO.getStatus()));
        }
        return new ResponseEntity<>(pagamentoService.update(pagamentoDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/pagamento/{id}/delete")
    public ResponseEntity<String> deletePagamento(@PathVariable Long id){
        pagamentoService.deleteById(id);
        return new ResponseEntity<>("Pedido deletado!", HttpStatus.OK);
    }

    private boolean isPagamentoConfirmado(Status status){
        return Status.CONFIRMADO.equals(status);
    }
}

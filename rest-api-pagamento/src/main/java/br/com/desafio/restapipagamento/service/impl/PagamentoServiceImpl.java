package br.com.desafio.restapipagamento.service.impl;

import br.com.desafio.restapipagamento.controller.dto.PagamentoDTO;
import br.com.desafio.restapipagamento.domain.entity.Pagamento;
import br.com.desafio.restapipagamento.domain.repository.PagamentoRepository;
import br.com.desafio.restapipagamento.service.PagamentoService;
import br.com.desafio.restapipagamento.service.exceptions.InvalidIdException;
import br.com.desafio.restapipagamento.service.exceptions.PagamentoNotFoundException;
import br.com.desafio.restapipagamento.service.impl.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public PagamentoDTO findById(Long id){
        verifyId(id);
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new PagamentoNotFoundException("Pagamento not found!");
                });
        return Mapper.toPagamentoDTO(pagamento);
    }

    @Override
    public List<PagamentoDTO> findAll(){
        return Mapper.toPagamentoDTOList(pagamentoRepository.findAll());
    }

    @Override
    public PagamentoDTO save(PagamentoDTO pagamentoDTO){
        Pagamento savedPagamento = pagamentoRepository.save(Mapper.toPagamento(pagamentoDTO));
        return Mapper.toPagamentoDTO(savedPagamento);
    }

    @Override
    public PagamentoDTO update(PagamentoDTO pagamentoDTO, Long id){
        findById(id);
        Pagamento savedPagamento = pagamentoRepository.save(Mapper.toPagamento(pagamentoDTO, id));
        return Mapper.toPagamentoDTO(savedPagamento);
    }

    @Override
    public void deleteById(Long id){
        findById(id);
        pagamentoRepository.deleteById(id);
    }

    private void verifyId(Long id){
        if(!isValidId(id)){
            throw new InvalidIdException("Id is not valid! Should be bigger than 0 and not null!");
        }
    }

    private boolean isValidId(Long id){
        return id != null && id > 0;
    }
}

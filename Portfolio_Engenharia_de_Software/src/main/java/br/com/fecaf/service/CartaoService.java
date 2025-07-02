package br.com.fecaf.service;

import br.com.fecaf.model.Cartao;
import br.com.fecaf.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public List<Cartao> listarCartao(){
        return cartaoRepository.findAll();
    }

    public Cartao adicionarCartao(Cartao novo_cartao){
        return cartaoRepository.save(novo_cartao);
    }

    public Cartao atualizarCartao(int id, Cartao cartao){
        return cartaoRepository.findById(id).map(cartao_atualizar -> {
            cartao_atualizar.setTitulo_cartao(cartao.getTitulo_cartao());
            cartao_atualizar.setDescricao(cartao.getDescricao());
            cartao_atualizar.setPrioridade(cartao.getPrioridade());
            cartao_atualizar.setSituacao(cartao.getSituacao());
            cartao_atualizar.setData_inicio(cartao.getData_inicio());
            cartao_atualizar.setData_final(cartao.getData_final());
            cartao_atualizar.setId_mural(cartao.getId_mural());
            return cartaoRepository.save(cartao_atualizar);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletarCartao(int id){
        cartaoRepository.deleteById(id);
    }

}

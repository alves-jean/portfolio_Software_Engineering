package br.com.fecaf.service;

import br.com.fecaf.model.Financas;
import br.com.fecaf.repository.FinancasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FinancasService {

    @Autowired
    private FinancasRepository financasRepository;

    public List<Financas> listarFinancas(){
        return financasRepository.findAll();
    }

    public Financas adicionarFinancas(Financas nova_financa){
        return financasRepository.save(nova_financa);
    }

    public Financas atualizarFinancas(int id, Financas financas){
        return financasRepository.findById(id).map(financaAtualizada -> {
            financaAtualizada.setValor_servico(financas.getValor_servico());
            financaAtualizada.setId_equipe(financas.getId_equipe());
            return financasRepository.save(financaAtualizada);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletarFinancas(int id){
        financasRepository.deleteById(id);
    }

}

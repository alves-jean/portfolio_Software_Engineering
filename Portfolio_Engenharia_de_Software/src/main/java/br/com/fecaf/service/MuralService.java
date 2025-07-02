package br.com.fecaf.service;

import br.com.fecaf.model.Mural;
import br.com.fecaf.repository.MuralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MuralService {

    @Autowired
    private MuralRepository muralRepository;

    public List<Mural> listarMural(){
        return muralRepository.findAll();
    }

    public Mural adicionarMural(Mural novo_mural){
        return muralRepository.save(novo_mural);
    }

    public Mural atualizarMural(int id, Mural mural){
        return muralRepository.findById(id).map(mural_atualizar -> {
            mural_atualizar.setNome_projeto(mural.getNome_projeto());
            mural_atualizar.setData_inicio(mural.getData_inicio());
            mural_atualizar.setData_final(mural.getData_final());
            mural_atualizar.setId_login(mural.getId_login());
            return muralRepository.save(mural_atualizar);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletarMural(int id){
        muralRepository.deleteById(id);
    }

}

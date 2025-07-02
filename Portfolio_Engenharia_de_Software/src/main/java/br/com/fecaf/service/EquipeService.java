package br.com.fecaf.service;

import br.com.fecaf.model.Equipe;
import br.com.fecaf.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> listarEquipe(){
        return equipeRepository.findAll();
    }

    public Equipe adicionarEquipe(Equipe nova_equipe){
        return equipeRepository.save(nova_equipe);
    }

    public Equipe atualizarEquipe(int id, Equipe equipe){
        return equipeRepository.findById(id).map(equipeAtualizada -> {
            equipeAtualizada.setId_login(equipe.getId_login());
            equipeAtualizada.setId_mural(equipe.getId_mural());
            return equipeRepository.save(equipeAtualizada);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletarEquipe(int id){
        equipeRepository.deleteById(id);
    }

}

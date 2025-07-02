package br.com.fecaf.controller;

import br.com.fecaf.model.Equipe;
import br.com.fecaf.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipe")
@CrossOrigin(origins = "*")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public List<Equipe> listarEquipe(){
        return equipeService.listarEquipe();
    }

    @PostMapping
    public ResponseEntity<Equipe> adicionarEquipe(@RequestBody Equipe equipe){
        Equipe novaEquipe = equipeService.adicionarEquipe(equipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEquipe);
    }

    @PutMapping("/{id}")
    public Equipe atualizarEquipe(@PathVariable int id, @RequestBody Equipe equipe){
        return equipeService.atualizarEquipe(id, equipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEquipe(@PathVariable int id){
        equipeService.deletarEquipe(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

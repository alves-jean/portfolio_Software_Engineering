package br.com.fecaf.controller;

import br.com.fecaf.model.Mural;
import br.com.fecaf.service.MuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mural")
@CrossOrigin(origins = "*")
public class MuralController {

    @Autowired
    private MuralService muralService;

    @GetMapping
    public List<Mural> listarMural(){
        return muralService.listarMural();
    }

    @PostMapping
    public ResponseEntity<Mural> adicionarMural(@RequestBody Mural mural){
        Mural novo_mural = muralService.adicionarMural(mural);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_mural);
    }

    @PutMapping("/{id}")
    public Mural atualizarMural(@PathVariable int id, @RequestBody Mural novo_mural){
        return muralService.atualizarMural(id, novo_mural);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMural(@PathVariable int id){
        muralService.deletarMural(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

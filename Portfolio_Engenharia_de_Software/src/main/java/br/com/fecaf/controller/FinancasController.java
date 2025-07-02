package br.com.fecaf.controller;

import br.com.fecaf.model.Financas;
import br.com.fecaf.service.FinancasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financas")
@CrossOrigin(origins = "*")
public class FinancasController {

    @Autowired
    private FinancasService financasService;

    @GetMapping
    public List<Financas> listarFinancas(){
        return financasService.listarFinancas();
    }

    @PostMapping
    public ResponseEntity<Financas> adicionarFinancas(@RequestBody Financas financas){
        Financas novaFinancas = financasService.adicionarFinancas(financas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaFinancas);
    }

    @PutMapping("/{id}")
    public Financas atualizarFinancas(@PathVariable int id, @RequestBody Financas financas){
        return financasService.atualizarFinancas(id, financas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFinancas(@PathVariable int id){
        financasService.deletarFinancas(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}

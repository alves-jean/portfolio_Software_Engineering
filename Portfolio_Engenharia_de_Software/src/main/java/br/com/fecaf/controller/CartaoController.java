package br.com.fecaf.controller;

import br.com.fecaf.model.Cartao;
import br.com.fecaf.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
@CrossOrigin(origins = "*")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    public List<Cartao> listarCartao(){
        return cartaoService.listarCartao();
    }

    @PostMapping
    public ResponseEntity<Cartao> adicionarCartao(@RequestBody Cartao cartao){
        Cartao novo_cartao = cartaoService.adicionarCartao(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_cartao);
    }

    @PutMapping("/{id}")
    public Cartao atualizarCartao(@PathVariable int id, @RequestBody Cartao novo_cartao){
        return cartaoService.atualizarCartao(id, novo_cartao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCartao(@PathVariable int id){
        cartaoService.deletarCartao(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

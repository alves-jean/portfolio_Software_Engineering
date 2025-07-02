package br.com.fecaf.controller;

import br.com.fecaf.model.Login;
import br.com.fecaf.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public List<Login> listarLogin(){
        return loginService.listarLogin();
    }

    @PostMapping
    public ResponseEntity<Login> adicionarLogin(@RequestBody Login login){
        Login novo_login =loginService.adicionarLogin(login);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo_login);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLogin(@PathVariable int id){
        loginService.deletarLogin(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

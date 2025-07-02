package br.com.fecaf.service;

import br.com.fecaf.model.Login;
import br.com.fecaf.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<Login> listarLogin(){
        return loginRepository.findAll();
    }

    public Login adicionarLogin(Login novo_login){
        return loginRepository.save(novo_login);
    }

    public void deletarLogin(int id){
        loginRepository.deleteById(id);
    }

}

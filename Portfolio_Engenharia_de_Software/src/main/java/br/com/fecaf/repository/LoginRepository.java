package br.com.fecaf.repository;

import br.com.fecaf.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}

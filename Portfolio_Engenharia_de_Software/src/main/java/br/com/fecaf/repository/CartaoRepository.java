package br.com.fecaf.repository;

import br.com.fecaf.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
}

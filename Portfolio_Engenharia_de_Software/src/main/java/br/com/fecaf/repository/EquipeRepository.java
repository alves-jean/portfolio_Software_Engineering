package br.com.fecaf.repository;

import br.com.fecaf.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
}

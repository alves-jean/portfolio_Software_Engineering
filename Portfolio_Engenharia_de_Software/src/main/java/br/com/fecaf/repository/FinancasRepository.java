package br.com.fecaf.repository;

import br.com.fecaf.model.Financas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancasRepository extends JpaRepository<Financas, Integer> {
}

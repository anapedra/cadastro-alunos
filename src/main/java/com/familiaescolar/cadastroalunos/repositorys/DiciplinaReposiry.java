package com.familiaescolar.cadastroalunos.repositorys;

import com.familiaescolar.cadastroalunos.model.Diciplinas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiciplinaReposiry extends CrudRepository<Diciplinas, Long> {
}

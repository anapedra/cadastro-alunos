package com.familiaescolar.cadastroalunos.repositorys;

import com.familiaescolar.cadastroalunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Aluno, Long> {
}

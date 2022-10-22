package com.familiaescolar.cadastroalunos.repositorys;

import com.familiaescolar.cadastroalunos.model.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {

}

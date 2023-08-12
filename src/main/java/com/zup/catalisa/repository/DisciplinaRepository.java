package com.zup.catalisa.repository;

import com.zup.catalisa.model.Curso;
import com.zup.catalisa.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}

package com.luan.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luan.crm.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}

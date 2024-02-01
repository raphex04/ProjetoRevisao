package com.projetorevisao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetorevisao.entities.Tarefa;

public interface TarefaRepository  extends JpaRepository<Tarefa, Long>{

}
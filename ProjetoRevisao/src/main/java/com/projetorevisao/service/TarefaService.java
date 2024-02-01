package com.projetorevisao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetorevisao.entities.Tarefa;
import com.projetorevisao.repository.TarefaRepository;

@Service 
public class TarefaService {
	private final TarefaRepository terefaRepository;
	
	@Autowired
	public TarefaService(TarefaRepository terefaRepository) {
		this.terefaRepository = terefaRepository;
	}
	public List<Tarefa> buscaTodosTarefa(){
		return terefaRepository.findAll();
	}
	public Tarefa buscaTarefaId(Long id) {
		Optional<Tarefa> Tarefa = terefaRepository.findById(id);
		return Tarefa.orElse(null);
	}
	public Tarefa salvaTarefa(Tarefa tarefa) {
		return terefaRepository.save(tarefa);
	}
	public Tarefa alterartarefa(Long id, Tarefa alterarTarefa) {
		Optional <Tarefa> existeTarefa = terefaRepository.findById(id);
		if(existeTarefa.isPresent()) {
			alterarTarefa.setId(id);
			return terefaRepository.save(alterarTarefa);
		}
		return null;
	}
	public boolean apagarTarefa(Long id) {
		Optional <Tarefa> existeTarefa = terefaRepository.findById(id);
		if (existeTarefa.isPresent()) {
			terefaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

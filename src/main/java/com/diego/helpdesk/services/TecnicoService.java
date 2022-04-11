package com.diego.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.helpdesk.domain.Tecnico;
import com.diego.helpdesk.repository.TecnicoRepository;
import com.diego.helpdesk.services.exception.ObjectnotFoundException;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

}

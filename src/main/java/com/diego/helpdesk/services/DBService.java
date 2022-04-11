package com.diego.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.helpdesk.domain.Chamado;
import com.diego.helpdesk.domain.Cliente;
import com.diego.helpdesk.domain.Tecnico;
import com.diego.helpdesk.domain.enums.Perfil;
import com.diego.helpdesk.domain.enums.Prioridade;
import com.diego.helpdesk.domain.enums.Status;
import com.diego.helpdesk.repository.ChamadoRepository;
import com.diego.helpdesk.repository.ClienteRepository;
import com.diego.helpdesk.repository.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Diego Teodoro Alves", "84528251027", "diego@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "52220211738", "linusTorva@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}

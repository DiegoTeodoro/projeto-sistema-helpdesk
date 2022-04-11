package com.diego.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.helpdesk.domain.Tecnico;
import com.diego.helpdesk.domain.TecnicoDTO;
import com.diego.helpdesk.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService tenicoServive;
	
	@GetMapping("/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		Tecnico obj = tenicoServive.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}

}

package cinema.web.controller;

import java.util.List;

import cinema.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.model.Sala;
import cinema.service.SalaService;
import cinema.support.SalaToSalaDto;
import cinema.web.dto.SalaDTO;

@Repository
@RequestMapping(value = "/api/sale", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private SalaToSalaDto toSalaDto;
	
	@GetMapping
	public ResponseEntity<List<SalaDTO>> getAll(){
		List<Sala> s = salaService.findAll();
		
		return new ResponseEntity<>(toSalaDto.convert(s), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SalaDTO> getOne(@PathVariable Long id){
		Sala sala = salaService.findOne(id);

		if(sala != null) {
			return new ResponseEntity<>(toSalaDto.convert(sala), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Sala obrisanaSala = salaService.delete(id);

		if(obrisanaSala != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

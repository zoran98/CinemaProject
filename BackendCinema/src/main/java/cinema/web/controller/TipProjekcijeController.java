package cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.model.TipProjekcije;
import cinema.service.TipProjekcijeService;
import cinema.support.TipProjekcijeToTipProjekcijeDto;
import cinema.web.dto.TipProjekcijeDTO;

@Repository
@RequestMapping(value = ("/api/tipoviProjekcija"), produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TipProjekcijeController {
	
	@Autowired
	private TipProjekcijeService tipProjekcijeService;
	
	@Autowired
	private TipProjekcijeToTipProjekcijeDto toTipProjekcijeDto;
	
	@GetMapping
	public ResponseEntity<List<TipProjekcijeDTO>> getAll(){
		List<TipProjekcije> tp = tipProjekcijeService.findAll();
		
		return new ResponseEntity<>(toTipProjekcijeDto.convert(tp), HttpStatus.OK);
	}

}

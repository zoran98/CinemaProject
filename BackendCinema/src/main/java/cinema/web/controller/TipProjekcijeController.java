package cinema.web.controller;

import java.util.List;

import cinema.model.Sala;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<TipProjekcijeDTO> getOne(@PathVariable Long id){
		TipProjekcije tipProjekcije = tipProjekcijeService.findOne(id);

		if(tipProjekcije != null) {
			return new ResponseEntity<>(toTipProjekcijeDto.convert(tipProjekcije), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		TipProjekcije obrisanTipProjekcije = tipProjekcijeService.delete(id);

		if(obrisanTipProjekcije != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

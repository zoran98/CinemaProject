package cinema.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Projekcija;
import cinema.service.ProjekcijaService;
import cinema.support.ProjekcijaToProjekcijaDto;
import cinema.web.dto.ProjekcijaDTO;

@RestController
@RequestMapping(value = "/api/projekcije", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ProjekcijaController {
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private ProjekcijaToProjekcijaDto toProjekcijaDto;
	
	//@PreAuthorize("hasRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<ProjekcijaDTO>> getAll(@RequestParam(value = "filmId", required = false) Long filmId,
			@RequestParam(value = "datumIVremePrikazivanjaOd", required = false) LocalDateTime datumIVremePrikazivanjaOd,
			@RequestParam(value = "datumIVremePrikazivanjaDo", required = false) LocalDateTime datumIVremePrikazivanjaDo,
			@RequestParam(value = "tipProjekcijeId", required = false) Long tipProjekcijeId,
			@RequestParam(value = "salaId", required = false) Long salaId,
			@RequestParam(value = "cenaKarteOd", required = false) Double cenaKarteOd,
			@RequestParam(value = "cenaKarteDo", required = false) Double cenaKarteDo,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		
			Page<Projekcija> page = null;
			if(filmId != null || tipProjekcijeId != null || salaId != null) {
				page = projekcijaService.search(filmId, tipProjekcijeId, salaId, pageNo);
			} else if(datumIVremePrikazivanjaOd != null || datumIVremePrikazivanjaDo != null) {
				page = projekcijaService.findByDate(datumIVremePrikazivanjaOd, datumIVremePrikazivanjaDo, pageNo);
			} else if(cenaKarteOd != null || cenaKarteDo != null) {
				page = projekcijaService.findByCenaKarte(cenaKarteOd, cenaKarteDo, pageNo);
			} else {
				page = projekcijaService.findAll(pageNo);
			}
				
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toProjekcijaDto.convert(page.getContent()),headers, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<ProjekcijaDTO> getOne(@PathVariable Long id){
		Projekcija projekcija = projekcijaService.findOne(id);

		if(projekcija != null) {
			return new ResponseEntity<>(toProjekcijaDto.convert(projekcija), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

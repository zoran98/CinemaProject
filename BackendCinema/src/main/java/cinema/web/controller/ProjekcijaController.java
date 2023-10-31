package cinema.web.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Projekcija;
import cinema.service.ProjekcijaService;
import cinema.support.ProjekcijaDtoToProjekcija;
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
	
	@Autowired
	private ProjekcijaDtoToProjekcija toProjekcija;
	
	//@PreAuthorize("hasRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<ProjekcijaDTO>> getAll(@RequestParam(value = "filmId", required = false) Long filmId,
			@RequestParam(value = "datumIVremePrikazivanjaOd", required = false) String datumIVremePrikazivanjaOd,
			@RequestParam(value = "datumIVremePrikazivanjaDo", required = false) String datumIVremePrikazivanjaDo,
			@RequestParam(value = "tipProjekcijeId", required = false) Long tipProjekcijeId,
			@RequestParam(value = "salaId", required = false) Long salaId,
			@RequestParam(value = "cenaKarteOd", required = false) Double cenaKarteOd,
			@RequestParam(value = "cenaKarteDo", required = false) Double cenaKarteDo,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		
			Page<Projekcija> page = null;
			if(filmId != null || tipProjekcijeId != null || salaId != null) {
				page = projekcijaService.search(filmId, tipProjekcijeId, salaId, pageNo);
			} else if(datumIVremePrikazivanjaOd != null || datumIVremePrikazivanjaDo != null) {
				
				LocalDateTime datumIVremeOd = getLocalDateTime(datumIVremePrikazivanjaOd);
				LocalDateTime datumIVremeDo = getLocalDateTime(datumIVremePrikazivanjaDo);
				
				page = projekcijaService.findByDate(datumIVremeOd, datumIVremeDo, pageNo);
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
	
	//@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjekcijaDTO> create(@Valid @RequestBody ProjekcijaDTO projekcijaDTO){
		Projekcija projekcija = toProjekcija.convert(projekcijaDTO);
		Projekcija sacuvanaProjekcija = projekcijaService.save(projekcija);

		return new ResponseEntity<>(toProjekcijaDto.convert(sacuvanaProjekcija), HttpStatus.CREATED);
	}
	
	private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }

}

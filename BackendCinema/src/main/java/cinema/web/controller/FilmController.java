package cinema.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Film;
import cinema.service.FilmService;
import cinema.support.FilmDtoToFilm;
import cinema.support.FilmToFilmDto;
import cinema.web.dto.FilmDTO;

@RestController
@RequestMapping(value="/api/filmovi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private FilmDtoToFilm toFilm;
	
	@Autowired
	private FilmToFilmDto toFilmDto;
	
//	@PreAuthorize("hasRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/forProjections")
	public ResponseEntity<List<FilmDTO>> getAll(){
		
		List<Film> filmovi = filmService.findAll();

		return new ResponseEntity<>(toFilmDto.convert(filmovi), HttpStatus.OK);
	}
	
	//@PreAuthorize("hasRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<FilmDTO>> getAll(@RequestParam(value = "naziv", required = false) String naziv,
					@RequestParam(value = "zanrovi", required = false) String zanrovi,
					@RequestParam(value = "trajanjeOd", required = false) Integer trajanjeOd,
					@RequestParam(value = "trajanjeDo", required = false) Integer trajanjeDo,
					@RequestParam(value = "distributer", required = false) String distributer,
					@RequestParam(value = "zemljaPorekla", required = false) String zemljaPorekla,
					@RequestParam(value = "godinaProizvodnjeOd", required = false) Integer godinaProizvodnjeOd,
					@RequestParam(value = "godinaProizvodnjeDo", required = false) Integer godinaProizvodnjeDo,
		    		@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
				

		//Page<Ljubimac> page = ljubimacService.findAll(pageNo);
		Page<Film> page = null;
		   if(zanrovi != null) {
		      page = filmService.findByZanrovi(zanrovi, pageNo);
		   } else if(distributer != null) {
			  page = filmService.findByDistributer(distributer, pageNo);
		   } else if(zemljaPorekla != null) {
			  page = filmService.findByZemljaPorekla(zemljaPorekla, pageNo);
		   } else if(trajanjeOd != null || trajanjeDo != null) {
			  page = filmService.findByTrajanje(trajanjeOd, trajanjeDo, pageNo);
		   } else if(godinaProizvodnjeOd != null || godinaProizvodnjeDo != null){
			  page = filmService.findByGodinaProizvodnje(godinaProizvodnjeOd, godinaProizvodnjeDo, pageNo);
		   } else if(naziv != null) {
			  page = filmService.findByNaziv(naziv, pageNo);
		   } else {
			  page = filmService.findAll(pageNo);
		   }

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		 return new ResponseEntity<>(toFilmDto.convert(page.getContent()),headers, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FilmDTO> create(@Valid @RequestBody FilmDTO filmDTO){
		Film film = toFilm.convert(filmDTO);
		Film sacuvanFilm = filmService.save(film);

		return new ResponseEntity<>(toFilmDto.convert(sacuvanFilm), HttpStatus.CREATED);
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<FilmDTO> getOne(@PathVariable Long id){
		Film film = filmService.findOne(id);

		if(film != null) {
			return new ResponseEntity<>(toFilmDto.convert(film), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Film obrisanFilm = filmService.delete(id);
		
		if(obrisanFilm != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FilmDTO> update(@PathVariable Long id, @Valid @RequestBody FilmDTO filmDTO){

		if(!id.equals(filmDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Film film = toFilm.convert(filmDTO);
		Film sacuvanFilm = filmService.update(film);

		return new ResponseEntity<>(toFilmDto.convert(sacuvanFilm),HttpStatus.OK);
	}

}

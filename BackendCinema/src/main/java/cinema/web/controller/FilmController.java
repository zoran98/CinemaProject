package cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Film;
import cinema.service.FilmService;
import cinema.support.FilmToFilmDto;
import cinema.web.dto.FilmDTO;

@RestController
@RequestMapping(value="/api/filmovi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private FilmToFilmDto toFilmDto;
	
	//@PreAuthorize("hasRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
//	@GetMapping
//	public ResponseEntity<List<FilmDTO>> getAll(){
//		
//		List<Film> filmovi = filmService.findAll();
//
//		return new ResponseEntity<>(toFilmDto.convert(filmovi), HttpStatus.OK);
//	}
	
	//@PreAuthorize("hasRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<FilmDTO>> getAll(@RequestParam(value = "naziv", required = false) String naziv,
					@RequestParam(value = "zanrovi", required = false) String zanrovi,
					@RequestParam(value = "trajanje", required = false) Integer trajanje,
					@RequestParam(value = "distributer", required = false) String distributer,
					@RequestParam(value = "zemljaPorekla", required = false) String zemljaPorekla,
					@RequestParam(value = "godinaProizvodnje", required = false) Integer godinaProizvodnje,
		    		@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
				

		//Page<Ljubimac> page = ljubimacService.findAll(pageNo);
		Page<Film> page = null;
		   if(naziv != null || zanrovi != null || trajanje != null || distributer != null || zemljaPorekla != null || godinaProizvodnje != null) {
		      page = filmService.search(naziv, zanrovi, trajanje, distributer, zemljaPorekla, godinaProizvodnje, pageNo);
		   } else {
		      page = filmService.findAll(pageNo);
		   }

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		 return new ResponseEntity<>(toFilmDto.convert(page.getContent()),headers, HttpStatus.OK);
	}

}

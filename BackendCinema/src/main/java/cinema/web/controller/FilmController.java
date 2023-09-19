package cinema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@GetMapping
	public ResponseEntity<List<FilmDTO>> getAll(){
		
		List<Film> filmovi = filmService.findAll();

		return new ResponseEntity<>(toFilmDto.convert(filmovi), HttpStatus.OK);
	}

}

package cinema.service;

import java.util.List;

import cinema.model.Film;

public interface FilmService {
	
	Film findOne(Long id);
	List<Film> findAll();

}

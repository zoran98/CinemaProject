package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Film;
import cinema.repository.FilmRepository;
import cinema.service.FilmService;

@Service
public class JpaFilmService implements FilmService{
	
	@Autowired
	private FilmRepository filmRepository;

	@Override
	public Film findOne(Long id) {
		return filmRepository.findOneById(id);
	}

	@Override
	public List<Film> findAll() {
		return filmRepository.findAll();
	}

}

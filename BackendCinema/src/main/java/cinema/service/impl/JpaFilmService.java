package cinema.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

//	@Override
//	public List<Film> findAll() {
//		return filmRepository.findAll();
//	}

	@Override
	public Page<Film> search(String naziv, String zanrovi, Integer trajanje, String distributer, String zemljaPorekla,
			Integer godinaProizvodnje, int pageNo) {
		return filmRepository.search(naziv, zanrovi, trajanje, distributer, zemljaPorekla, godinaProizvodnje, PageRequest.of(pageNo, 10));
	}

	@Override
	public Page<Film> findAll(int pageNo) {
		return filmRepository.findAll(PageRequest.of(pageNo, 10));
	}

}

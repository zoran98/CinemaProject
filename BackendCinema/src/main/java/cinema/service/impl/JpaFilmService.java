package cinema.service.impl;

import java.util.List;
import java.util.Optional;

import cinema.model.Projekcija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cinema.model.Film;
import cinema.repository.FilmRepository;
import cinema.service.FilmService;

import javax.transaction.Transactional;

@Service
public class JpaFilmService implements FilmService{
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Override
	public Film findOne(Long id) {
		return filmRepository.findOneById(id);
	}

	@Override
	public Page<Film> findAll(int pageNo) {
		return filmRepository.findAll(PageRequest.of(pageNo, 4, Sort.by("naziv").ascending()));
	}

	@Override
	public Page<Film> findByTrajanje(Integer trajanjeOd, Integer trajanjeDo, int pageNo) {
		if(trajanjeOd == null) {
			trajanjeOd = 0;
		}
		if(trajanjeDo == null) {
			trajanjeDo = Integer.MAX_VALUE;
		}
		return filmRepository.findByTrajanjeBetween(trajanjeOd, trajanjeDo, PageRequest.of(pageNo, 4));
	}

	@Override
	public Page<Film> findByGodinaProizvodnje(Integer godinaProizvodnjeOd, Integer godinaProizvodnjeDo, int pageNo) {
		if(godinaProizvodnjeOd == null) {
			godinaProizvodnjeOd = 0;
		}
		if(godinaProizvodnjeDo == null) {
			godinaProizvodnjeDo = Integer.MAX_VALUE;
		}
		return filmRepository.findByGodinaProizvodnjeBetween(godinaProizvodnjeOd, godinaProizvodnjeDo, PageRequest.of(pageNo, 4));
	}

	@Override
	public Film save(Film film) {
		return filmRepository.save(film);
	}


	@Transactional
	@Override
    public Film delete(Long id) {
        Film film = filmRepository.findOneById(id);
        if(film != null){
            filmRepository.delete(film);
            return film;
        }
        return null;
    }


//	@Override
//	@Transactional
//	public Film delete(Long id) {
//		Optional<Film> film = filmRepository.findById(id);
//		if(film.isPresent()){
//			filmRepository.deleteById(id);
//			return film.get();
//		}
//		return null;
//	}

	@Override
	public Film update(Film film) {
		return filmRepository.save(film);
	}

	@Override
	public List<Film> findAll() {
		return filmRepository.findAll();
	}

	@Override
	public Page<Film> findByNaziv(String naziv, int pageNo) {
		return filmRepository.findByNazivContaining(naziv, PageRequest.of(pageNo, 4, Sort.by("naziv").ascending()));
	}

	@Override
	public Page<Film> findByZanrovi(String zanrovi, int pageNo) {
		return filmRepository.findByZanroviContaining(zanrovi, PageRequest.of(pageNo, 4, Sort.by("zanrovi").ascending()));
	}

	@Override
	public Page<Film> findByDistributer(String distributer, int pageNo) {
		return filmRepository.findByDistributerContaining(distributer, PageRequest.of(pageNo, 4, Sort.by("distributer").ascending()));
	}

	@Override
	public Page<Film> findByZemljaPorekla(String zemljaPorekla, int pageNo) {
		return filmRepository.findByZemljaPoreklaContaining(zemljaPorekla, PageRequest.of(pageNo, 4, Sort.by("zemljaPorekla")));
	}


}

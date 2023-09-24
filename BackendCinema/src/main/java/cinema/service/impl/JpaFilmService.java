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
	public Page<Film> search(String naziv, String zanrovi, String distributer, String zemljaPorekla,
			int pageNo) {
		return filmRepository.search(naziv, zanrovi, distributer, zemljaPorekla, PageRequest.of(pageNo, 10));
	}

	@Override
	public Page<Film> findAll(int pageNo) {
		return filmRepository.findAll(PageRequest.of(pageNo, 10));
	}

	@Override
	public Page<Film> findByTrajanje(Integer trajanjeOd, Integer trajanjeDo, int pageNo) {
		if(trajanjeOd == null) {
			trajanjeOd = 0;
		}
		if(trajanjeDo == null) {
			trajanjeDo = Integer.MAX_VALUE;
		}
		return filmRepository.findByTrajanjeBetween(trajanjeOd, trajanjeDo, PageRequest.of(pageNo, 10));
	}

	@Override
	public Page<Film> findByGodinaProizvodnje(Integer godinaProizvodnjeOd, Integer godinaProizvodnjeDo, int pageNo) {
		if(godinaProizvodnjeOd == null) {
			godinaProizvodnjeOd = 0;
		}
		if(godinaProizvodnjeDo == null) {
			godinaProizvodnjeDo = Integer.MAX_VALUE;
		}
		return filmRepository.findByGodinaProizvodnjeBetween(godinaProizvodnjeOd, godinaProizvodnjeDo, PageRequest.of(pageNo, 10));
	}

//	@Override
//	public Page<Film> find(String naziv, String zanrovi, Integer trajanjeOd, Integer trajanjeDo, String distributer,
//			String zemljaPorekla, Integer godinaProizvodnjeOd, Integer godinaProizvodnjeDo, int pageNo) {
//		return filmRepository.findByNazivIgnoreCaseContainsAndZanroviIgnoreCaseContainsAndTrajanjeBetweenAndDistributerAndZemljaPoreklaAndGodinaProizvodnjeBetween(
//				naziv, zanrovi, trajanjeOd, trajanjeDo, distributer, zemljaPorekla, godinaProizvodnjeOd, 
//				godinaProizvodnjeDo, PageRequest.of(pageNo, 10));
//	}

}

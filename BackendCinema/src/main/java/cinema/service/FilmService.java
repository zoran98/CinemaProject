package cinema.service;


import java.util.List;

import org.springframework.data.domain.Page;

import cinema.model.Film;

public interface FilmService {
	
	Film findOne(Long id);
	
	List<Film> findAll();
	
	Page<Film> findAll(int pageNo);
	
//	Page<Film> search(String zanrovi, String distributer, String zemljaPorekla, int pageNo);
	
//	Page<Film> find(String naziv, String zanrovi, Integer trajanjeOd, Integer trajanjeDo, String distributer, String zemljaPorekla, Integer godinaProizvodnjeOd,
//			Integer godinaProizvodnjeDo, int pageNo);
	
	Page<Film> findByTrajanje(Integer trajanjeOd, Integer trajanjeDo, int pageNo);
	
	Page<Film> findByGodinaProizvodnje(Integer godinaProizvodnjeOd, Integer godinaProizvodnjeDo, int pageNo);
	
	Page<Film> findByNaziv(String naziv, int pageNo);
	
	Page<Film> findByZanrovi(String zanrovi, int pageNo);
	
	Page<Film> findByDistributer(String distributer, int pageNo);
	
	Page<Film> findByZemljaPorekla(String zemljaPorekla, int pageNo);
	
	Film save(Film film);
	
	Film delete(Long id);
	
	Film update(Film film);

}

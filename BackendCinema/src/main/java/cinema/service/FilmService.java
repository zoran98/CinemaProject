package cinema.service;


import org.springframework.data.domain.Page;

import cinema.model.Film;

public interface FilmService {
	
	Film findOne(Long id);
	
//	List<Film> findAll();
	
	Page<Film> findAll(int pageNo);
	
	Page<Film> search(String naziv, String zanrovi, Integer trajanje, String distributer, String zemljaPorekla,
			Integer godinaProizvodnje, int pageNo);
	
//	Page<Film> find(String naziv, String zanrovi, Integer trajanjeOd, Integer trajanjeDo, String distributer, String zemljaPorekla, Integer godinaProizvodnjeOd,
//			Integer godinaProizvodnjeDo, int pageNo);

}

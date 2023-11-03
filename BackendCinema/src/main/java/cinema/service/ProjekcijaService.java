package cinema.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;

import cinema.model.Projekcija;

public interface ProjekcijaService {
	
	Projekcija findOne(Long id);
	
	Page<Projekcija> findAll(int pageNo);
	
	Page<Projekcija> search(Long filmId, Long tipProjekcijeId, Long salaId, int pageNo);
	
	Page<Projekcija> findByDate(LocalDateTime datumIVremePrikazivanjaOd, LocalDateTime datumIVremePrikazivanjaDo, int pageNo);
	
	Page<Projekcija> findByCenaKarte(Double cenaKarteOd, Double cenaKarteDo, int pageNo);
	
	Projekcija save(Projekcija projekcija);
	
	List<Projekcija> findByFilmId(Long filmId);
	
	Projekcija delete(Long id);

}

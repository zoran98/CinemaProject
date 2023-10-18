package cinema.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cinema.model.Projekcija;
import cinema.repository.ProjekcijaRepository;
import cinema.service.ProjekcijaService;

@Service
public class JpaProjekcijaService implements ProjekcijaService{
	
	@Autowired
	private ProjekcijaRepository projekcijaRepository;

	@Override
	public Projekcija findOne(Long id) {
		return projekcijaRepository.findOneById(id);
	}

	@Override
	public Page<Projekcija> findAll(int pageNo) {
		return projekcijaRepository.findAll(PageRequest.of(pageNo, 10));
	}

	@Override
	public Page<Projekcija> search(Long filmId, Long tipProjekcijeId, Long salaId, int pageNo) {
		return projekcijaRepository.search(filmId, tipProjekcijeId, salaId, PageRequest.of(pageNo, 4));
	}

	@Override
	public Page<Projekcija> findByDate(LocalDateTime datumIVremePrikazivanjaOd, LocalDateTime datumIVremePrikazivanjaDo,
			int pageNo) {
		if(datumIVremePrikazivanjaOd == null) {
			datumIVremePrikazivanjaOd = LocalDateTime.MIN;
		}
		if(datumIVremePrikazivanjaDo == null) {
			datumIVremePrikazivanjaDo = LocalDateTime.MAX;
		}
		return projekcijaRepository.findByDatumIVremePrikazivanjaBetween(datumIVremePrikazivanjaOd, datumIVremePrikazivanjaDo, PageRequest.of(pageNo, 4));
	}

	@Override
	public Page<Projekcija> findByCenaKarte(Double cenaKarteOd, Double cenaKarteDo, int pageNo) {
		if(cenaKarteOd == null) {
			cenaKarteOd = 0.0;
		}
		if(cenaKarteDo == null) {
			cenaKarteDo = Double.MAX_VALUE;
		}
		return projekcijaRepository.findByCenaKarteBetween(cenaKarteOd, cenaKarteDo, PageRequest.of(pageNo, 4));
	}

}

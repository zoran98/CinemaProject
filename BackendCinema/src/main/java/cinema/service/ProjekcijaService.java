package cinema.service;

import org.springframework.data.domain.Page;

import cinema.model.Projekcija;

public interface ProjekcijaService {
	
	Projekcija findOne(Long id);
	Page<Projekcija> findAll(int pageNo);

}

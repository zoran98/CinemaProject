package cinema.service.impl;

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

}

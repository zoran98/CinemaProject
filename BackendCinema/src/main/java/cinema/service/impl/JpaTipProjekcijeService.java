package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.TipProjekcije;
import cinema.repository.TipProjekcijeRepository;
import cinema.service.TipProjekcijeService;

@Service
public class JpaTipProjekcijeService implements TipProjekcijeService{
	
	@Autowired
	private TipProjekcijeRepository tiprProjekcijeRepository;

	@Override
	public TipProjekcije findOne(Long id) {
		return tiprProjekcijeRepository.findOneById(id);
	}

	@Override
	public List<TipProjekcije> findAll() {
		return tiprProjekcijeRepository.findAll();
	}

}

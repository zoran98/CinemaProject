package cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.TipProjekcije;
import cinema.repository.TipProjekcijeRepository;
import cinema.service.TipProjekcijeService;

@Service
public class JpaTipProjekcijeService implements TipProjekcijeService{
	
	@Autowired
	private TipProjekcijeRepository tipProjekcijeRepository;

	@Override
	public TipProjekcije findOne(Long id) {
		return tipProjekcijeRepository.findOneById(id);
	}

	@Override
	public List<TipProjekcije> findAll() {
		return tipProjekcijeRepository.findAll();
	}

	@Override
	public TipProjekcije delete(Long id) {
		Optional<TipProjekcije> tipProjekcije = tipProjekcijeRepository.findById(id);
		if(tipProjekcije.isPresent()){
			tipProjekcijeRepository.deleteById(id);
			return tipProjekcije.get();
		}
		return null;
	}

}

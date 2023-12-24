package cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Sala;
import cinema.repository.SalaRepository;
import cinema.service.SalaService;

@Service
public class JpaSalaService implements SalaService{
	
	@Autowired
	private SalaRepository salaRepository;

	@Override
	public Sala findOne(Long id) {
		return salaRepository.findOneById(id);
	}

	@Override
	public List<Sala> findAll() {
		return salaRepository.findAll();
	}

	@Override
	public Sala delete(Long id) {
		Optional<Sala> sala = salaRepository.findById(id);
		if(sala.isPresent()) {
			salaRepository.deleteById(id);
			return sala.get();
		}
		return null;
	}

}

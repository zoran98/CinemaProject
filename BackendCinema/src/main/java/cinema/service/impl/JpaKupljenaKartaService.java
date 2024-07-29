package cinema.service.impl;

import cinema.model.KupljenaKarta;
import cinema.repository.KupljenaKartaRepository;
import cinema.service.KupljenaKartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaKupljenaKartaService implements KupljenaKartaService {

    @Autowired
    private KupljenaKartaRepository kupljenaKartaRepository;

    @Override
    public KupljenaKarta findOne(Long id) {
        return kupljenaKartaRepository.findOneById(id);
    }

    @Override
    public List<KupljenaKarta> findAll() {
        return kupljenaKartaRepository.findAll();
    }

	@Override
	public KupljenaKarta save(KupljenaKarta kupljenaKarta) {
		return kupljenaKartaRepository.save(kupljenaKarta);
	}
}

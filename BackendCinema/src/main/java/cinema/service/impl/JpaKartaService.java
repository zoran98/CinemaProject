package cinema.service.impl;

import cinema.model.Karta;
import cinema.model.TipProjekcije;
import cinema.repository.KartaRepository;
import cinema.service.KartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaKartaService implements KartaService {

    @Autowired
    private KartaRepository kartaRepository;

    @Override
    public Karta findOne(Long id) {
        return kartaRepository.findOneById(id);
    }

    @Override
    public List<Karta> findAll() {
        return kartaRepository.findAll();
    }

    @Override
    public Karta delete(Long id) {
        Optional<Karta> karta = kartaRepository.findById(id);
        if(karta.isPresent()){
            kartaRepository.deleteById(id);
            return karta.get();
        }
        return null;
    }
}

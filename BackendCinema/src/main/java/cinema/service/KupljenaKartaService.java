package cinema.service;

import cinema.model.KupljenaKarta;

import java.util.List;

public interface KupljenaKartaService {

    KupljenaKarta findOne(Long id);
    List<KupljenaKarta> findAll();
    KupljenaKarta save(KupljenaKarta kupljenaKarta);
}

package cinema.service;

import cinema.model.Karta;

import java.util.List;

public interface KartaService {

    Karta findOne(Long id);

    List<Karta> findAll();
    Karta delete(Long id);
}

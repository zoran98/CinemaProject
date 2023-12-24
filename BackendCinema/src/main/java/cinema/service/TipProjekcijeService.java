package cinema.service;

import java.util.List;

import cinema.model.TipProjekcije;

public interface TipProjekcijeService {
	
	TipProjekcije findOne(Long id);
	
	List<TipProjekcije> findAll();

	TipProjekcije delete(Long id);

}

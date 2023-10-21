package cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.TipProjekcije;

@Repository
public interface TipProjekcijeRepository extends JpaRepository<TipProjekcije, Long>{
	
	TipProjekcije findOneById(Long id);

}

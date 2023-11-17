package cinema.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cinema.model.Projekcija;

@Repository
public interface ProjekcijaRepository extends JpaRepository<Projekcija, Long>{
	
	Projekcija findOneById(Long id);
	
	@Query("SELECT p FROM Projekcija p WHERE" +
			"(:filmId = NULL OR p.film.id = :filmId) AND " +
			"(:tipProjekcijeId = NULL OR p.tipProjekcije.id = :tipProjekcijeId) AND " +
			"(:salaId = NULL OR p.sala.id = :salaId)")
	Page<Projekcija> search(@Param("filmId") Long filmId, @Param("tipProjekcijeId") Long tipProjekcijeId,
			@Param("salaId") Long salaId, Pageable pageable);
	
	Page<Projekcija> findByDatumIVremePrikazivanjaBetween(LocalDateTime datumIVremePrikazivanjaOd, 
			LocalDateTime datumIVremePrikazivanjaDo, Pageable pageable);
	
	Page<Projekcija> findByCenaKarteBetween(Double cenaKarteOd, Double cenaKarteDo, Pageable pageable);
	

}

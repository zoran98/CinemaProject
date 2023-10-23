package cinema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cinema.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
	
	Film findOneById(Long id);
	
//	@Query("SELECT f FROM Film f WHERE" +
//			"(:naziv = NULL OR f.naziv LIKE :naziv) AND " +
//			"(:zanrovi = NULL OR f.zanrovi LIKE :zanrovi) AND " +
//			"(:distributer = NULL OR f.distributer LIKE :distributer) AND " +
//			"(:zemljaPorekla = NULL OR f.zemljaPorekla LIKE :zemljaPorekla)")
//	Page<Film> search(@Param("zanrovi") String zanrovi,
//			@Param("distributer") String distributer, @Param("zemljaPorekla") String zemljaPorekla,
//			Pageable pageable);
	
//	Page<Film> findByNazivIgnoreCaseContainsAndZanroviIgnoreCaseContainsAndTrajanjeBetweenAndDistributerAndZemljaPoreklaAndGodinaProizvodnjeBetween(
//			String naziv, String zanrovi, Integer trajanjeOd, Integer trajanjeDo, String distributer, String zemljaPorekla, Integer godinaProizvodnjeOd,
//			Integer godinaProizvodnjeDo, Pageable pageable);
	
	Page<Film> findByTrajanjeBetween(Integer trajanjeOd, Integer trajanjeDo, Pageable pageable);
	
	Page<Film> findByGodinaProizvodnjeBetween(Integer godinaProizvodnjeOd, Integer godinaProizvodnjeDo, Pageable pageable);
	
	Page<Film> findByNazivContaining(String naziv, Pageable pageable);
	
	Page<Film> findByZanroviContaining(String zanrovi, Pageable pageable);
	
	Page<Film> findByDistributerContaining(String distributer, Pageable pageable);
	
	Page<Film> findByZemljaPoreklaContaining(String zemljaPorekla, Pageable pageable);

}

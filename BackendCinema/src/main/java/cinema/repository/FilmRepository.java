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
	
	@Query("SELECT f FROM Film f WHERE" +
			"(:naziv = NULL OR f.naziv LIKE :naziv) AND " +
			"(:zanrovi = NULL OR f.zanrovi LIKE :zanrovi) AND " +
			"(:trajanje = NULL OR f.trajanje = :trajanje) AND " + 
			"(:distributer = NULL OR f.distributer LIKE :distributer) AND " +
			"(:zemljaPorekla = NULL OR f.zemljaPorekla LIKE :zemljaPorekla) AND " +
			"(:godinaProizvodnje = NULL OR f.godinaProizvodnje = :godinaProizvodnje)")
	Page<Film> search(@Param("naziv") String naziv, @Param("zanrovi") String zanrovi, @Param("trajanje") Integer trajanje,
			@Param("distributer") String distributer, @Param("zemljaPorekla") String zemljaPorekla,
			@Param("godinaProizvodnje") Integer godinaProizvodnje, Pageable pageable);

}

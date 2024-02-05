package cinema.repository;

import cinema.model.KupljenaKarta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KupljenaKartaRepository extends JpaRepository<KupljenaKarta, Long> {

    KupljenaKarta findOneById(Long id);
}

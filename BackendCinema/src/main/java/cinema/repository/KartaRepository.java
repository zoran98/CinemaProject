package cinema.repository;

import cinema.model.Karta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KartaRepository extends JpaRepository<Karta, Long> {

    Karta findOneById(Long id);
}

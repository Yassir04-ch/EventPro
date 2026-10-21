package ma.eventpro.repository;

import ma.eventpro.entity.Billet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BilletRepository extends JpaRepository<Billet , Long> {
    Optional<Billet> findByCode(String code);

    List<Billet> findByLineReservationReservationId(Long reservationId);
}

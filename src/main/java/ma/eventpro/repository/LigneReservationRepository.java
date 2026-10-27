package ma.eventpro.repository;

import ma.eventpro.entity.LigneReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LigneReservationRepository extends JpaRepository<LigneReservation, Long> {
    List<LigneReservation> findByReservationId(Long reservationId);

    List<LigneReservation> findByCategorieBilletId(Long categorieBilletId);

    int sumQuantityByClientAndCategorie(UUID clientId, Long categorieId);

}

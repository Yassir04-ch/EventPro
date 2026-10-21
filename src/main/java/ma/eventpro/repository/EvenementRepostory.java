package ma.eventpro.repository;

import ma.eventpro.entity.Evenement;
import ma.eventpro.entity.enums.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EvenementRepostory extends JpaRepository<Evenement , Long> {
    List<Evenement> findByStatus(EventStatus status);
    List<Evenement> findByOrganisateurId(Long organisateurId);
}

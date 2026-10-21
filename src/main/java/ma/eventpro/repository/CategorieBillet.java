package ma.eventpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieBillet extends JpaRepository<CategorieBillet , Long> {
    List<CategorieBillet> findByEvenementId(Long evenementId);
    boolean existsByEvenementName(String name);
}

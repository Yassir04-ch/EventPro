package ma.eventpro.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.eventpro.dto.request.EventCreateRequest;
import ma.eventpro.dto.responce.EvenementResponse;
import ma.eventpro.entity.Evenement;
import ma.eventpro.entity.Organisateur;
import ma.eventpro.entity.enums.EventStatus;
import ma.eventpro.exception.ConflictException;
import ma.eventpro.exception.EventNotFound;
import ma.eventpro.exception.OrganisateurNotFound;
import ma.eventpro.mapper.EvenementMapper;
import ma.eventpro.repository.EvenementRepostory;
import ma.eventpro.repository.OrganisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EvenementRepostory evenementRepostory;
    private final OrganisateurRepository organisateurRepository;
    private final EvenementMapper evenementMapper;

    @Transactional
    public EvenementResponse createEvent(EventCreateRequest request){
        Organisateur organisateur = organisateurRepository.findById(request.getOrganisateurId())
                .orElseThrow(()->new OrganisateurNotFound("Organisateur not found"));
        Evenement evenement = evenementMapper.toEntity(request);
        evenement.setOrganisateur(organisateur);
        return evenementMapper.toResponse(evenementRepostory.save(evenement));
    }

    @Transactional
    public EvenementResponse publishEvent(long id){
        Evenement evenement = evenementRepostory.findById(id)
                .orElseThrow(() -> new EventNotFound("Evenement not found"));
        evenement.setStatus(EventStatus.PUBLISHED);
        return evenementMapper.toResponse(evenement);
    }

    @Transactional
    public EvenementResponse cancelEvent(Long id) {
        Evenement evenement = evenementRepostory.findById(id)
                .orElseThrow(() -> new EventNotFound("Evenement not found"));;
        evenement.setStatus(EventStatus.CANCELED);
        return evenementMapper.toResponse(evenement);
    }


    @Transactional
    public List<Evenement> getPublishedEvents() {
        return evenementRepostory.findByStatus(EventStatus.PUBLISHED);
    }

    @Transactional
    public EvenementResponse getById(Long id) {
        Evenement evenement = evenementRepostory.findById(id)
                .orElseThrow(() -> new EventNotFound("Evenement not found"));;
        return evenementMapper.toResponse(evenement);
    }

}

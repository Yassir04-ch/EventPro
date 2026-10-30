package ma.eventpro.service;

import lombok.RequiredArgsConstructor;
import ma.eventpro.dto.request.RemboursementCreateRequest;
import ma.eventpro.dto.response.RemboursementResponse;
import ma.eventpro.entity.Evenement;
import ma.eventpro.entity.LigneReservation;
import ma.eventpro.entity.Paiement;
import ma.eventpro.entity.Reservation;
import ma.eventpro.entity.enums.PaymentStatus;
import ma.eventpro.exception.ConflictException;
import ma.eventpro.exception.PaiementNotFound;
import ma.eventpro.exception.ReservationNotFound;
import ma.eventpro.exception.ValidationException;
import ma.eventpro.mapper.RemboursementMapper;
import ma.eventpro.repository.PaiementRepository;
import ma.eventpro.repository.RemboursementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RemboursementService {
    private final RemboursementRepository remboursementRepository;
    private final ReservationService reservationService;
    private final RemboursementMapper remboursementMapper;
    private final PaiementRepository paiementRepository;

    public RemboursementResponse creatRemboursement(RemboursementCreateRequest request){
        Long clientId = request.getClientId();
        Long paiementId = request.getPaiementId();
        Paiement paiement = paiementRepository.findById(paiementId)
                .orElseThrow(()->new PaiementNotFound("paiement not found"));
        validePaiement(paiement);
        Reservation reservation = paiement.getReservation();
        LigneReservation lignes = reservation.getLines().stream().findFirst()
                .orElseThrow(()-> new ReservationNotFound("reservation not found"));
        Evenement evenement = lignes.getCategorieBillet().getEvenement();
    }

    public void validePaiement(Paiement paiement){
        if(paiement.getStatus() != PaymentStatus.SUCCESS){
            throw new ValidationException("Imposible remboursée une paiement  un paiement qui n'a pas été effectué avec succès");
        }
        if(remboursementRepository.existsByPaymentId(paiement.getId())){
            throw new ConflictException("Ce paiement a déja été remboursé");
        }
    }

}
